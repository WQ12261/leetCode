package page.leetcode.three;

import page.common.list.ListNode;
import page.common.tree.TreeNode;

/**
 *@className OneHundredFourteen
 *@description 114题
 *@author 1226134406@qq.com
 *@time 2020/10/27 9:11
 *@version
 */
public class OneHundredFourteen {
    /**
     *@description: flatten方法是 给定一个二叉树，原地将它展开为一个单链表。
     *@param: [root]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/27 9:12
     */
    public void flatten(TreeNode root) {
        TreeNode treeNode=new TreeNode(0);
        if (root!=null){
            flatten(root, treeNode);
        }
    }

    public TreeNode flatten(TreeNode node, TreeNode ite){
        TreeNode leftNode=node.left;
        node.left=null;
        TreeNode rightNode=node.right;
        node.right=null;
        ite.right=node;
        ite=ite.right;
        if (leftNode!=null){
            ite = flatten(leftNode, ite);
        }
        if (rightNode!=null){
            ite=flatten(rightNode,ite);
        }
        return ite;
    }
}
