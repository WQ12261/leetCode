package page.leetcode.nine;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * <p>
 * 示例：
 * <p>
 * n = 15,
 * <p>
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourHundredAndTwelve {
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        String three = "Fizz";
        String five = "Buzz";
        String fifteen = "FizzBuzz";
        int threeNum = 1;
        int fiveNum = 1;
        int fifteenNum = 1;
        int i = 1;
        while (i <= n) {


            if (fifteenNum == 15) {
                threeNum = 0;
                fiveNum = 0;
                fifteenNum = 0;
                list.add(fifteen);
            }else if (fiveNum == 5){
                fiveNum = 0;
                list.add(five);
            }else if (threeNum == 3){
                threeNum = 0;
                list.add(three);
            }else {
                list.add(String.valueOf(i));
            }
            i++;
            threeNum++;
            fiveNum++;
            fifteenNum++;
        }

        return list;
    }

    public static void main(String[] args) {
        List<String> list = fizzBuzz(15);
        System.out.println(list);
    }
}
