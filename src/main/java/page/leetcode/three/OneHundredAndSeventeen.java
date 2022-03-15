package page.leetcode.three;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 */
public class OneHundredAndSeventeen {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node pre = null;
        int len = 0;
        while (!queue.isEmpty()) {
            len = queue.size();
            pre = null;
            while (len != 0) {
                len--;
                Node poll = queue.poll();
                if (pre != null) {
                    pre.next = poll;
                } else {
                    pre = poll;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }

    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }
        Node headNode = null;
        Node currentNode = root;
        Node preNode = null;
        while (currentNode != null) {
            Node left = currentNode.left;
            Node right = currentNode.right;
            if(left != null){
                if(headNode == null){
                    headNode = left;
                }
                if (preNode != null){
                    preNode.next = left;
                }
                preNode = left;
                if (right != null){
                    left.next = right;
                    preNode = right;
                }
            }else {
                if (right != null){
                    if(headNode == null){
                        headNode = right;
                    }
                    if (preNode != null){
                        preNode.next = right;
                    }
                    preNode = right;
                }
            }
            currentNode = currentNode.next;
            if (currentNode == null) {
                currentNode = headNode;
                headNode = null;
                preNode = null;
            }
        }
        return root;
    }

}
