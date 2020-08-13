package page.one;

import common.ListNode;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import static org.junit.Assert.*;

/**
 * @author 1226134406@qq.com
 * @description
 * @create 2020/8/13 23:00
 */
public class TwentyfiveTest {
    private Twentyfive twentyfive;
    @Before
    public void setUp() throws Exception {
        twentyfive=new Twentyfive();
    }

    @Test
    public void reverseKGroup() {
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
        ListNode node = twentyfive.reverseKGroup(listNode5, 4);
        node.showListNode();

    }
}