package page.leetcode.four;

import page.common.tree.TreeNode;
import page.leetcode.three.OneHundredAndFive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndNinetyNine {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.peek() != null) {
            int size = queue.size();
            boolean flag = true;
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (flag){
                    list.add(poll.val);
                    flag=false;
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
                if (poll.left != null){
                    queue.add(poll.left);
                }
                size --;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15};
        int[] inorder = new int[]{8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15};
        OneHundredAndFive oneHundredAndFive = new OneHundredAndFive();
        TreeNode treeNode = oneHundredAndFive.buildTree(preorder, inorder);
        OneHundredAndNinetyNine oneHundredAndNinetyNine = new OneHundredAndNinetyNine();
        List<Integer> list = oneHundredAndNinetyNine.rightSideView(treeNode);
        System.out.println(list);
    }
}
