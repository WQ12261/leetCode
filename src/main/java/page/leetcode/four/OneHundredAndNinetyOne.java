package page.leetcode.four;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndNinetyOne {
    public static int hammingWeight(int n) {
        int count = 0;
        int k = n;
        if (n<0){
            k = n^-1;
        }
        while (k != 0) {
            if ((k & 1) == 1) {
                count++;
            }
            k >>= 1;
        }
        return n<0? 32-count:count;
    }

    public static void main(String[] args) {
        int i = 5;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(hammingWeight(i));

    }
}
