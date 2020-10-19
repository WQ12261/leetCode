package page.leetcode.three;

import page.common.list.ListNode;

/**
 *@className OneHundredFortyOne 第141题
 *@description 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。
 *@author 1226134406@qq.com
 *@time 2020/10/17 11:49
 *@version
 */
public class OneHundredFortyOne {
    /**
     *@description: hasCycle方法是 给定一个链表，判断链表中是否有环。
     * 解决方法是使用两个指针，一个慢指针，一次只向前移动一个。一个快指针，一次向前移动两个（虽然就移动两个，但是）
     *@param: [head]
     *@retrun: boolean
     *@auther: 1226134406@qq.com
     *@date: 2020/10/17 11:52
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        int n=2;
        while (true){
            while (n>0){
                if (fast.next==null){
                    return false;
                }
                fast=fast.next;
                if (fast==slow){
                    return true;
                }
                n--;
            }
            slow=slow.next;
            n=2;
        }
    }

    public static void main(String[] args) {

    }
}
