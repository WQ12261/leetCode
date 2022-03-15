package array.util;

/**
 * 冒泡排序
 */
public class PopSort {
    public static void popSort(int[] nums){
        for (int i=0;i<nums.length-1;i++){
            for (int j=1;j<nums.length-i;j++){
                if (nums[j]<nums[j-1]){
                    swap(j, j-1, nums);
                }
            }
        }
    }
    public static void swap(int a,int b,int[] nums){
        int c=nums[a];
        nums[a]=nums[b];
        nums[b]=c;
    }

    public static void main(String[] args) {

        int[] nums = ArrayUtil.generatorOneDimension(2, 10, true);
        ArrayUtil.showOnwDimension(nums);
        popSort(nums);
        ArrayUtil.showOnwDimension(nums);

    }
}
