package page.leetcode.five;

/**
 * 201. 数字范围按位与
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：left = 5, right = 7
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：left = 0, right = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：left = 1, right = 2147483647
 * 输出：0
 */
public class TwoHundredAndOne {
    public static int rangeBitwiseAnd(int left, int right) {
        if (left == right){
            return left;
        }
        String leftBinaryString = Integer.toBinaryString(left);
        String rightBinaryString = Integer.toBinaryString(right);
        if (leftBinaryString.length()!= rightBinaryString.length()){
            return 0;
        }
        int i = 1;
        for (;i<leftBinaryString.length();i++){
            if (leftBinaryString.charAt(i)!= rightBinaryString.charAt(i)){
                break;
            }
        }
        int i1 = Integer.parseInt(leftBinaryString.substring(0, i), 2);
        return i1<<leftBinaryString.length()-i;

    }
    public int rangeBitwiseAndTwo(int left ,int right){
        int count = 0;
        while (left<right){
            left>>=1;
            if (left == 0){
                return 0;
            }
            right>>=1;
            ++count;
        }
        return left<<count;
    }

    public static int rangeBitwiseAnd1(int left, int right) {
        int i = -1;
        for (int i1 = left; i1 <= right; i1++) {
            i &= i1;
        }
        return i;
    }

    public static void main(String[] args) {
        for (int i = 0;i<=13;i++){
            System.out.println(Integer.toBinaryString(i));
        }
        //System.out.println(Integer.toBinaryString(13));

    }
}
