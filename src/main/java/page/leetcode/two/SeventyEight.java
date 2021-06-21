package page.leetcode.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class SeventyEight {
    public List<List<Integer>> subsets(Integer[] nums) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        result.add(list);
        if (nums!=null&&nums.length!=0){
            fullPermutation(nums, 0, nums.length-1, result, list);
        }
        return result;
    }

    /**
     * 全排列
     */
    public void fullPermutation(Integer [] nums,int startIndex,int endIndex,List<List<Integer>> result,List<Integer> list){
        for (int i=startIndex;i<=endIndex;i++){
            List<Integer> list1=new ArrayList<>(list);
            list1.add(nums[i]);
            result.add(list1);
            if (startIndex!=endIndex){
                fullPermutation(nums, i+1, endIndex, result, list1);
            }
        }
    }

    public static void main(String[] args) {
        SeventyEight seventyEight=new SeventyEight();
        List<List<Integer>> subsets = seventyEight.subsets(new Integer[]{1, 2, 3});
        System.out.println(subsets);
    }
}
