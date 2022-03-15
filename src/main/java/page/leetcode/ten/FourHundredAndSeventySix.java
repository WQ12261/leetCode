package page.leetcode.ten;

import java.util.*;
import java.util.stream.Collectors;

public class FourHundredAndSeventySix {
    public static int findComplement(int num) {
        int i = ~num;
        String a = Integer.toBinaryString(num);
        String b = Integer.toBinaryString(i);
        String resultString = b.substring(b.length()-a.length(), b.length());

        return Integer.parseInt(resultString, 2);
    }

}
