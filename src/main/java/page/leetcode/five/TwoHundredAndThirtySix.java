package page.leetcode.five;

import page.common.tree.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class TwoHundredAndThirtySix {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int[] array = new int[1];
        return lowestCommonAncestor(root, p, q, array);
    }

    private TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q, int[] flag) {

        if (node == null) {
            return null;
        }
        TreeNode node1 = lowestCommonAncestor(node.left, p, q, flag);
        if (node1 != null) {
            if (flag[0] == 1) {
                return node1;
            } else if (node == p || node == q) {
                flag[0] = 1;
                return node;
            }
        }
        TreeNode node2 = lowestCommonAncestor(node.right, p, q, flag);
        if (node2 != null) {
            if (flag[0] == 1) {
                return node2;
            } else if (node == p || node == q) {
                flag[0] = 1;
                return node;
            }
        }

        if (node1 == null && node2 == null) {
            if (node == p || node == q) {
                return node;
            } else {
                return null;
            }
        } else if (node1 != null && node2 != null) {
            flag[0] = 1;
        }
        return node;
    }

    public static void main(String[] args) {

        for (int i = 3;i<10;i++){
            System.out.printf("%5d:\t%10s\n",i,Integer.toBinaryString(i));
        }


    }
}
