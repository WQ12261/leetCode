package array.util;
/**
 *@className ArrayUtil
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/4 23:04
 *@version
 */
public class ArrayUtil {
    public static void swap(int[] arr,int i,int j){
        int a=arr[i];
        arr[i]=arr[j];
        arr[j]=a;
    }
}
