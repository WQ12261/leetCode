package page.leetcode.fifteen;

import org.junit.Before;
import org.junit.Test;
import page.common.list.ListNode;
import tree.array.Array;

import java.util.Random;

/**
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * <p>
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * <p>
 * 返回一个由上述 k 部分组成的数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SevenHundredAndTwentyFive {

    private ListNode head;

    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode[] listNodes = new ListNode[k];
        ListNode point = head;
        while (point != null) {
            size++;
            point = point.next;
        }
        int remainder = size % k;
        int count = size / k;
        size = count;

        int listPoint = 0;
        point = head;
        while (point != null) {

            if (count > 0) {
                if (count == size) {
                    listNodes[listPoint] = point;
                    listPoint++;
                }
                count--;
                if (count == 0) {
                    if (remainder > 0) {
                        point = point.next;
                        remainder--;
                    }
                    count = size;
                    if (point != null) {
                        ListNode node = point.next;
                        point.next = null;
                        point = node;
                    }
                } else {
                    point = point.next;
                }

            } else {
                listNodes[listPoint] = point;
                listPoint++;
                ListNode node = point.next;
                point.next = null;
                point = node;
            }
        }
        return listNodes;
    }

    @Before
    public void before(){
        int count = 3;
        ListNode listNode =new  ListNode(1);
        head = listNode;
        count -- ;
        int round = 10;
        Random random = new Random();
        while (count > 0 ){
            count --;
            ListNode node = new ListNode(random.nextInt(round));
            listNode.next = node;
            listNode = node;
        }
    }

    @Test
    public void test(){
        ListNode[] listNodes = splitListToParts(head, 5);
        System.out.println(listNodes);
    }

    @Test
    public void teat(){

    }
}
