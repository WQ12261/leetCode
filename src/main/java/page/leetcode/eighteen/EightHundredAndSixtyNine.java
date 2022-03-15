package page.leetcode.eighteen;

public class EightHundredAndSixtyNine {
    /**
     * 869. 重新排序得到 2 的幂
     * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
     * <p>
     * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：1
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：10
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：16
     * 输出：true
     * 示例 4：
     * <p>
     * 输入：24
     * 输出：false
     * 示例 5：
     * <p>
     * 输入：46
     * 输出：true
     */
    public static boolean reorderedPowerOf2(int n) {
        if (n == 0 || n == 1 || n == 2 || n == 4 || n == 8) {
            return true;
        }
        int[] numberCount = new int[10];
        int length = 0;
        int k = n;
        int i = 0;
        while (k != 0) {
            i = k % 10;
            numberCount[i]++;
            k /= 10;
            length++;
        }
        int value = 8;
        while (value > 0) {
            value <<= 1;
            if (value == n){
                return true;
            }
            String string = Integer.toString(value);
            int strLength = string.length();
            if (strLength == length) {
                int[] count = new int[10];
                for (int i1 = 0; i1 <length; i1++) {
                    count[string.charAt(i1) - '0']++;
                }
                boolean flag = true;
                for (int j = 0; j < 10; j++) {
                    if (count[j]!=numberCount[j]){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    return true;
                }
            } else if (strLength > length) {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = reorderedPowerOf2(456);
        System.out.println(b);
    }
}
