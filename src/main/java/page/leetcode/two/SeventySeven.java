package page.leetcode.two;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;

/**
 * 第77题
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class SeventySeven {
    public List<List<Integer>> combine(int n, int k) {
        int[] numbers=new int[n];
        while (n>0){
            numbers[n-1]=n--;
        }
        /*boolean[] flag1=new boolean[numbers.length];
        boolean[] flag2=new boolean[numbers.length];*/
        List<List<Integer>> lists=new ArrayList<>();
        if (k>0){
            permutation(numbers, 0, numbers.length-1, k, new ArrayList<>(), lists);
        }
        return lists;
    }
    private void permutation(int[] numbers,int start,int end,int k,List<Integer> list,List<List<Integer>> lists){
        if (list.size()==k){
            List<Integer> list1=new ArrayList<>(list);
            lists.add(list1);
            return;
        }
        if (start>end){
            return;
        }
        for (int i=start;i<=end;i++){
            swap(numbers, start, i);
            list.add(numbers[start]);
            permutation(numbers, i+1, end, k, list, lists);
            list.remove(list.size()-1);
            swap(numbers, start, i);
        }
    }
    private void swap(int[] numbers,int a,int b){
        int number=numbers[a];
        numbers[a]=numbers[b];
        numbers[b]=number;
    }

    public static void main(String[] args) {
        SeventySeven seventySeven=new SeventySeven();
        List<List<Integer>> combine = seventySeven.combine(5, 2);
        System.out.println(combine);
    }
}
