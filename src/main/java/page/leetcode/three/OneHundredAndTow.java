package page.leetcode.three;

import page.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 1226134406@qq.com
 * @className OneHundredAndTow
 * @description 102题
 * @time 2020/10/28 13:13
 */
public class OneHundredAndTow {
    /**
     *@description: levelOrder方法是 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *@param: [root]
     *@retrun: java.util.List<java.util.List<java.lang.Integer>>
     *@auther: 1226134406@qq.com
     *@date: 2020/10/28 13:14
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if (root==null){
            return lists;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
