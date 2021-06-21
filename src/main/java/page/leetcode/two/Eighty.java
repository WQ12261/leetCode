package page.leetcode.two;

import java.util.Arrays;

/**
 * 第80题
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Eighty {
    public int removeDuplicates(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int left=1;
        int repeatCount=0;
        int preValue=nums[0];
        for (int i=1;i<nums.length;i++){
            if (preValue==nums[i]){
                repeatCount+=1;
                if (repeatCount<2){
                    if (nums[i]!=nums[i-1]){
                        swap(nums,left,i);
                    }
                    left++;
                }
            }else {
                preValue=nums[i];
                repeatCount=0;

                if (left!=i){
                    swap(nums, left, i);
                }
                left++;
            }

        }
        return left;
    }

    public void swap(int []nums,int left,int right){
        int value=nums[left];
        nums[left]=nums[right];
        nums[right]=value;
    }

    public static void main(String[] args) {
        Eighty eighty=new Eighty();
        int[] array={0};
        int i = eighty.removeDuplicates(array);
        System.out.println(i);
        System.out.println(Arrays.toString(array));
    }
}
