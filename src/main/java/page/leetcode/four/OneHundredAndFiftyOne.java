package page.leetcode.four;

/**
 * 151. 翻转字符串里的单词
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 * 说明：
 *
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndFiftyOne {
    public static String reverseWords(String s) {
        if (s==null||s.length()==0){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        boolean flag=false;
        for (int i=chars.length-1;i>=0;i--){
            if (chars[i]==' '){
                if (flag){
                    continue;
                }else {
                    flag=true;
                }
            }else {
                if (flag=true&&stringBuilder.length()>0){
                    stringBuilder.append(' ');
                    flag=false;
                }
                int j=i;
                while (j>=0&&chars[j]!=' '){
                    j--;
                }
                int k=j+1;
                while (k<=i){
                    stringBuilder.append(chars[k]);
                    k++;
                }
                i=j;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String string = reverseWords("a good   example");
        System.out.println(string);
    }
}
