package tree.sequence;

/**
 * @author 1226134406@qq.com
 * @className SequenceTree
 * @description 顺序存储二叉树
 * @time 2020/10/3 19:44
 */
public class SequenceTree {
    /**
     *
     */

    /**
     * //顺序存储二叉树的前序遍历
     */
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

    /**
     * 顺序存储二叉树的中序遍历
     */
    public static void inorderTraversal(int[] arr,int index){
        if (index >= arr.length ){
            return;
        }
        int leftIndex = (index << 1) + 1;
        inorderTraversal(arr, leftIndex);
        System.out.println(arr[index]);
        inorderTraversal(arr, (index << 1) + 2);
    }




    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7};
        //preShow(arr, 0);
        inorderTraversal(arr, 0);
    }
}
