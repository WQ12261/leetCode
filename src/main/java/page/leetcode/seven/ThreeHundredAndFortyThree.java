package page.leetcode.seven;

import java.util.*;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeHundredAndFortyThree {
    public static int integerBreak(int n) {
        int i = 2;
        int avg;
        while(true){
            avg = n /i;
            if(avg <= i){
                break;
            }
            i ++;
        }
        return calculate(avg,i,n%i);
    }
    private static int calculate(int avg,int count,int mod){
        int a = 1;
        for(int i = 1;i<count;i ++){
            a *= avg;
        }
        a *=(avg + mod);
        return a;
    }

    private static void test(int n){
        int i = 1;
        int maxValue = 0;
        while (i <= n ){
            int calculate = calculate(n / i, i, n % i);
            System.out.println("I = " + i + ",计算值：" + calculate);
            maxValue = Math.max(calculate, maxValue);
            System.out.println();
            i++;
        }
        System.out.println("最大值：" + maxValue);
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 100;
        while ( n != 0){
            stringBuilder.append(n%7);
            n = n/7;
        }


    }

}
