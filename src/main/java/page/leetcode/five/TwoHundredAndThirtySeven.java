package page.leetcode.five;

import page.common.list.ListNode;


public class TwoHundredAndThirtySeven {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
