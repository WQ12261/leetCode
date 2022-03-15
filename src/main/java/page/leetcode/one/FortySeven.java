package page.leetcode.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class FortySeven {
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> lists=new ArrayList<>();
        Arrays.sort(nums);
        boolean[] flags=new boolean[nums.length];
        permute(nums, 0, new ArrayList<>(), lists,flags);
        return lists;
    }
    public void permute(int[] nums,int start,List<Integer> list,List<List<Integer>> lists,boolean[] flags){
        if (start==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (flags[i]||i>0&&nums[i]==nums[i-1]&&flags[i-1]){
                continue;
            }
            list.add(nums[i]);
            flags[i]=true;
            permute(nums,start+1,list,lists,flags);
            flags[i]=false;
            list.remove(start);
        }
    }


    public static void main(String[] args) {
        FortySeven fortySeven=new FortySeven();
        List<List<Integer>> lists = fortySeven.permuteUnique(new int[]{1, 1, 5});
        System.out.println(lists);
    }

}
