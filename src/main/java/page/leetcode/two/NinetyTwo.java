package page.leetcode.two;

import page.common.list.ListNode;

/**
 * @author 1226134406@qq.com
 * @className NinetyTwo
 * @description 92题：反转链表
 * @time 2020/10/31 11:25
 */
public class NinetyTwo {
    //反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
    //说明:
    //1 ≤ m ≤ n ≤ 链表长度。
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n){
            return head;
        }
        if (m!=1){
            int index = 1;
            ListNode mHead = head;
            while (index < m - 1 && mHead != null) {
                mHead = mHead.next;
                index++;
            }
            ListNode mNext = mHead.next;
            ListNode ite = mNext;
            mHead.next = null;
            while (index < n) {
                ListNode node = mHead.next;
                mHead.next = ite;
                ite = ite.next;
                mHead.next.next = node;
                index++;
            }
            if (mNext!=null){
                mNext.next = ite;
            }
            return head;
        }else {
            ListNode listNode=new ListNode(0);
            int index=1;
            ListNode first=head;
            ListNode ite=head;
            while (index<=n){
                ListNode next=listNode.next;
                listNode.next=ite;
                ite=ite.next;
                listNode.next.next=next;
                index++;
            }
            first.next=ite;
            return listNode.next;
        }
    }

    public static void main(String[] args) {
        /*ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;*/
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        ListNode node = reverseBetween(listNode1, 1, 2);

    }
}
