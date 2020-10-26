package page.leetcode.one;

import page.common.list.ListNode;

/**
 *@ClassName Twentyfive 第25题
 *@description K 个一组翻转链表
 *@author 1226134406@qq.com
 *@time 2020/8/13 22:11
 */
public class Twentyfive {
    /**
     *@description: reverseKGroup方法是
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *@param: [head, k]
     *@retrun: page.common.list.ListNode
     *@auther: 1226134406@qq.com
     *@date: 2020/10/22 9:26
     */
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
