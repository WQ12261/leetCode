package page.leetcode.two;

/**
 *@className FiftyThree
 *@description 53题
 *@author 1226134406@qq.com
 *@time 2020/10/27 10:21
 *@version
 */
public class FiftyThree {
    /**
     *@description: maxSubArray方法是
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *@param: [nums]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/27 10:22
     */
    public static int maxSubArray(int[] nums) {
        int max=nums[0];
        int pre=nums[0];
        for (int i=0;i<nums.length;i++){

                if (pre<0){
                    pre=nums[i];
                }else {
                    pre=pre+nums[i];
                    max=max>pre? max:pre;
                }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
