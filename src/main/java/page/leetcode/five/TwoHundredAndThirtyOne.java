package page.leetcode.five;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * 示例 2：
 *
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * 示例 3：
 *
 * 输入：n = 3
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoHundredAndThirtyOne {
    public static boolean isPowerOfTwo(int n) {
        if (n<0){
            return false;
        }else if (n<3){
            return true;
        }else {
            int i=2;
            int count =1;
            while (i<n){
                count ++;
                if (count==31){
                    return false;
                }
                i=i<<1;
                if (i==n){
                    System.out.println(count);
                    return true;
                }
            }
            System.out.println(count);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(1024<<1);
        System.out.println(isPowerOfTwo(1073741825));
    }
}
