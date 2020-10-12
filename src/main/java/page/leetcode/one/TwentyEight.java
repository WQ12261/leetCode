package page.leetcode.one;

/**
 *@className TwentyEight 第28题
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/12 13:02
 *@version
 */
public class TwentyEight {
    /**
     *@description: strStr方法是给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。
     *@param: [haystack, needle]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/12 13:02
     */
    public int strStr(String haystack, String needle) {
        if(needle==null||"".equals(needle)){
            return 0;
        }
        if (haystack==null||haystack.length()<needle.length()||"".equals(haystack)){
            return -1;
        }
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        for (int i=0;i<=hay.length-nee.length;i++){
            if (hay[i]==nee[0]){
                boolean same = isSame(hay, nee, i);
                if (same){
                    return i;
                }
            }
        }
        return -1;
    }
    public boolean isSame(char[] c1,char[] c2,int start){
        if (start+c2.length>c1.length){
            return false;
        }
        for (int i=0;i<c2.length;i++){
            if (c1[i+start]!=c2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TwentyEight twentyEight=new TwentyEight();
        int i = twentyEight.strStr("hlll111ello", "asdf");
        System.out.println(i);
    }
}
