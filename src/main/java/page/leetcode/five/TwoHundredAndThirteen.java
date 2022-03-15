package page.leetcode.five;

import tree.array.Array;

import java.util.Arrays;
import java.util.Map;

public class TwoHundredAndThirteen {
    public  int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //偷第一家
        int robFirst = nums[0] + rob(nums, 2, nums.length - 1);
        //不偷第一家
        int notRobFirst = rob(nums, 1, nums.length);
        return Math.max(robFirst, notRobFirst);
    }

    private  int rob(int[] nums, int start, int end) {
        int sum = nums[start], forSwap, pre = 0;
        if (start == end){
            return 0;
        }
        for (int i = start + 1; i < end; i++) {
            pre += nums[i];
            forSwap = sum;
            sum = Math.max(pre, sum);
            pre = forSwap;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println( 1 ^ 2);
    }
}
