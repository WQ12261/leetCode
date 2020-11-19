package page.leetcode.two;

import java.util.Arrays;

/**
 * @author 1226134406@qq.com
 * @className SeventyFive
 * @description 第75题
 * @time 2020/11/3 13:10
 */
public class SeventyFive {
    public static void sortColors(int[] nums) {
        int[] array=new int[2];
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                array[0]++;
            }
            if (nums[i]==1){
                array[1]++;
            }
        }
        int i=0;
        for (;i<array[0];i++){
           nums[i]=0;
        }
        for (;i<array[1]+array[0];i++){
            nums[i]=1;
        }
        for (;i<nums.length;i++){
            nums[i]=2;
        }
    }

    public static void main(String[] args) {
        int []nums={2,0,2,1,1,0};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
