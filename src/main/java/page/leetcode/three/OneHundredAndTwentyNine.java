package page.leetcode.three;

import page.common.tree.TreeNode;

/**
 * @author 1226134406@qq.com
 * @className OnehundredAndTwentyNine
 * @description 129题
 * @time 2020/10/29 10:23
 */
public class OneHundredAndTwentyNine {
    /**
     *@description: sumNumbers方法是
     * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     * 计算从根到叶子节点生成的所有数字之和。
     * 说明: 叶子节点是指没有子节点的节点。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *@param: [root]
     *@retrun: int
     *@auther: 1226134406@qq.com
     *@date: 2020/10/29 10:26
     */
    public int sumNumbers(TreeNode root) {
        return 0;
    }
    public int sumNumbers(TreeNode root,int val,int sum){
        val=val*10+root.val;
        if (root.left==null&&root.right==null){
            sum+=val;
        }
        if (root.left!=null){
            int leftSum = sumNumbers(root.left, val, sum);
            sum+=leftSum;
        }
        if (root.right!=null){
            int rightSum = sumNumbers(root.right, val, sum);
            sum+=rightSum;
        }
        return sum;
    }
}
