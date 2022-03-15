package page.pointoffer;

import page.common.tree.TreeNode;
import page.leetcode.three.OneHundredAndFive;

import java.util.ArrayList;
import java.util.List;

public class ThirtySeven {
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder=new StringBuilder();
        pre(root, stringBuilder);
        return stringBuilder.toString();
    }
    private void pre(TreeNode root,StringBuilder stringBuilder){
        if (root!=null){
            stringBuilder.append(root.val).append(",");
            pre(root.left, stringBuilder);
            pre(root.right, stringBuilder);
        }else {
            stringBuilder.append("null,");
        }
    }

    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        if (split.length==1&&"null".equals(split[0])){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(split[0]));
        createTree(root, 1, split);
        return root;
    }
    private int createTree(TreeNode treeNode,int index,String[] values){
        if (index==values.length){
            return index;
        }
        int current=index;
        //先创建左节点
        if (!"null".equals(values[current])){
            treeNode.left=new TreeNode(Integer.parseInt(values[current]));
            current=createTree(treeNode.left, current+1, values);
        }else {
            current++;
        }
        if (!"null".equals(values[current])){
            treeNode.right=new TreeNode(Integer.parseInt(values[current]));
            return createTree(treeNode.right,current+1,values);
        }else {
            return ++current;
        }
    }
    public static void main(String[] args) {
        int[] preorder=new int[]{1,2,4,8,9,5,10,11,3,6,12,13,7,14,15};
        int[] inorder=new int[]{8,4,9,2,10,5,11,1,12,6,13,3,14,7,15};
        OneHundredAndFive oneHundredAndFive=new OneHundredAndFive();
        TreeNode treeNode = oneHundredAndFive.buildTree(preorder, inorder);

        ThirtySeven thirtySeven=new ThirtySeven();
        String serialize = thirtySeven.serialize(treeNode);
        TreeNode deserialize = thirtySeven.deserialize(serialize);
        System.out.println(deserialize.val);

    }
}
