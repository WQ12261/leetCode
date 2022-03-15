package page.leetcode.five;

import page.common.list.ListNode;

import java.util.List;

public class TwoHundredAndThree {
    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(0);

        ListNode node = head;
        ListNode pre = first;
        while (node != null){
            if (node.val != val){
                pre.next = node;
                pre = node;
            }else {
                pre.next = null;
            }
            node = node.next;
        }
        return first.next;
    }
}
