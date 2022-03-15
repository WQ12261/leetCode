package page.leetcode.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class TwoHundredAndTwentyEight {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            list.add("[]");
            return list;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (end + 1 != nums[i]) {
                if (start == end){
                    list.add(Integer.toString(start));
                }else {
                    list.add(start + "->" + end );
                }
                start = nums[i];
            }
            end = nums[i];
        }
        if (start == end){
            list.add(Integer.toString(start));
        }else {
            list.add(start + "->" + end );
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}
