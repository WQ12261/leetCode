package page.leetcode.three;

import page.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *@className OneHundredAndFortyFive
 *@description 145题
 *@author 1226134406@qq.com
 *@time 2020/10/27 8:59
 *@version
 */
public class OneHundredAndFortyFive {
    /**
     *@description: postorderTraversal方法是 二叉树的后序遍历
     *@param: [root]
     *@retrun: java.util.List<java.lang.Integer>
     *@auther: 1226134406@qq.com
     *@date: 2020/10/27 8:59
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();

        if (root!=null){
            postTraversal(root, list);
        }
        return list;
    }
    public void postTraversal(TreeNode node,List<Integer> list){
        if (node.left!=null){
            postTraversal(node.left, list);
        }
        if (node.right!=null){
            postTraversal(node.right, list);
        }
        list.add(node.val);
    }
}
