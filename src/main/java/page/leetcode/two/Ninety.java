package page.leetcode.two;

import java.util.ArrayList;
import java.util.Arrays;
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
        Arrays.sort(nums);
        result.add(list);

        subCollect(nums, new ArrayList<>(), result, 0);
        return result;
    }
    public void subCollect(int[] nums,List<Integer> list,List<List<Integer>> lists,int start){
        if (start==nums.length){
            return;
        }
        for (int i=start;i<nums.length;i++){
            if (i>0&&nums[i]==nums[i-1]&&i!=start){
                continue;
            }
            list.add(nums[i]);
            lists.add(new ArrayList<>(list));
            swap(i, start, nums);
            subCollect(nums, list, lists, i+1);
            swap(i, start, nums);
            list.remove(list.size()-1);

        }
    }
    public void swap(int a,int b,int[] nums){
        int c=nums[a];
        nums[a]=nums[b];
        nums[a]=c;
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,1,2,2};
        Ninety ninety=new Ninety();
        List<List<Integer>> lists = ninety.subsetsWithDup(array);
        System.out.println(lists);
    }

}
