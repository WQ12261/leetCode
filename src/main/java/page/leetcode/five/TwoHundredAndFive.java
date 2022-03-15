package page.leetcode.five;

import array.util.ArrayUtil;
import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s = "paper", t = "title"
 * 输出：true
 */
public class TwoHundredAndFive {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c1 = t.charAt(i);

        }
        return false;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        fullPermutation(list, nums, 0, nums.length-1);
        return list;
    }
    public static void fullPermutation(List<List<Integer>> list,int []arr,int i,int j) {
        if (i>=j) {
            List<Integer> li=new ArrayList<Integer>();
            for (int k = 0; k < arr.length; k++) {
                li.add(arr[k]);
            }
            list.add(li);
        }else {
            for (int k = i; k<=j; k++) {
                swap(arr, i, k);
                fullPermutation(list, arr, i+1, j);
                swap(arr, i, k);
            }
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int n=arr[i];
        arr[i]=arr[j];
        arr[j]=n;
    }



    public static void main(String[] args) {

        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        List<List<Integer>> permute = permute(ints);
        for (List<Integer> list:permute){
            System.out.println(list);
        }
        //System.out.println(permute);
    }

}
