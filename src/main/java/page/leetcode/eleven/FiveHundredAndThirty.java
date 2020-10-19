package page.leetcode.eleven;



import page.common.tree.TreeNode;

/**
 * @author 1226134406@qq.com
 * @className FiveHundredAndThirty
 * @description 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * @time 2020/10/12 8:40
 */
public class FiveHundredAndThirty {
    /**
     * @description: getMinimumDifference方法是
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     * 方法是使用中序遍历
     * @param: [root]
     * @retrun: int
     * @auther: 1226134406@qq.com
     * @date: 2020/10/12 8:45
     */
    public int getMinimumDifference(TreeNode root) {
        int min=Integer.MAX_VALUE;
        TreeNode treeNode=new TreeNode(-1);
        return getMinimumDifference(root, treeNode, min);
    }
    private int getMinimumDifference(TreeNode root, TreeNode first,int min){
        if (root.left!=null){
            int left = getMinimumDifference(root.left, first, min);
            min=Math.min(left, min);
        }
        if (first.val==-1){
            first.val=root.val;
        }else {

            int center=Math.abs(first.val-root.val);
            first.val=root.val;
            min=Math.min(center, min);
        }
        if (root.right!=null){
            int right=getMinimumDifference(root.right, first, min);
            min=Math.min(right, min);
        }
        return min;
    }



}
