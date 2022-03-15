package page.leetcode.three;

import page.common.tree.TreeNode;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndTwelve {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return hasSum(root, sum,0);
    }
    public boolean hasSum(TreeNode treeNode,int sum,int value){
        value+=treeNode.val;
        if (treeNode.left==null&&treeNode.right==null){
            if (sum==value){
                return true;
            }
        }else {
            if (treeNode.left!=null){
                if (hasSum(treeNode.left, sum, value)){
                    return true;
                }
            }
            if (treeNode.right!=null){
                if (hasSum(treeNode.right, sum, value)){
                    return true;
                }
            }
        }
        return false;
    }
}
