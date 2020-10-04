package tree.sequence;

/**
 * @author 1226134406@qq.com
 * @className SequenceTree
 * @description
 * @time 2020/10/3 19:44
 */
public class SequenceTree {
    public static void preShow(int[] arr, int i) {
        System.out.println(arr[i]);
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left<arr.length){
            preShow(arr, left);
        }
        if (right<arr.length){
            preShow(arr, right);
        }
    }

    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7};
        preShow(arr, 0);
    }
}
