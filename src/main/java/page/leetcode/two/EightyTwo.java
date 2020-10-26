package page.leetcode.two;

import page.common.list.ListNode;

/**
 *@className EightyTwo
 *@description 82题
 *@author 1226134406@qq.com
 *@time 2020/10/26 15:50
 *@version
 */

public class EightyTwo {
    /**
     *@description: deleteDuplicates方法是
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *@param: [head]
     *@retrun: page.common.list.ListNode
     *@auther: 1226134406@qq.com
     *@date: 2020/10/26 15:51
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode first=new ListNode(0);
        ListNode last=first;
        ListNode node = head;
        while (node!=null){
            int preValue=node.val;
            int count=1;
            while (node.next!=null&&node.next.val==preValue){
                node=node.next;
                count++;
            }
            if (count==1){
                last.next=node;
                last=last.next;
                node=node.next;
                last.next=null;
            }else {
                node=node.next;
            }

        }

        return first.next;
    }
    public static void show(ListNode node){
        while (node!=null){
            System.out.printf(String.valueOf(node.val)+" ");
            node=node.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(4);
        ListNode node6=new ListNode(4);
        ListNode node7=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        ListNode listNode = deleteDuplicates(node1);
        show(listNode);
    }
}
