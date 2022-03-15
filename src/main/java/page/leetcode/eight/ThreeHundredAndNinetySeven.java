package page.leetcode.eight;

import java.util.HashSet;
import java.util.Set;

/**
 * 397. 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 * <p>
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：2
 */
public class ThreeHundredAndNinetySeven {
    /**
     * 给定一个正整数 n ，你可以做如下操作：
     *
     * 如果 n 是偶数，则用 n / 2替换 n 。
     * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
     * n 变为 1 所需的最小替换次数是多少？
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 8
     * 输出：3
     * 解释：8 -> 4 -> 2 -> 1
     * 示例 2：
     *
     * 输入：n = 7
     * 输出：4
     * 解释：7 -> 8 -> 4 -> 2 -> 1
     * 或 7 -> 6 -> 3 -> 2 -> 1
     * 示例 3：
     *
     * 输入：n = 4
     * 输出：2
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-replacement
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int integerReplacement(int n) {
        //整数n转换成二进制字符串后，字符串中‘1’的个数
        int oneCount = getOneCountInBinary(n);
        //整数n转换成二进制字符串后的长度，等价于：int binaryLen = Integer.toBinaryString(n).length();
        int binaryLen = 32 - Integer.numberOfLeadingZeros(n);
        // binaryLen -1 就是  [用 n / 2替换 n ]的次数
        // oneCount -1  就是  [用 n + 1或n - 1替换 n]的次数
        return binaryLen -1 + oneCount -1;
    }

    /**
     * 获取一个整数转换成二进制后数字1的数量
     */
    public static int getOneCountInBinary(int n) {
        int oneCount = 0;
        while (n != 0) {
            n &= n - 1;
            oneCount++;
        }
        return oneCount;
    }
    public static void count(int i){
        String string = Integer.toBinaryString(i);
        System.out.println(string.length());
        System.out.println(32 - Integer.numberOfLeadingZeros(i));
    }

    public static void main(String[] args) {
        int i = 4;
        //count(i);
        System.out.println(integerReplacement(i));
        Set<String> set = new HashSet<>();
        boolean add = set.add("1");
        boolean add1 = set.add("1");
        System.out.println(add);
        System.out.println(add1);
    }
}
