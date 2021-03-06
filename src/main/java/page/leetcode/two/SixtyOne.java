package page.leetcode.two;

import page.common.list.ListNode;

/**
 *@ClassName SixtyOne
 *@description 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *@author 1226134406@qq.com
 *@time 2020/8/13 23:21
 */
public class SixtyOne {


    /**
     *@description: rotateRight方法是
     *@param: [head, k]
     *@retrun: page.common.list.ListNode
     *@auther: 1226134406@qq.com
     *@date: 2020/9/25 14:06
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode first=head;
        ListNode last=head;
        int len=1;
        while (last.next!=null){

            last=last.next;
            len++;
        }
        int n=len-k%len;
        last.next=first;
        while (n>0){
            last=first;
            first=first.next;
            n--;
        }
        last.next=null;
        return first;
    }
}
