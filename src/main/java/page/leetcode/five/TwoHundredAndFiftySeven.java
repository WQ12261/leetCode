package page.leetcode.five;

import page.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoHundredAndFiftySeven {
    public List<String> binaryTreePaths(TreeNode root) {
        String s = "";
        List<String> list = new ArrayList<>();
        return list;
    }

    private void treePaths(TreeNode node, List<String> list, String string) {
        string += node.val;
        if (node.right == null && node.left == null) {
            list.add(string);
            return;
        }
        if (node.right != null) {
            treePaths(node.right, list, string);
        }
        if (node.left != null) {
            treePaths(node.left, list, string);
        }
    }

    public static void main(String[] args) {
        String a= "1234";
        System.out.println(a.substring(1));
    }
}
