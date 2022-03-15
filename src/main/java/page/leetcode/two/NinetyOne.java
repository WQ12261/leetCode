package page.leetcode.two;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NinetyOne {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();

        return decodeCount(chars, 0, 0);
    }

    private int decodeCount(char[] chars, int start, int count) {
        if (start == chars.length) {
            return ++count;
        }
        if (!firstIsQualified(chars[start])) {
            return count;
        }
        count = decodeCount(chars, start + 1, count);
        if (start < chars.length - 1 && secondIsQualified(chars[start], chars[start + 1])) {
            count = decodeCount(chars, start + 2, count);
        }
        return count;
    }

    private boolean firstIsQualified(char c) {
        return c >= '1' && c <= '9';
    }

    private boolean secondIsQualified(char a, char b) {
        if (a == '1') {
            return b >= '0' && b <= '9';
        } else if (a == '2') {
            return b >= '0' && b <= '6';
        } else {
            return false;
        }

    }

    public int methodTwo(String s) {
        char[] chars = s.toCharArray();
        if (chars[0]<'1'||chars[0]>'9') {
            return 0;
        }
        int current = 1;
        int pre;
        int swap;
        if (chars.length > 1) {
            pre = current;
            if (chars[1] == '0') {
                if (chars[0]!='1'&&chars[0]!='2' ){
                    return 0;
                }
            }else {
                if (secondIsQualified(chars[0],chars[1])){
                    current=2;
                }
            }
            for (int i = 2; i < chars.length; i++) {
                if (chars[i]=='0'){
                    if (!secondIsQualified(chars[i-1],chars[i])){
                        return 0;
                    }else {
                        swap=pre;
                        pre=current;
                        current=swap;
                    }
                }else {
                    if (secondIsQualified(chars[i-1],chars[i])){
                        swap=current;
                        current+=pre;
                        pre=swap;
                    }else {
                        pre=current;
                    }
                }
            }
        }


        return current;
    }

    public static void main(String[] args) {
        NinetyOne ninetyOne = new NinetyOne();
        String string = "21032106546164";
        int i = ninetyOne.numDecodings(string);
        System.out.println(ninetyOne.methodTwo(string));
        System.out.println(i);
    }
}
