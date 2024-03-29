package page.leetcode.four;

import java.util.Arrays;

/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndEightyNine {
    public static   void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        rotate(nums, k, 0);
        if (nums.length%k==0&&nums.length>2){
            rotate(nums, k, 1);
        }
    }
    private static void rotate(int[] nums, int k,int startIndex){
        int temp = nums[startIndex];
        int curr = nums[startIndex];
        int index = (k+startIndex)%nums.length;
        while (true) {
            curr = nums[index];
            nums[index] = temp;
            temp = curr;
            if (index == startIndex){
                break;
            }
            index = (k + index) % nums.length;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        rotate(array, 4);
        System.out.println(Arrays.toString(array));
    }
}
