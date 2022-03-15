package page.leetcode.five;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * <p>
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 * <p>
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 */
public class TwoHundredAndThirtyNine {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int startIndex = 0;
        int endIndex = k - 1;
        int max = Integer.MIN_VALUE;
        int maxCount = 0;
        for (int i = startIndex; i <= endIndex && i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxCount = 1;
            } else if (nums[i] == max){
                maxCount ++;
            }
        }
        result[0] = max;
        return result;
    }

}
