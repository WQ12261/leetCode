package page.leetcode.eleven;

import java.util.HashMap;
import java.util.Map;

/**
 * 507. 完美数
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * <p>
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 * 示例 1：
 * <p>
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * 示例 2：
 * <p>
 * 输入：num = 6
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：num = 496
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：num = 8128
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FiveHundredAndSeven {
    public static boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        int i = 2;
        int j = num;
        while (i < j) {
            if (num % i == 0) {
                sum += i;
                j = num / i;
                sum += j;
            }
            i++;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(8125));
        Map<String,String> map = new HashMap<>();
        String put = map.put("a", "b");
        String put1 = map.put("a", "c");
        System.out.println(put);
        System.out.println(put1);
    }
}
