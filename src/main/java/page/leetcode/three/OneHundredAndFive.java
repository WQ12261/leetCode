package page.leetcode.three;

import page.common.tree.TreeNode;

import java.util.List;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndFive {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode=new TreeNode(preorder[0]);
        method(0, inorder.length-1, preorder, inorder, treeNode,0);
        return treeNode;
    }
    public void method(int startIndex,int endIndex,int[] preorder,int[] inorder,TreeNode treeNode,int nodeIndex){
        if (startIndex>endIndex){
            return;
        }
        int center=-1;
        for (int i=startIndex;i<=endIndex;i++){
            if (inorder[i]==treeNode.val){
                center=i;
                break;
            }
        }
        if (center==-1){
            return;
        }
        if (center>startIndex){//inorder中startIndex到center-1的都是左子节点的值
            int leftTreeNodeIndex=nodeIndex+1;
            TreeNode leftTreeNode=new TreeNode(preorder[leftTreeNodeIndex]);
            treeNode.left=leftTreeNode;
            method(startIndex, center-1, preorder, inorder, leftTreeNode, leftTreeNodeIndex);
        }
        if (center<endIndex){//inorder中center+1都是
            int rightTreeNodeIndex=nodeIndex+center-startIndex+1;

            TreeNode rightTreeNode=new TreeNode(preorder[rightTreeNodeIndex]);
            treeNode.right=rightTreeNode;
            method(center+1, endIndex, preorder, inorder, rightTreeNode, rightTreeNodeIndex);
        }
    }

    public static void main(String[] args) {
        int[] preorder=new int[]{1,2,4,8,9,5,10,11,3,6,12,13,7,14,15};
        int[] inorder=new int[] {8,4,9,2,10,5,11,1,12,6,13,3,14,7,15};
        OneHundredAndFive oneHundredAndFive=new OneHundredAndFive();
        TreeNode treeNode = oneHundredAndFive.buildTree(preorder, inorder);

        OneHundredAndThree oneHundredAndThree=new OneHundredAndThree();
        List<List<Integer>> lists =oneHundredAndThree.zigzagLevelOrder(treeNode);
        System.out.println(lists);


    }

}
