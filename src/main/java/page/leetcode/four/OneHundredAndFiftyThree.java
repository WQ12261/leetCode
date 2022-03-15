package page.leetcode.four;

public class OneHundredAndFiftyThree {
    public static int findMin(int[] nums) {
        int len = nums.length;
        if (nums[0] <= nums[len - 1]) {
            return nums[0];
        }
        int right = len - 1;
        int left = 0;
        int center = (right + left) / 2;
        while (center > left && center < right) {
            if (nums[center] > nums[left]) {
                left = center;
                center = (right + left) / 2;
                continue;
            }
            if (nums[center] < nums[right]) {
                right = center;
                center = (right + left) / 2;
            }

        }
        return Math.min(nums[center],nums[right] );
    }

    public static void main(String[] args) {
        int [] array = {6,7,0,1,2};
        System.out.println(findMin(array));
    }
}
