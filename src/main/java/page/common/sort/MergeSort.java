package page.common.sort;

import java.util.Arrays;

/**
 * @author 1226134406@qq.com
 * @ClassName MerageSort
 * @description TODO
 * @time 2020/8/24 23:09
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 19, 5, 6,123,435,21,45,576,8,9,123};
        int[] temp = new int[arr.length];
        sortMerge(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortMerge(int[] arr, int head, int end, int[] temp) {
        if (head < end) {
            sortMerge(arr, head, (head + end) / 2, temp);
            sortMerge(arr, (head + end) / 2 + 1, end, temp);
        }
        merge(arr, head, end, temp);
    }

    private static void merge(int[] arr, int start, int end, int[] temp) {
        int n = start;
        int i = start;
        int mid = (start + end ) / 2+1;
        int j = mid;
        for (; i < mid && j <= end; ) {
            if (arr[i] <= arr[j]) {
                temp[n] = arr[i];
                i++;
            } else {
                temp[n] = arr[j];
                j++;
            }
            n++;
        }
        while (i < mid) {
            temp[n] = arr[i];
            n++;
            i++;
        }
        while (j <= end) {
            temp[n] = arr[j];
            n++;
            j++;
        }
        n = start;
        for (; n <= end; n++) {
            arr[n] = temp[n];
        }
    }
}
