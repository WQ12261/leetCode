package page.leetcode.three;

import page.common.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *@className OneHundredAndFortyTwo
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/10 11:41
 *@version
 */
public class OneHundredAndFortyTwo {
    /**
     *@description: detectCycle方法是给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
     *@param: [head]
     *@retrun: page.common.list.ListNode
     *@auther: 1226134406@qq.com
     *@date: 2020/10/10 11:44
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> listNodeSet=new HashSet<>();
        ListNode listNode=head;
        while (listNode!=null){
            if (listNodeSet.contains(listNode) ){
                return listNode;
            }else{
                listNodeSet.add(listNode);
                listNode=listNode.next;
            }
        }
        return null;
    }
}
