package tree.threadTree;


public class ThreadTree<T> {
    private static class TreeNode<T> {
        T t;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T t) {
            this.t = t;
        }

        public TreeNode(T t, TreeNode<T> left, TreeNode<T> right) {
            this.t = t;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 中序序列化二叉树
     */
    public static  <T> TreeNode<T> inorderThreadBinaryTree(TreeNode<T> treeNode, TreeNode<T> preNode){
        if (treeNode.left != null){
            preNode = inorderThreadBinaryTree(treeNode.left, preNode);
        }else {
            treeNode.left = preNode;
        }
        if (preNode != null && preNode.right == null){
            preNode.right = treeNode;
        }
        if (treeNode.right == null){
            return treeNode;
        }else {
            return inorderThreadBinaryTree(treeNode.right, treeNode);
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeNode1 = new TreeNode<>(1);
        TreeNode<Integer> treeNode2 = new TreeNode<>(3);
        TreeNode<Integer> treeNode3 = new TreeNode<>(6);
        TreeNode<Integer> treeNode4 = new TreeNode<>(8);
        TreeNode<Integer> treeNode5 = new TreeNode<>(10);
        TreeNode<Integer> treeNode6 = new TreeNode<>(14);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        inorderThreadBinaryTree(treeNode1, null);
        System.out.println(treeNode1);
    }
}
