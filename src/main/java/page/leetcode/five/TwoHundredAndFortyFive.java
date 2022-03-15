package page.leetcode.five;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class TwoHundredAndFortyFive {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cArray[s.charAt(i) - 'a']++;
            cArray[t.charAt(i) - 'a']--;
        }
        for (int i : cArray) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
