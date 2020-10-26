package page.leetcode.two;

import page.common.list.ListNode;

import java.util.List;

/**
 *@className EightThree
 *@description 83
 *@author 1226134406@qq.com
 *@time 2020/10/26 15:32
 *@version
 */
public class EightyThree {
    /**
     *@description: deleteDuplicates方法是
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     *@param: [head]
     *@retrun: page.common.list.ListNode
     *@auther: 1226134406@qq.com
     *@date: 2020/10/26 15:34
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        int lastValue=head.val;
        ListNode last=head;

        ListNode right=head.next;
        last.next=null;
        while (right!=null){
            if (right.val!=lastValue){
                lastValue=right.val;
                last.next=right;
                right=right.next;
                last=last.next;
                last.next=null;
            }else {
                right=right.next;
            }
        }
        return head;
    }
}
