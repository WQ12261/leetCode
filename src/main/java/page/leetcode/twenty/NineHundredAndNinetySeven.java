package page.leetcode.twenty;

import java.util.Arrays;

/**
 *@className NineHundredAndNinetySeven 第977题
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/16 13:03
 *@version
 */
public class NineHundredAndNinetySeven {
    /**
     *@description: sortedSquares方法是给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     * 来自：https://leetcode-cn.com/problems/squares-of-a-sorted-array/
     *@param: [A]
     *@retrun: int[]
     *@auther: 1226134406@qq.com
     *@date: 2020/10/16 13:04
     */
    public int[] sortedSquares(int[] A) {
        int[] arr=new int[A.length];
        if (A.length==0){//如果数组中没有任何原素就直接返回
            return arr;
        }
        int i=0;
        int index=0;
        while (i<A.length&&A[i]<0){
            i++;
        }
        int j=i-1;
        while (j>=0&&i<A.length){
            if ((-A[j])<A[i]){
                arr[index]=A[j]*A[j];
                j--;
            }else {
                arr[index]=A[i]*A[i];
                i++;
            }
            index++;
        }
        if (index<A.length){
            while (j>=0){
                arr[index]=A[j]*A[j];
                index++;
                j--;
            }
            while (i<A.length){
                arr[index]=A[i]*A[i];
                i++;
                index++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={-3,-2,-1};
        NineHundredAndNinetySeven nineHundredAndNinetySeven=new NineHundredAndNinetySeven();
        int[] array = nineHundredAndNinetySeven.sortedSquares(arr);
        System.out.println(Arrays.toString(array));
    }
}
