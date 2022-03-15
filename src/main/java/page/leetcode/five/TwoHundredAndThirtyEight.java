package page.leetcode.five;

import tree.array.Array;

import java.lang.ref.WeakReference;
import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoHundredAndThirtyEight {
    public static int[] productExceptSelf(int[] nums) {
        int[] array = new int[nums.length];
        array[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            array[i] = array[i - 1] * nums[i - 1];
        }
        int c = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) {
            array[j] *= c;
            c *= nums[j];
        }
        return array;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal local= new ThreadLocal();


        Thread thread = Thread.currentThread();
        WeakReference<Integer> weakReference = new WeakReference<>(987498);
        local.set(987498);
        System.gc();

        Thread.sleep(10);
        System.out.println(weakReference.get());

        int [] array2 = new int[1024*768];
        Object o = local.get();
        System.out.println(array2);
        System.out.println(o);
    }
}
