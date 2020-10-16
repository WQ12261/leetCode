package page.leetcode.two;

import java.util.Arrays;

/**
 *@className NinetySix 第96题
 *@description 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *@author 1226134406@qq.com
 *@time 2020/10/14 14:52
 *@version
 */
public class NinetySix {
    /**
     *@description: numTrees方法是 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     *@param: [n]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/14 14:53
     */
    public int numTrees(int n) {
        return 0;
    }
    /**
     *@description: allSort方法是 简单的全排列，和本题无关
     *@param: [arr, start, end]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/16 18:12
     */
    public void allSort(int arr[],int start,int end){
        if (start==end){
            System.out.println(Arrays.toString(arr));
        }
        for (int i=start;i<=end;i++){
            swap(arr, i, start);
            allSort(arr, start+1,end);
            swap(arr, i, start);
        }
    }

    public void swap(int arr[],int a,int b){
        int c=arr[a];
        arr[a]=arr[b];
        arr[b]=c;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        NinetySix ninetySix=new NinetySix();
        ninetySix.allSort(arr, 0,arr.length-1);
    }
}
