package page.leetcode.six;

import page.common.tree.TreeNode;
import tree.array.Array;

import java.util.Arrays;

public class TwoHundredAndNinetySeven {
    public String serialize(TreeNode root) {
        StringBuilder nodeBuilder = new StringBuilder();
        serializeNode(root, nodeBuilder);
        return nodeBuilder.toString();
    }

    /**
     * 前序序列化二叉数
     */
    private void serializeNode(TreeNode node, StringBuilder nodeBuilder) {
        if (node == null) {
            nodeBuilder.append("#,");
            return;
        }
        nodeBuilder.append(node.val).append(",");
        serializeNode(node.left, nodeBuilder);
        serializeNode(node.right, nodeBuilder);
    }

    // Decodes your encoded data to tree.

    public TreeNode deserialize(String data) {
        String[] nodeValueList = data.split(",");
        TreeNode treeNode = new TreeNode(0);
        deserializeNodeValueList(treeNode, 0, nodeValueList, true);
        return treeNode.left;
    }

    /**
     * 递归遍历nodeList，创建二叉树
     */
    private int deserializeNodeValueList(TreeNode parentNode, int currentIndex, String[] nodeValueList, boolean isLeft) {
        if (nodeValueList[currentIndex].equals("#")) {
            return currentIndex;
        }
        TreeNode currentNode = new TreeNode(Integer.parseInt(nodeValueList[currentIndex]));
        if (isLeft) {
            parentNode.left = currentNode;
        } else {
            parentNode.right = currentNode;
        }
        currentIndex = deserializeNodeValueList(currentNode, ++currentIndex, nodeValueList, true);
        currentIndex = deserializeNodeValueList(currentNode, ++currentIndex, nodeValueList, false);
        return currentIndex;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        node3.right = node7;
        node4.left = node8;
        TwoHundredAndNinetySeven twoHundredAndNinetySeven = new TwoHundredAndNinetySeven();
        String serialize = twoHundredAndNinetySeven.serialize(node1);
        System.out.println(serialize);
        TreeNode node = twoHundredAndNinetySeven.deserialize(serialize);
        System.out.println(twoHundredAndNinetySeven.serialize(node));
    }
}
