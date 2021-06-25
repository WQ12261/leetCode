package page.leetcode.two;

import java.util.ArrayList;
import java.util.List;

/**
 *90题 子集
 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class Ninety {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        result.add(list);
        if (nums!=null&&nums.length>0){
            boolean[] flag=new boolean[nums.length];

        }
        return result;
    }

}
