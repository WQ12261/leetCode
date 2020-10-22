package page.leetcode.three;

import page.common.list.ListNode;

/**
 * @author 1226134406@qq.com
 * @className OneHundredAndFortyThree 第143题：重排链表
 * @description 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @time 2020/10/20 11:16
 */
public class OneHundredAndFortyThree {
    public void reorderList(ListNode head) {

    }

    private ListNode getCenterNode(ListNode head) {
        if (head == null) {
            return null;
        } else {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    private ListNode reverseList(ListNode listNode){
        ListNode head=new ListNode(0);

        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        //ListNode listNode4=new ListNode(4);
        //ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        //listNode3.next=listNode4;
        //listNode4.next=listNode5;
        OneHundredAndFortyThree oneHundredAndFortyThree=new OneHundredAndFortyThree();
        ListNode centerNode = oneHundredAndFortyThree.getCenterNode(listNode1);
        System.out.println(centerNode.val);
    }
}
