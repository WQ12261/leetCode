package page.leetcode.ten;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 *@ClassName FourHundredAndFiftySix
 *@description 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *@author 1226134406@qq.com
 *@time 2020/8/24 22:34
 */
public class FourHundredAndFiftySix {

    public boolean repeatedSubstringPattern(String s) {
        if (s!=null&&s.length()>=2){
            int[] kmp = fromKmp(s);
            int len=kmp.length;
            if (kmp[len-1]==kmp[len-2]&&kmp[len-1]!=0) {
                int binary=s.length()-kmp[len-1];
                int i=1;
                int j=0;
                int index=i*binary+j;
                while (index<s.length()){
                    if (s.charAt(index)!=s.charAt(j)){
                        return false;
                    }
                    j++;
                    if (j==binary){
                        j=0;
                        i++;
                    }
                    index=i*binary+j;
                }
                if (j!=0){
                    return false;
                }
                return true;
            }
        }

        return false;
    }

    public int[] fromKmp(String str){
        int [] arr=new int[str.length()+1];
        arr[0]=0;
        int j=0;
        int i=1;
        int max=0;
        while (i<str.length()){
            while (str.charAt(j)!=str.charAt(i)&&j>1){
                j=arr[j-1];
            }

            if (str.charAt(j)==str.charAt(i)){

                j++;
                arr[i]=j;
                max=max>j? max:j;
            }
            i++;
        }
        arr[str.length()]=max;
        return arr;
    }
    public static void main(String[] args) {
        /*String string = "abcde";
        FourHundredAndFiftySix fourHundredAndFiftySix=new FourHundredAndFiftySix();

        System.out.println(fourHundredAndFiftySix.repeatedSubstringPattern(string));*/
        BigDecimal bigDecimal=new BigDecimal("1.2");
        BigDecimal bigDecimal1=new BigDecimal("1.2");
        System.out.println(bigDecimal.equals(bigDecimal1));
    }

}
