package other;

import page.common.list.ListNode;
import page.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *@className OtherTest
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/26 22:36
 *@version
 */
public class OtherTest {
    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(5);
        TreeNode treeNode2=new TreeNode(4);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(2);
        TreeNode treeNode5=new TreeNode(7);
        TreeNode treeNode6=new TreeNode(1);
        TreeNode treeNode7=new TreeNode(12);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode4;
        treeNode2.left=treeNode3;
        treeNode4.left=treeNode5;
        treeNode4.right=treeNode6;
        treeNode6.right=treeNode7;
        OtherTest otherTest=new OtherTest();
        int i = otherTest.xSum(treeNode1);

        System.out.println("结果："+i);
        //使用前序遍历查看测试树结构是否一样
        otherTest.preTraverse(treeNode1);

    }
    public int xSum(TreeNode treeNode){
        if (treeNode==null){
            return 0;
        }
        return treeNode.val+xSum(treeNode.right)-xSum(treeNode.left);
    }
    //前序遍历
    public void preTraverse(TreeNode treeNode){
        System.out.printf("%d\t",treeNode.val);
        if (treeNode.left!=null){
            preTraverse(treeNode.left);
        }
        if (treeNode.right!=null){
            preTraverse(treeNode.right);
        }
    }
}
