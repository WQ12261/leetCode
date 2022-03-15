package page.leetcode.five;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class TwoHundredAndNinety {
    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        Map<String,Character> map = new HashMap<>();
        Map<Character,String> cStringMap = new HashMap<>();
        for (int i = 0;i<pattern.length();i++){

        }
        return false;
    }

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("start", 100);
        map.put("end", 100);
        map.put("len", 1);
    }
}
