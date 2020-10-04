package tree.array;

import java.util.Arrays;
import java.util.Random;

/**
 *@className Array
 *@description
 *@author 1226134406@qq.com
 *@time 2020/9/28 8:39
 *@version
 */
public class Array {
    public static int[] getArray(int n){
        if (n<0){
            throw new RuntimeException("长度需要大于0");
        }
        int[] arr=new int[n];
        Random random=new Random(System.currentTimeMillis());
        for (int i=0;i<n;i++){
            arr[i]=random.nextInt(200);
        }
        return arr;
    }
    /**
     *@description: heapSort方法是堆排序
     *@param: [arr]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/4 22:34
     */
    public static void heapSort(int[] arr){
        int len=arr.length;
        while (len>1){
            builtMaxHeap(arr, len);
            swap(arr, 0, --len);

        }
    }

    /**
     *@description: builtMaxHeap方法是堆排序创建大顶堆
     *@param: [arr]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/4 22:25
     */
    private static void builtMaxHeap(int[] arr, int length){
        int len=length/2-1;
        for (int i=len;i>=0;i--){
            heapify(arr, i,length);
        }
    }

    /**
     *@description: heapify方法是将一个子树调整成大顶堆
     *@param: [arr, i]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/4 22:33
     */
    private static void heapify(int[] arr,int i,int length){
        int left=i*2+1;
        int right=i*2+2;
        int maxIndex=i;
        if (left<length&&arr[left]>arr[maxIndex]){
            maxIndex=left;
        }
        if (right<length&&arr[right]>arr[maxIndex]){
            maxIndex=right;
        }
        if (maxIndex!=i){
            swap(arr, maxIndex, i);
            heapify(arr, maxIndex,length);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int a=arr[i];
        arr[i]=arr[j];
        arr[j]=a;
    }

    public static void main(String[] args) {
        int arr[] ={5,2,6,1,89,6,8,6,5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
