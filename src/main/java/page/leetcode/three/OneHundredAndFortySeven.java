package page.leetcode.three;

import page.common.list.ListNode;

/**
 * @author 1226134406@qq.com
 * @className OneHundredAndFortySeven
 * @description 第147题
 * @time 2020/11/20 13:10
 */
public class OneHundredAndFortySeven {
    /**
     *@description: insertionSortList方法是 对链表进行插入排序(升序)。
     *@param: [head]
     *@retrun: page.common.list.ListNode
     *@auther: 1226134406@qq.com
     *@date: 2020/11/20 13:12
     */
    public ListNode insertionSortList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode node=head.next;
        ListNode first=head;
        head.next=null;
        while (node!=null){
            ListNode nextNode=node.next;
            node.next=null;
            first=insertionSortList(first, node);
            node=nextNode;
        }
        return first;
    }
    private ListNode insertionSortList(ListNode list,ListNode node){
        if (node.val<=list.val){
            node.next=list;
            return node;
        }else {
            ListNode pre=list;
            ListNode con=list.next;
            while (true){
                if (con==null){
                    pre.next=node;
                    break;
                }else {
                    if (con.val>node.val){
                        pre.next=node;
                        node.next=con;
                        break;
                    }else {
                        pre=con;
                        con=con.next;
                    }
                }
            }
            return list;
        }

    }

    public static void main(String[] args) {
        ListNode listNode4=new ListNode(4);
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        listNode4.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        OneHundredAndFortySeven oneHundredAndFortySeven=new OneHundredAndFortySeven();
        ListNode node = oneHundredAndFortySeven.insertionSortList(listNode4);
        System.out.println(1);
    }
}
