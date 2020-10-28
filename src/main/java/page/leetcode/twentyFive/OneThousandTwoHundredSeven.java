package page.leetcode.twentyFive;

import java.util.*;

/**
 * @author 1226134406@qq.com
 * @className OneThousandTwoHundredSeven
 * @description 1207题
 * @time 2020/10/28 13:07
 */
public class OneThousandTwoHundredSeven {
    /**
     *@description: uniqueOccurrences方法是
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     *
     *如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     *@param: [arr]
     *@retrun: boolean
     *@auther: 1226134406@qq.com
     *@date: 2020/10/28 13:08
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:arr){
            Integer integer = map.get(i);
            if (integer==null){
                integer=1;
            }else {
                integer+=1;
            }
            map.put(i,integer);
        }
        Set<Integer> set = new HashSet<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer value = next.getValue();
            if (set.contains(value)){
                return false;
            }else {
                set.add(value);
            }
        }
        return true;
    }
}
