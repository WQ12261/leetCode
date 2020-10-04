package tree.array;

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
}
