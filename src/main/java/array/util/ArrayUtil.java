package array.util;

import tree.array.Array;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author 1226134406@qq.com
 * @className ArrayUtil
 * @description
 * @time 2020/10/4 23:04
 */
public class ArrayUtil {
    public static void swap(int[] arr, int i, int j) {
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }

    /**
     * @description: generatorOneDimension方法是生成一个一维数组
     * @param: [col：长度, max数组中的最大值, hasNegative：是否有复数]
     * @retrun: int[]
     * @auther: 1226134406@qq.com
     * @date: 2020/10/27 12:00
     */
    public static int[] generatorOneDimension(int col, int max, boolean hasNegative) {
        int[] array = new int[col];
        Random random = new Random();
        Random random1 = new Random(random.nextLong());
        for (int i = 0; i < array.length; i++) {
            int val = random.nextInt(max);
            if (hasNegative) {
                array[i] = random1.nextBoolean() ? val : -val;
            } else {
                array[i] = val;
            }
        }
        return array;
    }

    public static int[][] generatorTwoDimension(int col, int row, int max, boolean hasNegative) {
        int[][] arrays = new int[row][];
        for (int i = 0; i < arrays.length; i++) {
            int[] array = generatorOneDimension(col, max, hasNegative);
            arrays[i] = array;
        }
        return arrays;
    }

    public static void showOnwDimension(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void showTowDimension(int[][] arrays) {
        for (int[] array : arrays) {
            showOnwDimension(array);
        }
    }

    /**
     * 全排列
     */
    public List<String> fullPermutation(int[] array) {
        List<String> list = new ArrayList<>();
        if (array == null || array.length == 0) {
            return list;
        }
        privateFullPermutation(array, new StringBuilder(), 0, list);
        return list;
    }

    public void privateFullPermutation(int[] array, StringBuilder stringBuilder, int start, List<String> list) {
        if (start >= array.length) {
            list.add(stringBuilder.toString());
            return;
        }
        for (int i = start; i < array.length; i++) {
            swap(array, start, i);
            stringBuilder.append(array[start]);
            privateFullPermutation(array, stringBuilder, start + 1, list);
            swap(array, start, i);
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        }

    }

    public static void main(String[] args) {
        /*ArrayUtil arrayUtil = new ArrayUtil();
        List<String> list = arrayUtil.fullPermutation(new int[]{1, 2, 3, 4, 5, 6});
        list.forEach(System.out::println);*/
        System.out.println(11|10);

    }

}
