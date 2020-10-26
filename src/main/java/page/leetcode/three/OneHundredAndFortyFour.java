package page.leetcode.three;

import page.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *@className OneHundredAndFortyFour
 *@description 144题
 *@author 1226134406@qq.com
 *@time 2020/10/26 13:23
 *@version
 */
public class OneHundredAndFortyFour {
    /**
     *@description: preorderTraversal方法是 给定一个二叉树，返回它的 前序 遍历。
     *@param: [root]
     *@retrun: java.util.List<java.lang.Integer>
     *@auther: 1226134406@qq.com
     *@date: 2020/10/26 13:25
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root!=null){
            preTraversal(root, list);
        }
        return list;
    }
    public void preTraversal(TreeNode node, List<Integer> list){
        list.add(node.val);
        if (node.left!=null){
            preTraversal(node.left,list);
        }
        if (node.right!=null){
            preTraversal(node.right, list);
        }
    }
}
