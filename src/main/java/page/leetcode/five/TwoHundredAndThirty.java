package page.leetcode.five;

import page.common.tree.TreeNode;

public class TwoHundredAndThirty {
    public static int kthSmallest(TreeNode root, int k) {
        int[] array = new int[2];
        array[0] = k;
        kthSmallest(root, array);
        return array[1];
    }

    private static void kthSmallest(TreeNode node, int[] array) {
        if (array[0] < 1) {
            return;
        }
        if (node.left != null) {
            kthSmallest(node.left, array);
        }
        if (array[0] == 1) {
            array[1] = node.val;
            array[0]--;
            return;
        } else {
            array[0] -= 1;
        }
        if (node.right != null) {
            kthSmallest(node.right, array);
        }

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        int i = kthSmallest(node1, 2);
        System.out.println(i);
    }


}
