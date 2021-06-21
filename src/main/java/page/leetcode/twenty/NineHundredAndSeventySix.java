package page.leetcode.twenty;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author 1226134406@qq.com
 * @className NineHundredAndSeventySix
 * @description 976 三角形的最大周长
 * @time 2020/11/29 23:38
 */
public class NineHundredAndSeventySix {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        return 0;
    }

    public static void main(String[] args) {
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> map1=new HashMap<>();
        map1.put("v1", 1);
        map1.put("maxWeight",new BigDecimal("1"));
        Map<String,Object> map2=new HashMap<>();
        map2.put("v2", 2);
        map2.put("maxWeight",new BigDecimal("2"));
        Map<String,Object> map3=new HashMap<>();
        map3.put("v3", 3);
        map3.put("maxWeight",new BigDecimal("3"));
        list.add(map1);
        list.add(map2);
        list.add(map3);
        Collections.sort(list, (v1,v2)->{
            BigDecimal weight1 = (BigDecimal) v1.get("maxWeight");
            BigDecimal weight2 = (BigDecimal) v2.get("maxWeight");
            return -weight1.compareTo(weight2);});
        System.out.println(list);
    }
}
