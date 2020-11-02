package page.leetcode.seven;

import java.util.*;

/**
 * @author 1226134406@qq.com
 * @className ThreeHundredAndFortyNine
 * @description
 * @time 2020/11/2 8:44
 */
public class ThreeHundredAndFortyNine {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        for (int i:nums1){
            set1.add(i);
        }
        Set<Integer> common=new HashSet<>();
        for (int i:nums2){
            if (common.contains(i)){
                continue;
            }
            if (set1.contains(i)){
                common.add(i);
            }
        }
        int []result=new int[common.size()];
        Iterator<Integer> iterator = common.iterator();
        int i=0;
        while (iterator.hasNext()){
            result[i]=iterator.next();
            i++;
        }
        return result;
    }
}
