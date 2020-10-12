package search;


/**
 *@className BinarySearch
 *@description 二分查找的工具类
 *@author 1226134406@qq.com
 *@time 2020/10/11 23:43
 *@version
 */
public class BinarySearch {
    /**
     *@description: binarySearch方法是二分查找算法，非递归的方式
     *@param: [arr：要被查找的数组, value：要被查找的值, start：要被查找数组的起始索引, end：要被查找数组的结束索引]
     *@retrun: boolean
     *@auther: 1226134406@qq.com
     *@date: 2020/10/11 23:46
     */
    public boolean binarySearch(int[] arr,int value,int start,int end){
        int left=start;
        int right=end;
        while (left<=right){
            int mid=(left+right)/2;
            if (arr[mid]==value){
                return true;
            }else if (arr[mid]>value){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return false;
    }

    public boolean binarySearch1(int [] arr,int value,int start,int end){
        if (start>end){
            return false;
        }
        int mid=(start+end)/2;
        if (arr[mid]==value){
            return true;
        }else if (arr[mid]>value){
            return binarySearch1(arr,value,start,mid-1);
        }else {
            return binarySearch(arr, value, mid+1, end);
        }
    }
}
