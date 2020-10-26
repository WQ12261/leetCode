package array.util;

import java.util.Arrays;

/**
 *@className TowDimension
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/24 11:30
 *@version
 */
public class TowDimension {
    /**
     *@description: heapSort方法是对二维数组进行堆排序
     *@param: [towDimension]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/24 12:23
     */
    public void heapSort(int [][]towDimension){
        int len=towDimension.length-1;
        while (len>0){
            maxHeap(towDimension, len);
            swap(towDimension, 0, len);
            len-=1;
        }
    }


    /**
     *@description: maxHeapSort方法是 对一个二维数组创建成一个最大堆
     *@param: [towDimension, start, end]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/24 12:13
     */
    public void maxHeap(int [][] towDimension,int end){
        int index=(end+1)/2-1;
        while (index>=0){
            maxLeafHeap(towDimension, index,end);
            swap(towDimension, 0, index);
            index--;
        }
    }

    /**
     *@description: buildMaxLeaf方法是 对一个索引为index的子树创建成一个最大堆
     *@param: [towDimension:二维数组, index索引]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/24 11:53
     */
    public void maxLeafHeap(int[][] towDimension,int index,int len){
        int left=index*2+1;
        int right=index*2+2;
        int max = maxIndex(towDimension, left, right,len);
        if (max!=-1){
            max=maxIndex(towDimension, index, max,len);
            if (max!=index){
                swap(towDimension, index, max);
                maxLeafHeap(towDimension, max,len);
            }
        }

    }

    public void swap(int[][] towDimension,int i,int j){
        int []arr=towDimension[i];
        towDimension[i]=towDimension[j];
        towDimension[j]=arr;
    }


    public int maxIndex(int[][] towDimension,int i,int j,int len){
        if (i>len&&j>len){
            return -1;
        }else if (i>len&&j<=len){
            return j;
        }else if (i<=len&&j>len){
            return i;
        }else {
            int[] arrI=towDimension[i];
            int[] arrJ=towDimension[j];
            if (arrI[0]>arrJ[0]||arrI[0]==arrJ[0]&&arrI[1]>=arrJ[1]){
                return i;
            }else {
                return j;
            }
        }
    }

    public static void showTowDimension(int[][]arr){
        for (int[]array:arr){
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int []arr={0,2};
        int []arr1={1,3};
        int []arr2={0,3};
        int []arr3={2,1};
        int []arr4={3,1};
        int []arr5={2,3};
        int []arr6={1,4};
        int[][]tow={arr,arr1,arr2,arr3,arr4,arr5,arr6,arr,arr1};
        TowDimension towDimension=new TowDimension();
        showTowDimension(tow);
        System.out.println("================================================");

        towDimension.heapSort(tow);
        showTowDimension(tow);
    }
}
