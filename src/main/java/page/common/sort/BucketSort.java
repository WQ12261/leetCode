package page.common.sort;

/**
 * @author 梁仕凯
 * @ClassName BucketSort
 * @description 桶排序
 * @time 2020/8/25 8:30
 */
public class BucketSort {
    public static void sortByBucket(int[] arr) {
        int length=0;
        for (int i=0;i<arr.length;i++){
            int len=(""+arr[i]).length();
            length=Integer.max(len,length);
        }
        int [][] arrs=new int[10][arr.length];
    }
}
