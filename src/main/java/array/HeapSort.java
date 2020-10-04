package array;

import array.util.ArrayUtil;

import java.util.Arrays;

/**
 *@className HeapSort
 *@description 堆排序
 *@author 1226134406@qq.com
 *@time 2020/10/4 22:52
 *@version
 */
public class HeapSort {
    /**
     *@description: heapSort方法是堆排序
     *@param: [arr]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/4 23:14
     */
    public static void heapSort(int[] arr){
        int len=arr.length;
        while (len>1){
            builtMaxHeap(arr, len);
            ArrayUtil.swap(arr, 0, --len);
        }
    }
    /**
     *@description: builtMaxHeap方法是 将树调整成大顶堆
     *@param: [arr, bound] bound是进行排序的范围
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/4 23:13
     */
    private static void builtMaxHeap(int[] arr,int bound){
        int len=bound/2-1;
        for (int i=len;i>=0;i--){
            minHeap(arr, i, bound);
        }
    }
    /**
     *@description: minHeap方法是对子树创建大顶堆
     *@param: [arr, i, bound]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/4 23:13
     */
    private static void minHeap(int[] arr,int i,int bound){
        int right=i*2+2;
        int left=i*2+1;
        int maxIndex=i;
        if (left<bound&&arr[left]>arr[maxIndex]){
            maxIndex=left;
        }
        if (right<bound&&arr[right]>arr[maxIndex]){
            maxIndex=right;
        }
        if (maxIndex!=i){
            ArrayUtil.swap(arr, i, maxIndex);
            minHeap(arr, maxIndex, bound);
        }
    }

    public static void main(String[] args) {
        int arr[] ={5,2,6,89,6,8,6,5,54,8,9,3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
