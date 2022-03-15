package page.leetcode.three;

import page.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndThirteen {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lists=new ArrayList<>();
        if (root==null){
            return lists;
        }
        sum(root, targetSum, 0, new ArrayList<>(), lists);
        return lists;
    }
    private void sum(TreeNode treeNode,int targetSum,int totalSum,List<Integer> list,List<List<Integer>> lists){
        totalSum+=treeNode.val;
        list.add(treeNode.val);
        if (treeNode.left==null&&treeNode.right==null){
            if (totalSum==targetSum){
                List<Integer> list1=new ArrayList<>(list);
                lists.add(list1);
            }
        }
        if (treeNode.left!=null){
            sum(treeNode.left, targetSum, totalSum, list, lists);
            list.remove(list.size()-1);
        }
        if (treeNode.right!=null){
            sum(treeNode.right, targetSum, totalSum, list, lists);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] preorder=new int[]{1,2,4,8,9,5,10,11,3,6,12,13,7,14,15};
        int[] inorder=new int[]{8,4,9,2,10,5,11,1,12,6,13,3,14,7,15};
        OneHundredAndFive oneHundredAndFive=new OneHundredAndFive();
        TreeNode treeNode = oneHundredAndFive.buildTree(preorder, inorder);
        OneHundredAndThirteen oneHundredAndThirteen=new OneHundredAndThirteen();
        List<List<Integer>> lists = oneHundredAndThirteen.pathSum(treeNode, 22);
        System.out.println(lists);
    }
}
