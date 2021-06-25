package page.pointoffer;


import java.util.*;
import java.lang.*;

/**
 * 剑指 Offer 38. 字符串的排列
 */
public class ThirtyEight {
    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     */
    public String[] permutation(String s) {
        Set<String> stringList = new HashSet<>();
        if (s!=null&&s.length()>0){
            char[] chars = s.toCharArray();
            fullPermutation(0, chars.length-1, chars, new StringBuilder(), stringList);
        }
        String[] strings = stringList.toArray(new String[stringList.size()]);
        return strings;
    }
    public void fullPermutation(int startIndex,int endIndex,char[] array,StringBuilder s,Set<String> list){
        if (startIndex>endIndex){
            list.add(s.toString());
            return;
        }
        for (int i=startIndex;i<=endIndex;i++){
            swap(startIndex, i, array);
            s.append(array[startIndex]);
            fullPermutation(startIndex+1, endIndex, array, s, list);
            swap(startIndex, i, array);
            s.setLength(s.length()-1);
        }
    }
    public void swap(int a,int b,char[] array){
        char c=array[a];
        array[a]=array[b];
        array[b]=c;
    }
    public String[] methodTwo(String s){
        if (s==null||s.length()==0){
            return new String[0];
        }
        char[] chars = s.toCharArray();
        boolean [] flags=new boolean[chars.length];
        Arrays.sort(chars);
        List<String> list=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        backtrack(chars, 0, chars.length, stringBuilder, list,flags);
        String[] stringArray=new String[list.size()];
        list.toArray(stringArray);
        return stringArray;
    }
    public void backtrack(char[] arr,int i,int n,StringBuilder perm,List<String> list,boolean[] flags){
        if (i==n){
            list.add(perm.toString());
        }
        for (int j=0;j<n;j++){
            if (flags[j]||(j>0&&!flags[j-1]&&arr[j-1]==arr[j])){
                continue;
            }
            flags[j]=true;
            perm.append(arr[j]);
            backtrack(arr,i+1, n, perm, list, flags);
            perm.setLength(perm.length()-1);
            flags[j]=false;
        }
    }

    public static void main(String[] args) {
        ThirtyEight thirtyEight=new ThirtyEight();
        System.out.println(Arrays.toString(thirtyEight.methodTwo("aab")));
    }
}
