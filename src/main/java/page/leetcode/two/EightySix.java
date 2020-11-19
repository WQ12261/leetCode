package page.leetcode.two;

import page.common.list.ListNode;

import java.util.List;

/**
 * @author 1226134406@qq.com
 * @className EightySix
 * @description 第86题 分割链表
 * @time 2020/11/7 12:53
 */
public class EightySix {
    /**
     *@description: partition方法是
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     *
     * 你应当保留两个分区中每个节点的初始相对位置。
     *
     *@param: [head, x]
     *@retrun: page.common.list.ListNode
     *@auther: 1226134406@qq.com
     *@date: 2020/11/7 12:55
     */
    public ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }
        ListNode first=new ListNode(0);
        ListNode min=first;
        ListNode maxHead=new ListNode(x);
        ListNode maxTail=maxHead;

        ListNode node=head;
        while (node!=null){
            if (node.val<x){
                min.next=node;
                node=node.next;
                min=min.next;
                min.next=null;
            }else {
                maxTail.next=node;
                node=node.next;
                maxTail=maxTail.next;
                maxTail.next=null;
            }
        }
        min.next=maxHead.next;
        return first.next;
    }
}
