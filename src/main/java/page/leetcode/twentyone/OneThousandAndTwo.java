package page.leetcode.twentyone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1005. K 次取反后最大化的数组和
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 * <p>
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 */
public class OneThousandAndTwo {
    public static   int largestSumAfterKNegations(int[] nums, int k) {
        int absMin = Integer.MAX_VALUE;
        int startIndex = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
                absMin = Math.min(absMin, nums[i]);
            } else {
                nums[startIndex] = nums[i];
                startIndex++;
            }
        }
        Arrays.sort(nums, 0, startIndex);
        int i = 0;
        for (; i < startIndex && i < k; i++) {
            sum += -nums[i];
        }
        if (i < startIndex) {
            for (; i < startIndex; i++) {
                sum += nums[i];
            }
        } else if (i < k ){
            k = k - startIndex;
            if ( k % 2 != 0){
                if (startIndex > 0){
                    int fAbs = nums[startIndex -1];
                    if (absMin > -fAbs){
                        absMin = fAbs;
                    }
                }
                if (absMin < 0) {
                    sum += absMin << 1;
                } else {
                    sum -= absMin << 1;
                }
            }
        }
        return sum;
    }




    public static void main(String[] args) {
        int [] array = new int[] {1,2,3};
        System.out.println(largestSumAfterKNegations(array, 3));
    }
}
