package page.leetcode.three;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndTwentyFive {
    public boolean isPalindrome(String s) {
        if (s==null||"".equals(s)){
            return false;
        }
        char[] chars = s.toCharArray();
        int left=0;
        int right=chars.length-1;
        while (left<right){
            while (!Character.isLetterOrDigit(chars[left])&&left<right){
                left++;
            }
            while (!Character.isLetterOrDigit(chars[right])&&left<right){
                right--;
            }
            if (Character.toLowerCase(chars[left])!=Character.toLowerCase(chars[right])){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        /*OneHundredAndTwentyFive oneHundredAndTwentyFive=new OneHundredAndTwentyFive();
        boolean palindrome = oneHundredAndTwentyFive.isPalindrome("0P");
        System.out.println(Character.toLowerCase(0));
        System.out.println(palindrome);*/
        System.out.println(Character.isLetter(';'));

    }
}
