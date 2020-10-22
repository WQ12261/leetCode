package page.leetcode.eighteen;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import page.common.list.ListNode;

/**
 *@className EightHundredAndSeventySix 876题
 *@description 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *@author 1226134406@qq.com
 *@time 2020/10/20 13:03
 *@version
 */
public class EightHundredAndSeventySix {
    /**
     *@description: middleNode方法是 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     *
     * 如果有两个中间结点，则返回第二个中间结点。
     *@param: [head]
     *@retrun: page.common.list.ListNode
     *@auther: 1226134406@qq.com
     *@date: 2020/10/20 13:06
     */
    public ListNode middleNode(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }else if (head.next.next==null){
            return head.next;
        }else {
            ListNode fast=head;
            ListNode slow=head;
            while (fast!=null&&fast.next!=null){
                fast=fast.next;
                if (fast!=null){
                    fast=fast.next;
                }else {
                    break;
                }
                slow=slow.next;
            }
            return slow;
        }

    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        EightHundredAndSeventySix eightHundredAndSeventySix=new EightHundredAndSeventySix();
        ListNode listNode = eightHundredAndSeventySix.middleNode(listNode1);

        System.out.println(listNode.val);
    }
}
