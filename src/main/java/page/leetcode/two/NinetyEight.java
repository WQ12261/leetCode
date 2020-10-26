package page.leetcode.two;

import page.common.tree.TreeNode;

/**
 *@className NinetyEight 第98题
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/16 13:37
 *@version
 */
public class NinetyEight {
    /**
     *@description: isValidBST方法是 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * 来源：https://leetcode-cn.com/problems/validate-binary-search-tree/
     *@param: [root]
     *@retrun: boolean
     *@auther: 1226134406@qq.com
     *@date: 2020/10/16 13:39
     */
    public boolean isValidBST(TreeNode root) {
        boolean[] flag=new boolean[1];
        flag[0]=true;
        isValidBST(root, null, flag);
        return flag[0];
    }
    /**
     *@description: isValidBST方法是方法是 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *@param: [node：当前节点, pre：遍历当前节点的上一个节点]
     *@retrun: boolean
     *@auther: 1226134406@qq.com
     *@date: 2020/10/16 14:59
     */
    public TreeNode isValidBST(TreeNode node, TreeNode pre,boolean[] flag){
        if (!flag[0]){
            return null;
        }
        if (node.left!=null){
            pre=isValidBST(node.left, pre, flag);
        }
        if (pre!=null){
            if (pre.val>node.val){
                flag[0]=false;
                return null;
            }
        }
        if (node.right!=null){
            return isValidBST(node.right,node,flag);
        }else {
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        TreeNode treeNode6=new TreeNode(6);
        TreeNode treeNode7=new TreeNode(7);
        TreeNode treeNode8=new TreeNode(2);
        treeNode5.right=treeNode7;
        treeNode5.left=treeNode3;
        treeNode7.right=treeNode8;
        treeNode7.left=treeNode6;
        treeNode3.right=treeNode4;
        treeNode3.left=treeNode2;
        treeNode2.left=treeNode1;
        NinetyEight ninetyEight=new NinetyEight();
        boolean validBST = ninetyEight.isValidBST(treeNode5);
        System.out.println(validBST);
    }
}
