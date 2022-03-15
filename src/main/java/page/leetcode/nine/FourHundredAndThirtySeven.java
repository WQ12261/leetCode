package page.leetcode.nine;

import org.junit.Test;
import page.common.tree.TreeNode;

import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *  
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109 
 * -1000 <= targetSum <= 1000 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourHundredAndThirtySeven {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int[] count = new int[1];
        pathSumCount(root, root.val, targetSum, true, count);
        return count[0];
    }


    private void pathSumCount(TreeNode node, int initValue, int target, boolean flag, int[] count) {
        if (initValue == target) {
            count[0]++;
        }
        if (node.left != null) {
            int value = initValue + node.left.val;
            pathSumCount(node.left, value, target, flag, count);
            if (flag) {
                pathSumCount(node.left, node.left.val, target, false, count);
            }
        }
        if (node.right != null) {
            int value = initValue + node.right.val;
            pathSumCount(node.right, value, target, flag, count);
            if (flag) {
                pathSumCount(node.right, node.right.val, target, false, count);
            }
        }
    }

    @Test
    public void te() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        FourHundredAndThirtySeven fourHundredAndThirtySeven = new FourHundredAndThirtySeven();
        int i = fourHundredAndThirtySeven.pathSum(node1, 3);
        System.out.println(i);
    }

    public int pathSum2(TreeNode root, int targetSum) {
        return 0;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        ret += rootSum(root.left, targetSum);
        ret += rootSum(root.right, targetSum);
        return ret;
    }
    @Test
    public void test2(){
        System.out.println(Integer.MAX_VALUE);
    }
}
