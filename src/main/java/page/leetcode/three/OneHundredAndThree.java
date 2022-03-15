package page.leetcode.three;

import page.common.tree.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndThree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if (root==null){
            return lists;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean left=true;
        while (queue.peek()!=null){
            List<Integer> list=new ArrayList<>();

            int count=queue.size();
            for (int i=0;i<count;i++){
                TreeNode head = queue.poll();
                if (head.left!=null){
                    queue.add(head.left);
                }
                if (head.right!=null){
                    queue.add(head.right);
                }
                list.add(head.val);
            }
            if (left){
                left=false;
            }else {
                left=true;
                Collections.reverse(list);
            }
            lists.add(list);
        }

        return lists;
    }

    public static void main(String[] args) {

    }
}
