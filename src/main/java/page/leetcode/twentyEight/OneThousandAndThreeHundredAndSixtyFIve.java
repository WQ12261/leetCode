package page.leetcode.twentyEight;

import java.util.Arrays;

/**
 *@className OneThousandAndThreeHundredAndSixtyFIve
 *@description 第1365题
 *@author 1226134406@qq.com
 *@time 2020/10/26 12:50
 *@version
 */
public class OneThousandAndThreeHundredAndSixtyFIve {
    /**
     *@description: smallerNumbersThanCurrent方法是 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
     * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
     * 以数组形式返回答案。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *@param: [nums]
     *@retrun: int[]
     *@auther: 1226134406@qq.com
     *@date: 2020/10/26 12:51
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums==null){
            return null;
        }
        int[] result=new int[nums.length];
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[j]>nums[i]){
                    result[j]++;
                }else if (nums[i]>nums[j]){
                    result[i]++;
                }
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        int[]nums={6,5,4,8};
        int[] ints = smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(ints));
    }
}
