package tree;

public class RBTree<T extends Comparable<T>> {

    public static class RBNode<T extends  Comparable<T>> {
        boolean color;// 颜色
        T key; //键值
        RBNode<T> left; //左子节点
        RBNode<T> right; //右子节点
        RBNode<T> parent;// 父节点

        public RBNode(T key, boolean color,RBNode<T> parent,RBNode<T> left,RBNode<T> right){
            this.key = key;
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        private void leftRotate(){
            RBNode<T> myRight = right; //当前节点的

            //
            Class a = Integer.class;

        }
    }


}
