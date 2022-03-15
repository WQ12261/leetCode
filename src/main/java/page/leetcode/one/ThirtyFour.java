package page.leetcode.one;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author 1226134406@qq.com
 * @className ThirtyFour
 * @description 34. 在排序数组中查找元素的第一个和最后一个位置
 * @time 2020/12/1 18:22
 */
public class ThirtyFour {
    /**
     * @description: searchRange方法是
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 进阶：
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param: [nums, target]
     * @retrun: int[]
     * @auther: 1226134406@qq.com
     * @date: 2020/12/1 18:25
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] array = {-1, -1};
        if (nums == null || nums.length == 0) {
            return array;
        }

        int left = 0;
        int right = nums.length - 1;

        int index = -1;
        while (left <=right && left < nums.length && right >= 0) {
            int center = (left + right) / 2;
            if (nums[center] > target) {
                right = center - 1;
            } else if (nums[center] < target) {
                left = center + 1;
            } else {
                index = center;
                break;
            }
        }
        if (index == -1) {
            return array;
        } else {
            int j = index - 1;
            while (j >= 0 && nums[j] == target) {
                j--;
            }
            int i = index + 1;
            while (i < nums.length && nums[i] == target) {
                i++;
            }
            array[0] = j+1;
            array[1] = i-1;
        }

        return array;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{1,1,2}, 1);
        System.out.println(Arrays.toString(ints));
    }

}
