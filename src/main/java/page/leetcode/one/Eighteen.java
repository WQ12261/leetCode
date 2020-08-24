package page.leetcode.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@ClassName Eighteen
 *@description 第18题 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存
 * 在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。
 *@author  1226134406@qq.com
 *@time 2020/8/13 21:26
 */
public class Eighteen {
    public List<List<Integer>> fourSum(int[] nums,int target){
        Arrays.sort(nums);
        List<List<Integer>> resultList=new ArrayList<>();
        for (int r=0;r<nums.length-3;r++){
            while (r!=0&&nums[r]==nums[r-1]&&r<nums.length-3){
                r++;
            }
            if (r>=nums.length-3){
                break;
            }
            for (int l=nums.length-1;l>r+2;l--){
                while (l!=nums.length-1&&nums[l]==nums[l+1]&&l>r+2){
                    l--;
                }
                if (l<=r+2){
                    break;
                }
                for (int r1=r+1,l1=l-1;l1>r1;){
                    while (r1!=r+1&&nums[r1]==nums[r1-1]&&r1<l1){
                        r1++;
                    }
                    while (l1!=l-1&&nums[l1]==nums[l1+1]&&l1>r1){
                        l1--;
                    }
                    if (l1<=r1){
                        break;
                    }
                    int n = nums[l] + nums[r]+nums[l1]+nums[r1];
                    if (n==target) {
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[r]);
                        list.add(nums[r1]);
                        list.add(nums[l1]);
                        list.add(nums[l]);
                        resultList.add(list);
                        r1++;
                        l1--;
                    }else if (n>target){
                        l1--;
                    }else {
                        r1++;
                    }

                }
            }
        }
        return resultList;
    }
}
