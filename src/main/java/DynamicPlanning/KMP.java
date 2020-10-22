package DynamicPlanning;

/**
 *@className KMP
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/21 17:24
 *@version
 */
public class KMP {
    //获取一个字符串（子串）的部分匹配值
    public static int[] kmpNext(String string){
        char[] chars = string.toCharArray();
        int[] next=new int[string.length()];
        next[0]=0;
        for (int i=1,j=0;i<string.length();i++){
            //当chars[i]!=chars[j]时，我们需要从next[j-1]获取新的j
            //直到我们发现chars[i]==chars[j]相等时才退出
            while (j>0&&chars[i]!=chars[j]){
                j=next[j-1];
            }
            if (chars[i]==chars[j]){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
    /**
     *@description: search方法是
     *@param: [st1：原串, st2：子串]
     *@retrun: int 如果是-1就是没有匹配到，否则返回第一次匹配到的位置
     *@auther: 1226134406@qq.com
     *@date: 2020/10/21 19:05
     */
    public static  int search(String st1,String st2){
        //获取st2的部分匹配值
        int[] next = kmpNext(st2);
        int j=0;
        char[] str1 = st1.toCharArray();
        char[] str2 = st2.toCharArray();
        for (int i=0;i<=str1.length-str2.length;i++){
            if (str1[i]==str2[j]){
                j++;
                if (j==str2.length){
                    return i-j+1;
                }
            }else {
                while (j>0){
                    j=next[j];
                    if (str1[i]==str2[j]){
                        break;
                    }
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2="ABCDABD";
        String str3="ABCABDABC";
        String str4="DABCD";
        int[] ints = kmpNext(str2);

        int search = search(str1, str4);
        System.out.println(search);
        System.out.println("a".compareTo("ab"));

    }

}
