package page.leetcode.three;

import page.common.tree.TreeNode;

import java.util.*;

/**
 * @author 1226134406@qq.com
 * @className OneHundredAndSeven
 * @description 107题 二叉树的层次遍历 II
 * @time 2020/11/3 13:53
 */
public class OneHundredAndSeven {
    /**
     *@description: levelOrderBottom方法是 给定一个二叉树，返回其节点值自底向上的层次遍历。
     * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *@param: [root]
     *@retrun: java.util.List<java.util.List<java.lang.Integer>>
     *@auther: 1226134406@qq.com
     *@date: 2020/11/3 13:55
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if (root==null){
            return lists;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        Stack<List<Integer>> stack=new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list=new ArrayList<>();
            while (size>0){
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                size--;
            }
            stack.add(list);
        }
        while (!stack.isEmpty()){
            lists.add(stack.pop());
        }
        return lists;
    }


}
