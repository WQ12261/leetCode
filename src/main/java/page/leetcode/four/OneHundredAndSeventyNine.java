package page.leetcode.four;

import array.util.ArrayUtil;
import org.junit.Test;

import java.util.*;

public class OneHundredAndSeventyNine {
    public static String largestNumber(int[] nums) {

        List<String> list = new ArrayList<>();
        for (int i : nums) {
            list.add(Integer.toString(i));
        }
        Collections.sort(list, (str1, str2) -> {
            while (str1.startsWith(str2) || str2.startsWith(str1)) {
                int len1 = str1.length();
                int len2 = str2.length();
                if (len1 > len2) {
                    while (str1.startsWith(str2)) {
                        str1 = str1.substring(len2);
                    }
                } else {
                    while (str2.startsWith(str1)) {
                        str2 = str2.substring(len1);
                    }
                }
                if (str1.length() == 0 || str2.length() == 0) {
                    return 0;
                }

            }
            int minLen = Math.min(str1.length(), str2.length());
            for (int i = 0; i < minLen; i++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(i);
                if (c1 > c2) {
                    return -1;
                } else if (c1 < c2) {
                    return 1;
                }
            }
            return 0;
        });
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(list);
        for (String s : list) {
            stringBuilder.append(s);
        }
        String string = stringBuilder.toString();
        if (string.startsWith("0")){
            return "0";
        }
        return string;
    }

    public static String largestNumber2(int[] nums) {

        List<String> list = new ArrayList<>();
        for (int i : nums) {
            list.add(Integer.toString(i));
        }
        Collections.sort(list, (str1, str2) -> {
            String s1 = str1+str2;
            String s2 = str2+str1;
            return -s1.compareTo(s2);
        });
        System.out.println(list);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
        }
        String string = stringBuilder.toString();
        if (string.startsWith("0")){
            return "0";
        }

        return string;
    }
    public static void main(String[] args) {
        int[] array = ArrayUtil.generatorOneDimension(10, 10000, false);

        largestNumber(array);
        largestNumber2(array);
    }

    @Test
    public void testa() {
        System.out.println("a".startsWith(""));
    }
}
