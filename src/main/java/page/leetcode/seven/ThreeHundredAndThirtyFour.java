package page.leetcode.seven;

/**
 * 334. 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * 示例 2：
 * <p>
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
 */
public class ThreeHundredAndThirtyFour {
    public static boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) {
            return false;
        }
        int[] buffer = new int[2];
        int minValueIndex = 0; //小于buffer[0]并且 下标大于buffer[0]所在下标的 值
        for (int i = 0; i < nums.length ; i++) {
            if (buffer[1] > buffer[0]) {
                if (nums[i] > buffer[1]) {
                    return true;
                } else if (nums[i] > buffer[0]) {
                    buffer[1] = nums[i];
                }else {
                    if (minValueIndex  == -1){
                        minValueIndex = i;
                    }else if (nums[minValueIndex] <nums[i]){
                        buffer[0] = nums[minValueIndex];
                        buffer[1] = nums[i];
                        minValueIndex = -1;
                    }
                }
            } else {
                if (nums[i] > nums[minValueIndex]){
                    buffer[0] = nums[minValueIndex];
                    buffer[1] = nums[i];
                    minValueIndex = -1;
                }else if (nums[i] < nums[minValueIndex]){
                    minValueIndex = i;
                }
            }
        }
        return false;
    }

    public static boolean increasingTriplet1(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] array = new int[]{12,13,5,12};
        System.out.println(increasingTriplet(array));
        System.out.println(increasingTriplet1(array));
    }
}
