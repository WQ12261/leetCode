package page.leetcode.three;

import page.common.tree.TreeNode;

/**
 * @author 1226134406@qq.com
 * @className OneHundredAndTwentyFour
 * @description 124题
 * @time 2020/10/29 11:12
 */
public class OneHundredAndTwentyFour {
    /**
     *@description: maxPathSum方法是给定一个非空二叉树，返回其最大路径和。
     * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *@param: [root]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/29 11:13
     */
    public static int maxPathSum(TreeNode root) {
        int[] arr=new int[1];
        arr[0]=Integer.MIN_VALUE;
        maxPathSum(root, arr);
        return arr[0];
    }
    public static int maxPathSum(TreeNode node,int[] arr){
        int val=node.val;
        arr[0]=val>arr[0]? val:arr[0];
        int leftVal=0;
        int rightVal=0;
        if (node.left!=null){
            leftVal=maxPathSum(node.left, arr);

        }

        if (node.right!=null){
            rightVal=maxPathSum(node.right, arr);
        }

        int leftSum=val+leftVal;
        int rightSum=val+rightVal;
        //
        int total=leftSum+rightVal;
        arr[0]=arr[0]>total? arr[0]:total;
        //
        int bin=leftSum>rightSum? leftSum:rightSum;
        arr[0]=arr[0]>bin? arr[0]:bin;

        return bin>val? bin:val;
    }

    public static void main(String[] args) {
        TreeNode treeNode0=new TreeNode(1);
        TreeNode treeNode1=new TreeNode(-2);
        TreeNode treeNode2=new TreeNode(-3);
        TreeNode treeNode3=new TreeNode(1);
        TreeNode treeNode4=new TreeNode(3);
        TreeNode treeNode5=new TreeNode(-2);
        TreeNode treeNode6=new TreeNode(-1);

        treeNode0.left=treeNode1;
        treeNode0.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        treeNode2.left=treeNode5;
        treeNode3.left=treeNode6;

        int i = maxPathSum(treeNode0);
        System.out.println(i);
    }

}
