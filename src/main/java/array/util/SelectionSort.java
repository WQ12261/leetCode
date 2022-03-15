package array.util;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void selectSort(int [] nums){
        int max;
        int index;
        for (int i=0;i<nums.length;i++){
            max=nums[0];
            index=0;
            for (int j=0;j<nums.length-i;j++){
                if (max<nums[j]){
                    index=j;
                    max=nums[j];
                }
            }
            swap(index, nums.length-i-1, nums);
        }

    }
    public static void swap(int a,int b,int[] nums){
        int c=nums[a];
        nums[a]=nums[b];
        nums[b]=c;
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.generatorOneDimension(10, 10, true);
        ArrayUtil.showOnwDimension(nums);
        selectSort(nums);
        ArrayUtil.showOnwDimension(nums);
    }

}
