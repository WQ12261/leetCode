package page.leetcode.one;

import java.util.Arrays;

/**
 * 41 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class fortyOne {
    public static int firstMissingPositive(int[] nums){
        if (nums==null||nums.length==0){
            return 1;
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i]<=0){
                nums[i]=nums.length+1;
            }
        }
        for (int i=0;i<nums.length;i++){
            int value=Math.abs(nums[i]);
            if (value<=nums.length){
                value--;
                nums[value]=-Math.abs(nums[value]);
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i=0;i<nums.length;i++){
            if (nums[i]>0){
                return i+1;
            }
        }
        return nums.length+1;

    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6};
        int i = firstMissingPositive(nums);
        System.out.println(i);
    }
}
