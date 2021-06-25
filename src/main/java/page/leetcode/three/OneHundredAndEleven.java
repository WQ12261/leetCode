package page.leetcode.three;

import page.common.tree.TreeNode;

import java.util.Map;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class OneHundredAndEleven {
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return minDepth(root, 1);
    }
    public int minDepth(TreeNode root,int depth){
        if (root.left==null&&root.right==null){
            return depth;
        }else if (root.left==null){
            return minDepth(root.right,depth+1);
        }else if (root.right==null){
            return minDepth(root.left, depth+1);
        }else {
            int rightDepth=minDepth(root.right,depth+1);
            int leftDepth=minDepth(root.left,depth+1);
            return Math.min(rightDepth, leftDepth);
        }
    }
}
