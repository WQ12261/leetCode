package page.leetcode.five;

import page.common.list.ListNode;

/**
 * @author 1226134406@qq.com
 * @className TwoHundredAndFour
 * @description 204题
 * @time 2020/10/29 20:31
 */
public class TwoHundredAndFour {
    /**
     *@description: reverseList方法是 翻转链表
     *@param: [head]
     *@retrun: page.common.list.ListNode
     *@auther: 1226134406@qq.com
     *@date: 2020/10/29 20:31
     */
    public ListNode reverseList(ListNode head) {
        ListNode first=new ListNode(0);
        ListNode h=head;
        while (h!=null){
            ListNode next=first.next;
            first.next=h;
            h=h.next;
            first.next.next=next;
        }
        return first.next;
    }
}
