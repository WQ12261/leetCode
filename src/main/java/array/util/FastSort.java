package array.util;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author 1226134406@qq.com
 * @className FastSort
 * @description 快速排序
 * @time 2020/11/2 21:18
 */
public class FastSort {
    /**
     *@description: fastSort方法是 快速排序，将一个数组进行排序
     *@param: [array]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/11/2 23:00
     */
    public static void fastSort(int [] array){
        fastSort(array,0,array.length-1);
    }
    /**
     *@description: fastSort方法是 快速排序
     *@param: [array：数组, start：排序的起始索引, end：排序的结束索引]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/11/2 22:58
     */
    public static void fastSort(int[] array,int start,int end){
        if (start>=end||start<0||end>=array.length){
            return;
        }
        int i = subSort(array, start, end);
        fastSort(array, start, i-1);
        fastSort(array, i+1, end);
    }
    /**
     *@description: subSort方法是 将小于array[start]的数值都放在array[start]的左边，
     * 大于array[start]的数值都放在array[start]的右边
     *@param: [array, start：起始索引, end：结束索引]
     *@retrun: int 返回的是array[start]的索引位置
     *@auther: 1226134406@qq.com
     *@date: 2020/11/2 22:56
     */
    public static int subSort(int[] array,int start,int end){
        if (start>=end||start<0||end>=array.length){
            return -1;
        }
        int refer=array[start];
        int left=start+1;
        int right=end;
        while (left<right){
            while (left<right){
                if (array[left]>=refer){
                    break;
                }
                left++;
            }
            while (left<right){
                if (array[right]<refer){
                    break;
                }
                right--;
            }
            if (right==left){
                break;
            }
            swap(array,left,right);
            left++;
            right--;
        }
        if (array[left]<=array[start]){
            swap(array,left,start);
            return left;
        }else {
            swap(array, left-1, start);
            return  left-1;
        }

    }
    /**
     *@description: swap方法是 交换数组两个索引对应的值
     *@param: [array, i, j]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/11/2 22:55
     */
    public static void swap(int[] array,int i,int j){
        int n=array[i];
        array[i]=array[j];
        array[j]=n;
    }
    public void test(){
        int i=8;
        while ((i-=3)>0);
        System.out.println("i="+i);
    }

    public static void main(String[] args) {
        /*FastSort fastSort=new FastSort();
        for (int i=0;i<50_000;i++){
            fastSort.test();
        }*/
        Map<String,String> map=new HashMap<>();
        map.put("1", "1");
        Collection<String> values = map.values();
        List<String> list=new ArrayList<>();
        list.addAll(values);
        System.out.println(list);
        Map<String,Object> map1=new HashMap<>();
        map1.put("1", new BigDecimal("2"));
        BigDecimal bigDecimal = (BigDecimal) map1.get("2");
        System.out.println(bigDecimal);
    }
}
