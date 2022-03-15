package array.util;

public class InsertSort {
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int num = nums[i];
            while (j>=0&&num < nums[j]) {
                nums[j+1]=nums[j];
                j--;
            }
            j++;
            nums[j] = num;
        }
    }



    public static void main(String[] args) {
        int[] nums = ArrayUtil.generatorOneDimension(10, 10, true);
        ArrayUtil.showOnwDimension(nums);
        insertSort(nums);

        ArrayUtil.showOnwDimension(nums);
        System.out.println(System.currentTimeMillis());
    }
}
