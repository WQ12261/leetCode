package page.leetcode.thirteen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SixHundredAndFortyFive {

    public static int[] findErrorNums(int[] nums) {
        int len=nums.length;
        int totalNum=len*(len+1)/2;
        Set<Integer> set=new HashSet<>();
        int[] resultArray=new int[2];
        for (int num:nums){
            if (resultArray[0]==0){
                if (set.contains(num)){
                    resultArray[0]=num;
                }else {
                    set.add(num);
                    totalNum-=num;
                }
            }else {
                totalNum-=num;
            }
        }
        resultArray[1]=totalNum;
        return resultArray;
    }

    public static void main(String[] args) {
        int[] nums={1,1};
        int[] errorNums = findErrorNums(nums);
        System.out.println(Arrays.toString(errorNums));
    }
}
