package page.leetcode.ThirtyOne;

import tree.array.Array;

import java.util.Arrays;

/**
 * 1539. 第 k 个缺失的正整数
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 */
public class oneThousandFiveHundredAndThirtyNine {
    public static int findKthPositive(int[] arr, int k) {
        for (int value : arr) {
            if (k < value) {
                break;
            } else {
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString("♠".getBytes()));
        System.out.println(Arrays.toString("♥".getBytes()));
    }
}
