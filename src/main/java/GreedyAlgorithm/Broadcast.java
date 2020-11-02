package GreedyAlgorithm;

import java.util.*;

/**
 * @author 1226134406@qq.com
 * @className Broadcast
 * @description 假设存在下面需要付费的广播台，以及广播台信号可以覆盖的地区。
 * 如何选择最少的广播台，让所有的地区都可以接收到信号
 *广播台                                   覆盖地区
 *  K1                                    "北京", "上海", "天津"
 *  K2                                    "广州", "北京", "深圳"
 *  K3                                    "成都", "上海", "杭州"
 *  K4                                    "上海", "天津"
 *  K5                                    "杭州", "大连"
 * @time 2020/10/31 19:59
 */
public class Broadcast {
    public static List<String> getMinBroadCast(Map<String,List<String>> map){
        List<String> list=new ArrayList<>();
        Set<String> areaSet=new HashSet<>();
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        Map<String,Integer> map1=new HashMap<>();
        //获取所有地区的Set集合
        while (iterator.hasNext()){
            Map.Entry<String, List<String>> next = iterator.next();
            String key = next.getKey();
            List<String> value = next.getValue();
            for (String string:value){
                areaSet.add(string);
            }
        }
        //只要所有地区的Set集合不为空
        while (areaSet.size()>0){
            Iterator<Map.Entry<String, List<String>>> iterators = map.entrySet().iterator();
            String key="";
            int maxVal=0;
            while (iterators.hasNext()){
                //遍历映射，得到能广播最大地区的电台
                Map.Entry<String, List<String>> next = iterators.next();
                List<String> value = next.getValue();
                int count=0;
                for (String v:value){
                    if (areaSet.contains(v)){
                        count++;
                    }
                }
                if (maxVal<count){
                    maxVal=count;
                    key=next.getKey();
                }
            }
            //将能广播最多地区的电台将结果集合中
            list.add(key);

            List<String> list1 = map.get(key);
            map.remove(key);
            for (String string:list1){
                areaSet.remove(string);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> k1=new ArrayList<>();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");
        List<String> k2=new ArrayList<>();
        k2.add("广州");
        k2.add("北京");
        k2.add("深圳");
        List<String> k3=new ArrayList<>();
        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");
        List<String> k4=new ArrayList<>();
        k4.add("上海");
        k4.add("天津");
        List<String> k5=new ArrayList<>();
        k5.add("杭州");
        k5.add("大连");
        Map<String,List<String>> map=new HashMap<>();
        map.put("k1",k1);
        map.put("k2",k2);
        map.put("k3",k3);
        map.put("k4",k4);
        map.put("k5",k5);
        List<String> minBroadCast = getMinBroadCast(map);
        System.out.println(minBroadCast);

    }

}
