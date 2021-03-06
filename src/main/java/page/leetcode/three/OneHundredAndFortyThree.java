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
        if (head==null||head.next==null){
            return;
        }
        ListNode centerNode = getCenterNode(head);
        ListNode reverseList = reverseList(centerNode);
        merageList(head, reverseList);
    }
    /**
     *@description: getCenterNode方法是 获取链表的中间节点，中间节点和中间节点的父节点会断开
     *@param: [head]
     *@retrun: page.common.list.ListNode
     *@auther: 1226134406@qq.com
     *@date: 2020/11/19 23:03
     */
    private ListNode getCenterNode(ListNode head) {
        if (head == null) {
            return null;
        } else {
            ListNode fast = head;
            ListNode slow = head;
            ListNode preSlow=slow;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                preSlow=slow;
                slow = slow.next;
            }
            preSlow.next=null;
            return slow;
        }
    }
    /**
     *@description: reverseList方法是 反转一个链表
     *@param: [listNode]
     *@retrun: page.common.list.ListNode
     *@auther: 1226134406@qq.com
     *@date: 2020/11/19 23:03
     */
    private ListNode reverseList(ListNode listNode){
        ListNode head=new ListNode(0);
        ListNode node=listNode;
        while (node!=null){
            ListNode secondNoe=head.next;
            head.next=node;
            node=node.next;
            head.next.next=secondNoe;
        }
        return head.next;
    }
    /**
     *@description: merageList方法是 交叉合并两个链表
     *@param: [first, second]
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/11/19 23:04
     */
    private void merageList(ListNode first,ListNode second){
        ListNode node=first;
        ListNode reverseNode=second;
        while (node!=null){
            ListNode nextNode=node.next;
            ListNode reverseNodeNext=reverseNode.next;
            node.next=reverseNode;
            if (nextNode!=null){
                reverseNode.next=nextNode;
            }
            node=nextNode;
            reverseNode=reverseNodeNext;
        }
    }



    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        OneHundredAndFortyThree oneHundredAndFortyThree=new OneHundredAndFortyThree();
        oneHundredAndFortyThree.reorderList(listNode1);
    }
}
