package other;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ZwTest {


    /**
     *
     * @param rawResult 查询的库存结果数组
     * @param planDetailMap2 计划和计划详情
     * @param wareHouseHasCar 已派车和正在装车的跺位
     * @return
     */
    public Map<String, Map<String, Map<String, Object>>> product(List<Map<String,Object>> rawResult,
                        Map<String, Map<String, BigDecimal>> planDetailMap2,
                        Set<String> wareHouseHasCar,
                        Map<String,Map<String,BigDecimal>> contractToCargoMap){
        Map<String,Map<String,Map<String,Object>>> resultMap=new HashMap<>();
        for (Map<String,Object> rawMap:rawResult){
            //先获取跺位号
            String cargoLocation = (String) rawMap.get("cargoLocation");
            //如果该跺位已经派车或者已经有车了就跳过
            if (wareHouseHasCar.contains(cargoLocation)){
                continue;
            }
            //获取合同号
            String contract = (String) rawMap.get("contractNumber");
            //获取订单号
            String agreement= (String) rawMap.get("agreementNumber");
            //通过合同号获取该合同的订单详情
            Map<String, BigDecimal> planDetailMap = planDetailMap2.get(contract);
            BigDecimal planDetailWeight=null;
            //查询是否有该合同和该合同的订单详请
            if (planDetailMap==null||(planDetailWeight=planDetailMap.get(agreement))==null){
                continue;
            }
            //获取重量
            String weightString= (String) rawMap.get("allWeight");
            BigDecimal weight=new BigDecimal(weightString);

            Map<String, Map<String, Object>> cargoLocationMap = resultMap.get(cargoLocation);
            if (cargoLocationMap==null){
                cargoLocationMap=new HashMap<>();
                resultMap.put(cargoLocation, cargoLocationMap);
            }
            Map<String, Object> contractMap = cargoLocationMap.get(contract);
            if (contractMap==null){
                contractMap=new HashMap<>();
                cargoLocationMap.put(contract, contractMap);
            }
            weight=weight.compareTo(planDetailWeight)>0? planDetailWeight:weight;
            if (weight.compareTo(BigDecimal.ZERO)<=0){
                continue;
            }
            BigDecimal contractWeight = (BigDecimal) contractMap.get("contractWeight");

            if (contractWeight==null){
                contractWeight=weight;
            }else {
                contractWeight=contractWeight.add(weight);
            }
            contractMap.put(agreement,weight);
            contractMap.put("contractWeight",contractWeight);
            //保存合同与跺位的映射信息
            //封装合同与跺位的信息
            Map<String, BigDecimal> cargoMap = contractToCargoMap.get(contract);
            if (cargoMap==null){
                cargoMap=new HashMap<>();
                contractToCargoMap.put(contract, cargoMap);
            }
            cargoMap.put(cargoLocation, contractWeight);
        }
        return resultMap;
    }

    /**
     * @param resultMap 封装的跺位信息结果
     * @param contractSet 已派过车的跺位号
     * @return 要发车的跺位号和
     */
    public List<Map<String,String>> info(Map<String,Map<String,Map<String,Object>>> resultMap,
                                         Set<String> contractSet){
        List<Map<String,Object>> mapForSort=new ArrayList<>();//为了排序

        Map<String,Map<String,Object>> cargoSortInfo=new HashMap<>();//key为垛位号，value和mapForSort的某个唯一的节点
        //已派车的，并被选中将派车的合同与跺位映射
        Map<String,Set<Map<String,Object>>> contractInSortAndDis=new HashMap<>();
        //创建集合还未发车的集合
        Set<String> contractNoDispatcherSet=new HashSet<>();
        //未派车并且将被选中派车的
        Map<String,Set<Map<String,Object>>> contractInSortNoDis=new HashMap<>();
        //各个垛位要
        Set<String> cargoLocationSet = resultMap.keySet();//还可发车的跺位的key
        for (String cargoLocation:cargoLocationSet){
            Map<String, Map<String, Object>> contractMap = resultMap.get(cargoLocation);
            //如果没有合同信息就跳过
            if (contractMap==null||contractMap.size()==0){
                continue;
            }
            Set<String> contracts = contractMap.keySet();
            String maxContract=null;
            BigDecimal bigDecimal=null;
            Map<String,Object> map=new HashMap<>();
            for (String contract:contracts){
                Map<String, Object> infoMap = contractMap.get(contract);//获取该垛位该合同的的信息
                if (infoMap==null||infoMap.size()==0){
                    continue;
                }
                int contains=contractSet.contains(contract)? 0:1;//还没有发出就是1
                if (contains==1){
                    contractNoDispatcherSet.add(contract);
                }
                BigDecimal contractWeight = (BigDecimal) infoMap.get("contractWeight");
                if (contractWeight==null||contractWeight.compareTo(BigDecimal.ZERO)<=0){
                    continue;
                }
                if (bigDecimal==null||contractWeight.compareTo(bigDecimal)>0){
                    bigDecimal=contractWeight;
                    maxContract=contract;
                }
            }
            if (maxContract!=null&&bigDecimal!=null){
                map.put("cargoLocation",cargoLocation);
                map.put("contractNumber",maxContract);
                map.put("contractWeight",bigDecimal);
                if (contractSet.contains(maxContract)){
                    map.put("flag", 0);
                    Set<Map<String, Object>> maps = contractInSortAndDis.get(maxContract);
                    if (maps==null){
                        maps=new HashSet<>();
                        contractInSortAndDis.put(maxContract, maps);
                    }
                    maps.add(map);
                }else {
                    map.put("flag", 1);
                    Set<Map<String, Object>> maps = contractInSortNoDis.get(maxContract);
                    if (maps==null){
                        maps=new HashSet<>();
                        contractInSortNoDis.put(maxContract, maps);
                    }
                    maps.add(map);
                }
                mapForSort.add(map);
                cargoSortInfo.put(cargoLocation, map);
            }
        }
        //如果还有没派车的数据
        if (contractNoDispatcherSet!=null||contractNoDispatcherSet.size()!=0){
            Set<String> contractNoDisAndSel=new HashSet<>();
            //获取没派车的
            contractNoDisAndSel.addAll(contractNoDispatcherSet);
            //删除已被选中要的，剩下的就是即没选中还没派车的
            contractNoDisAndSel.removeAll(contractInSortNoDis.keySet());
            //如果有即没选中并且还没派车的
            if (contractNoDisAndSel.size()!=0){
                //先处理已派车并且多选中的
                Set<String> contractInSortKeys = new HashSet<>();
                contractInSortKeys.addAll(contractInSortAndDis.keySet());
                if (contractInSortKeys.size()>0){
                    for (String key:contractInSortKeys){
                        Set<Map<String, Object>> maps = contractInSortNoDis.get(key);
                        if (maps!=null&&maps.size()>1){
                            for (Map<String,Object> map:maps){

                            }
                        }
                    }
                }
            }


        }


        return null;
    }

    /**
     *
     * @param contractAndSortInfo 被选中的合同信息
     * @param contractNoDisAndSel 即没有被派过车还没有被选中的合同
     * @param flag 被选中的合同信息是否是拍过车的
     * @return
     */
    public Set<String> sameContractInContract(Map<String,Set<Map<String,Object>>> contractAndSortInfo,
                                              Set<String> contractNoDisAndSel,
                                              Map<String, Map<String, Map<String, Object>>> cargoInfoMap,
                                              boolean flag){
        Set<String> contractInSortKeys = new HashSet<>(contractAndSortInfo.keySet());
        for (String key:contractInSortKeys){
            Set<Map<String, Object>> maps = contractAndSortInfo.get(key);
            if (flag&&maps.size()<=1){
                continue;
            }else {
                // todo
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(isLatestVersion("02.00.01", "2.0"));

    }
    private static boolean isLatestVersion(String version,String versionLatest){
        String[] versionArray = version.split("\\.");
        String[] latestArray = versionLatest.split("\\.");
        int i=0;
        while (i<versionArray.length&&i<latestArray.length){
            int versionInt = Integer.parseInt(versionArray[i]);
            int latestInt = Integer.parseInt(latestArray[i]);

            if (versionInt<latestInt){
                return false;
            }else if (versionInt>latestInt){
                return true;
            }else {
                i++;
            }
        }
        if (versionArray.length<latestArray.length){
            return false;
        }
        return true;
    }

}
