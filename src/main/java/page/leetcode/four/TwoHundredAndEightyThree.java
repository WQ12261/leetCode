package page.leetcode.four;

import array.util.ArrayUtil;

/**
 * @author 1226134406@qq.com
 * @className TwoHundredAndEightyThree
 * @description 283题
 * @time 2020/11/19 21:15
 */
public class TwoHundredAndEightyThree {
    /**
     * @description: moveZeroes方法是 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 思路：标记0的起始位置叫zeroStart，没扫描到一个非零数就和交换zeroStart进行交换
     * @param: [nums]
     * @retrun: void
     * @auther: 1226134406@qq.com
     * @date: 2020/11/19 21:20
     */
    public void moveZeroes(int[] nums) {
        //连续的0的起始索引
        int zeroStart = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0) {
                if (zeroStart==-1){
                    zeroStart=i;
                }
            }else {
                if (zeroStart!=-1){
                    swap(nums,zeroStart,i);
                    ++zeroStart;
                }
            }
        }
    }

    private  void swap(int[] nums, int left, int right) {
        int number = nums[left];
        nums[left] = nums[right];
        nums[right] = number;
    }

    public static void main(String[] args) {
        TwoHundredAndEightyThree twoHundredAndEightyThree=new TwoHundredAndEightyThree();
        int[] numbers = ArrayUtil.generatorOneDimension(10, 5, false);
        ArrayUtil.showOnwDimension(numbers);
        twoHundredAndEightyThree.moveZeroes(numbers);
        ArrayUtil.showOnwDimension(numbers);

    }
}
