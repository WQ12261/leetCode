package page.leetcode.twentyFive;

import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 * <p>
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 * <p>
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 */
public class OneThousandTwoHundredAndEighteen {
    public static int longestSubsequence(int[] arr, int difference) {
        if (arr.length < 1) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0;i<arr.length;i++){
            int pre = arr[i] -difference;
            Integer preCount = map.get(pre);
            if (preCount == null){
                preCount = 1;
            }else {
                preCount++;
            }
            Integer integer = map.get(arr[i]);
            if (integer != null){
                integer = Math.max(integer, preCount);
            }else {
                integer= preCount;
            }
            max = Math.max(integer, max);
            map.put(arr[i],integer);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1,5,7,8,5,3,4,2,1};
        System.out.println(longestSubsequence(array, -2));
    }
}
