package page.leetcode.eleven;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 520. 检测大写字母
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "USA"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：word = "FlaG"
 * 输出：false
 */
public class FiveHundredAndTwenty {
    public static boolean detectCapitalUse(String word) {
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i-1)>'Z'&&word.charAt(i)<'a'||i>1&&word.charAt(i-1)<'a'&&word.charAt(i)>'Z'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int i = 564645;
        System.out.println(oneCountByOperator(i));
        System.out.println(oneCountByString(i));
    }
    public static int oneCountByString(int a){
        String string = Integer.toBinaryString(a);
        System.out.println(string);
        int count = 0;
        for (int i = 0; i< string.length(); i ++ ){
            if (string.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
    public static int oneCountByOperator(int a){
        int count = 0;
        while (a != 0){
            a&=a-1;
            count++;
        }
        return count;

    }
}
