package page.leetcode.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirtyNine {
    /**
     * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
     * <p>
     * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        Arrays.sort(candidates);
        combine(candidates, sum, target, 0, lists, list);
        return lists;
    }

    private static   void combine(int[] candidates, int sum, int target, int start, List<List<Integer>> lists, List<Integer> list) {

        for (int i = start; i < candidates.length; i++) {
            int total = sum+candidates[i];
            if (total<target){
                list.add(candidates[i]);
                combine(candidates, total, target, i, lists, list);
                list.remove(list.size()-1);
            }else if (total == target){
                list.add(candidates[i]);
                List<Integer> list1 = new ArrayList<>(list);
                lists.add(list1);
                list.remove(list.size()-1);
                break;
            }else {
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {1,2};
        List<List<Integer>> lists = combinationSum(array, 2);
        System.out.println(lists);
    }
}
