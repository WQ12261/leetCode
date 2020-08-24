package page.common.list;

/**
 *@ClassName ListNode
 *@description
 *@author 1226134406@qq.com
 *@time 2020/8/13 22:07
 */
public class ListNode {
    int val;
    public ListNode next;
    public ListNode(int n){
        val=n;
    }
    public void showListNode(){
        System.out.println(val);
        if (this.next!=null){
            this.next.showListNode();
        }
    }
}
