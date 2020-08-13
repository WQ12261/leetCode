package page.one;

import common.ListNode;

/**
 *@ClassName Twentyfive
 *@description TODO
 *@author 1226134406@qq.com
 *@time 2020/8/13 22:11
 */
public class Twentyfive {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null||k<=1){
            return head;
        }
        ListNode firstHead=new ListNode(0);
        ListNode secondHead=firstHead;
        ListNode thirdHead=head;
        ListNode node=head;
        int i=0;
        while (node!=null){
            ListNode node1=secondHead.next;
            ListNode node2=node.next;
            secondHead.next=node;
            node.next=node1;
            node=node2;
            i++;
            if (i==k){
                i=0;
                secondHead=thirdHead;
                thirdHead=node;
            }
        }
        if (i!=0){
            reverseTerm(secondHead);
        }
        return firstHead.next;
    }

    public void reverseTerm(ListNode head){
        ListNode first=head.next;
        if (first!=null){
            ListNode second=first.next;
            first.next=null;
            while (second!=null){
                ListNode node1=head.next;
                ListNode node2=second.next;
                head.next=second;
                second.next=node1;
                second=node2;
            }
        }
    }
}
