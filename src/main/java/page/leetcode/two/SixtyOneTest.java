package page.leetcode.two;

import page.common.ListNode;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 1226134406@qq.com
 * @description
 * @create 2020/8/13 23:46
 */
public class SixtyOneTest {
    private SixtyOne sixtyOne;
    @Before
    public void setUp() throws Exception {
        sixtyOne=new SixtyOne();
    }

    @Test
    public void rotateRight() {
        ListNode listNode=new ListNode(0);
        ListNode listNode1=new ListNode(1);
        listNode1.next=listNode;
        ListNode listNode2=new ListNode(2);
        listNode2.next=listNode1;
        ListNode listNode3=new ListNode(3);
        listNode3.next=listNode2;
        ListNode listNode4=new ListNode(4);
        listNode4.next=listNode3;
        ListNode listNode5=new ListNode(5);
        listNode5.next=listNode4;
        ListNode listNode6 = sixtyOne.rotateRight(listNode5, 2);
        listNode6.showListNode();
    }
}