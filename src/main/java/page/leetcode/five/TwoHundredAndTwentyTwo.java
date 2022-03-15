package page.leetcode.five;

import page.common.tree.TreeNode;

/**
 *
 */
public class TwoHundredAndTwentyTwo {
    public int countNodes(TreeNode root) {
        return countNodes(root, 0);
    }

    private int countNodes(TreeNode node, int count){
        if (node == null){
            return count;
        }
        count ++;
        count = countNodes(node.left, count);
        return countNodes(node.right, count);
    }

    public static void main(String[] args) {

    }
}
