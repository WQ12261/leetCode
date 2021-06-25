package page.leetcode.three;

import page.common.tree.TreeNode;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class OneHundredAndFour {
    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }else {
            return depth(root, 0);
        }

    }
    public int depth(TreeNode node,int deep){
        deep++;
        if (node.left==null &&node.right==null){
            return deep;
        }else if (node.left==null){
            return depth(node.right, deep);
        }else if (node.right==null){
            return depth(node.left, deep);
        }else {
            int leftDeep=depth(node.left, deep);
            int rightDeep=depth(node.right, deep);
            return Math.max(leftDeep, rightDeep);
        }
    }
}
