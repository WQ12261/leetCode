package array.util;

public class ShellSort {

    public static void shellSort(int[] nums){
        firstSort(nums);
        insertSort(2, nums);
        insertSort(1, nums);
    }
    public static void firstSort(int[] nums){
        int middleIndex=nums.length/2;
        int len= nums.length%2==0? middleIndex:middleIndex+1;
        for (int i=0;i<middleIndex;i++){
            if (nums[i]>nums[i+middleIndex]){
                swap(i, i+len, nums);
            }
        }
    }

    public static void swap(int a,int b,int[] nums){
        int c=nums[a];
        nums[a]=nums[b];
        nums[b]=c;
    }
    public static void insertSort(int a,int[] nums){
        for (int i=a;i<nums.length;i++){
            int num=nums[i];
            int j=i-a;
            while (j>=0&&num<nums[j]){
                nums[j+a]=nums[j];
                j-=a;
            }
            nums[j+a]=num;
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtil.generatorOneDimension(10, 10, true);
        ArrayUtil.showOnwDimension(nums);
        shellSort(nums);
        ArrayUtil.showOnwDimension(nums);
    }
}
