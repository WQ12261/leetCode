package page.leetcode.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 1226134406@qq.com
 * @ClassName FiftySix
 * @description 给出一个区间的集合，请合并所有重叠的区间
 * @time 2020/8/17 0:01
 */
public class FiftySix {
    public static void main(String[] args) {

        int[] array1 = {0, 1};
        int[] array0 = {4, 5};
        int[] array2 = {0, 2};
        int[] array3= {3,4};
        int[] array4={2,4};
        int[] array5={0,0};
        int[] array6={3,5};
        int[] array7={0,1};
        int[] array8={0,0};
        int[] array9={5,5};

        int[][] arrays = {array1, array0,array2,array3,array4,array5,array6,array7,array8,array9};
        FiftySix fiftySix = new FiftySix();
        int[][] merge = fiftySix.merge(arrays);
        System.out.println(Arrays.deepToString(merge));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        sortTowDimensArrayByInsert(intervals);
        System.out.println(Arrays.deepToString(intervals));
        List<int[]> list = new ArrayList<>();
        int n = 0;
        int b = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[n][0] == intervals[i][0]) {
                b = Integer.max(b, intervals[i][1]);
            } else if (intervals[i][0] > intervals[n][0]) {
                if (intervals[i][0] <= b) {
                    b = Integer.max(b, intervals[i][1]);
                } else {
                    int[] arr = new int[2];
                    arr[0] = intervals[n][0];
                    arr[1] = b;
                    list.add(arr);
                    b = intervals[i][1];
                    n = i;
                }
            }
        }
        int[] arr = new int[2];
        arr[0] = intervals[n][0];
        arr[1] = b;
        list.add(arr);
        int[][] arrays = new int[list.size()][];
        n = 0;
        for (int[] a : list) {
            arrays[n] = a;
            n++;
        }
        return arrays;
    }

    public void sortTowDimensArrayByInsert(int[][] intervals) {
        for (int i = 1; i < intervals.length; i++) {
            int n = i;
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[n][0] < intervals[j][0]) {
                    swap(j, n, intervals);
                    n--;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * @param l      右侧要被交换的位置
     * @param r      左侧要被交换的位置
     * @param arrays 二维数组
     * @Description 交换二维数组中的两个数组的位置
     */
    public void swap(int l, int r, int[][] arrays) {
        int[] s = arrays[l];
        arrays[l] = arrays[r];
        arrays[r] = s;
    }

}
