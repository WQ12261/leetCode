package page.leetcode.twenty;

/**
 * @author 1226134406@qq.com
 * @className NineHundredAndFortyOne
 * @description 941题
 * @time 2020/11/3 11:17
 */
public class NineHundredAndFortyOne {
    /**
     *@description: validMountainArray方法是
     * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
     * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
     * A.length >= 3
     * 在 0 < i < A.length - 1 条件下，存在 i 使得：
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[A.length - 1]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-mountain-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *@param: [A]
     *@retrun: boolean
     *@auther: 1226134406@qq.com
     *@date: 2020/11/3 11:19
     */
    public boolean validMountainArray(int[] A) {
        if (A!=null&&A.length>=3){
            int i=0;
            int j=A.length-1;
            while (i<j-1){
                if (A[i+1]==A[i]){
                    return false;
                }
                if (A[i+1]<A[i]){
                    if (i==0){
                        return false;
                    }
                    break;
                }
                i++;
            }
            while (j>i){
                if (A[j-1]<=A[j]){
                    return false;
                }
                j--;
            }
            return true;
        }
        return false;
    }
}
