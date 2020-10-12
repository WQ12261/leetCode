package tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;
import tree.util.ClueStatue;

/**
 * @author 1226134406@qq.com
 * @className BinaryTree
 * @description 二叉树的学习
 * @time 2020/9/27 23:05
 */
public class BinaryTree<T> {

    private Node<T> root;

    public BinaryTree(int v) {
        this.root = new Node<T>(v);
    }

    public ClueStatue clueStatue;

    /**
     * @description: 二叉树的前序遍历
     * @param: []
     * @retrun: void
     * @auther: 1226134406@qq.com
     * @date: 2020/9/27 23:20
     */
    public void preTraverse() {
        judge();
        if (this.root != null) {
            this.root.preTraverse();
        }
    }


    /**
     * @description: 二叉树的中序遍历
     * @param: []
     * @retrun: void
     * @auther: 1226134406@qq.com
     * @date: 2020/9/27 23:21
     */
    public void centerTraverse() {
        judge();
        if (this.root != null) {
            this.root.centerTraverse();
        }
    }

    /**
     * @description: 二叉树的后序遍历
     * @param: []
     * @retrun: void
     * @auther: 1226134406@qq.com
     * @date: 2020/9/27 23:21
     */
    public void lastTraverse() {
        judge();
        if (this.root != null) {
            this.root.lastTraverse();
        }
    }

    /**
     * @description: search方法是查找算法，查找树种的节点是否含有e
     * @param: [t]
     * @retrun: boolean
     * @auther: 1226134406@qq.com
     * @date: 2020/10/3 22:04
     */
    public boolean search(T t) {
        judge();
        if (t == null) {
            throw new NullPointerException("参数值为null");
        }
        if (this.root == null) {
            return false;
        }
        return root.search(t);

    }

    /**
     * @description: remove方法是 删除含有e的节点，如果含有e的节点是非叶子节点就直接删除该子树
     * @param: [t]
     * @retrun: boolean
     * @auther: 1226134406@qq.com
     * @date: 2020/10/3 22:04
     */
    public boolean remove(T t) {
        judge();
        if (t == null) {
            throw new NullPointerException();
        }
        if (this.root.e.equals(t)) {
            this.root = null;
            return true;
        }
        return this.root.remove(t);
    }

    /**
     * @description: centerClueTree方法是 将树进行中序线索化
     * @param: []
     * @retrun: void
     * @auther: 1226134406@qq.com
     * @date: 2020/10/4 17:11
     */
    public void centerClueTree() {
        judge();
        root.makeCenterClue(null);
    }

    /**
     * @description: show方法是对一个数组进行前序遍历
     * @param: [arr, t]
     * @retrun: void
     * @auther: 1226134406@qq.com
     * @date: 2020/10/3 22:21
     */
    public static <E> void show(E[] arr, int i) {
        if (i >= arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.out.println(arr[i]);
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < arr.length) {
            show(arr, left);
        }
        if (right < arr.length) {
            show(arr, right);
        }
    }

    /**
     * @description: makePreClue方法是将树进行前序序列化
     * @param: []
     * @retrun: void
     * @auther: 1226134406@qq.com
     * @date: 2020/10/4 18:07
     */
    public void makePreClue() {
        judge();
        root.makePreClue(null);
    }

    /**
     * @description: makeCenterClue方法是将树进行中序序列化
     * @param: []
     * @retrun: void
     * @auther: 1226134406@qq.com
     * @date: 2020/10/4 18:10
     */
    public void makeCenterClue() {
        judge();
        root.makeCenterClue(null);
    }


    /**
     * @description: judgeBeforeClue方法是在线索化或者遍历前进行判断
     * @param: []
     * @retrun: void
     * @auther: 1226134406@qq.com
     * @date: 2020/10/4 18:13
     */
    private void judge() {
        if (clueStatue != null) {
            throw new RuntimeException("已" + clueStatue.getDesc());
        }
        if (this.root == null) {
            throw new RuntimeException("根节点为null");
        }
    }

    /**
     * @description: preClueTraverse方法是前序线索化后进行的遍历
     * @param: []
     * @retrun: void
     * @auther: 1226134406@qq.com
     * @date: 2020/10/4 18:36
     */
    public void preClueTraverse() {
        if (this.root == null) {
            throw new RuntimeException("根节点为null");
        }
        if (ClueStatue.PRE_CLUE != clueStatue) {
            throw new RuntimeException("还没有进行前序线索化或已进行其他的线索化");
        }
        Node<T> node = root;
        Node<T> preNode = null;
        while (node != null) {//如果节点为空就停止遍历
            System.out.println(root.e);
            if (node.leftNode == preNode) {
                //如果节点的前驱节点和该节点的左节点相同就向右节点遍历
                preNode = node;
                node = node.rightNode;
            } else {
                preNode = node;
                node = node.leftNode;
            }
        }
    }

    /**
     * @description: centerClueTraverse方法是中序线索化后进行的中序遍历
     * @param: []
     * @retrun: void
     * @auther: 1226134406@qq.com
     * @date: 2020/10/4 19:11
     */
    public void centerClueTraverse() {
        if (this.root == null) {
            throw new RuntimeException("根节点为null");
        }
        if (ClueStatue.CENTER_CLUE != clueStatue) {
            throw new RuntimeException("还没有进行前序线索化或已进行其他的线索化");
        }
        Node<T> node = root;
        Node<T> preNode = null;
        while (node.leftNode != null) {
            node = node.leftNode;
        }
        while (node != null) {
            System.out.println(node.e);
            if (node.leftNode == preNode) {
                preNode = node;
                node = node.rightNode;
            } else {
                preNode = node;
                node = node.leftNode;
            }
        }
    }
    /**
     *@description: putBST方法是二叉排序树向一棵二叉排序树中插入数据
     *@param: []
     *@retrun: tree.BinaryTree.Node<T>
     *@auther: 1226134406@qq.com
     *@date: 2020/10/8 14:14
     */
    public void putBST(int val){
        Node<T> node=new Node<>(val);
        Node<T> parent=new Node<>(0);
        parent.leftNode=root;
        if (this.root==null){
            this.root=node;
        }else {
            root.creatBST(node,parent,0);
        }
        this.root=parent.leftNode;
    }

    public void removeBSTNode(int val){
        if (root.val==val){
            Node<T> node=new Node<>(0);
            node.leftNode=root;
            root.removeNodeOnBST(val, node, 0);
            root=node.leftNode;
        }else {
            root.removeNodeOnBST(val, null, -1);
        }
    }

    public int height(){
        return root.height(1);
    }
    /**
     *@description: leftRotate方法是
     *@param: []
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/8 17:53
     */


    /**
     * @description: 树的节点
     * @auther: 1226134406@qq.com
     * @date: 2020/9/27 23:15
     */
    private static class Node<E> {
        Node(E e, Node<E> leftNode, Node<E> rightNode) {
            this.e = e;

            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        Node(E e) {
            this.e = e;
        }
        Node(int val){this.val=val;}
        int val;
        E e;
        Node<E> leftNode;
        Node<E> rightNode;

        /**
         * @description: 前序遍历
         * @retrun: void
         * @auther: 1226134406@qq.com
         * @date: 2020/9/27 23:13
         */
        void preTraverse() {
            System.out.println(this.val);
            if (this.leftNode != null) {
                this.leftNode.preTraverse();
            }
            if (this.rightNode != null) {
                this.rightNode.preTraverse();
            }
        }

        /**
         * @description: 二叉树节点的中序遍历
         * @retrun: void
         * @auther: 1226134406@qq.com
         * @date: 2020/9/27 23:13
         */
        void centerTraverse() {
            if (this.leftNode != null) {
                this.leftNode.centerTraverse();
            }
            System.out.println(e);
            if (this.rightNode != null) {
                this.rightNode.centerTraverse();
            }
        }

        /**
         * @description: 二叉树节点的后序遍历
         * @retrun: void
         * @auther: 1226134406@qq.com
         * @date: 2020/9/27 23:14
         */
        void lastTraverse() {
            if (this.leftNode != null) {
                this.leftNode.lastTraverse();
            }
            if (this.rightNode != null) {
                this.rightNode.lastTraverse();
            }
            System.out.println(e);
        }

        /**
         * @description: search方法是查找算法，查找树种的节点是否含有e
         * @param: [e]
         * @retrun: boolean 有就返回true,没有就返回false
         * @auther: 1226134406@qq.com
         * @date: 2020/10/3 21:52
         */
        boolean search(E e) {
            if (this.e.equals(e)) {
                return true;
            }
            if (this.leftNode != null) {
                boolean search = this.leftNode.search(e);
                if (search) {
                    return true;
                } else {
                    if (this.rightNode != null) {
                        return this.rightNode.search(e);
                    }
                }
            }

            return false;
        }

        /**
         * @description: remove方法是 删除含有e的节点，如果含有e的节点是非叶子节点就直接删除该子树
         * @param: [e]
         * @retrun: boolean 如果有删除操作就返回true，否则返回false
         * @auther: 1226134406@qq.com
         * @date: 2020/10/3 21:59
         */
        boolean remove(E e) {
            //先查找左子树
            if (this.leftNode != null) {
                if (this.leftNode.e.equals(e)) {
                    this.leftNode = null;
                    return true;
                } else {
                    this.leftNode.remove(e);
                }
            }
            //再查找右子树
            if (this.rightNode != null) {
                if (this.rightNode.e.equals(e)) {
                    this.rightNode = null;
                    return true;
                } else {
                    this.rightNode.remove(e);
                }
            }
            return false;
        }

        /**
         * @description: makePreClue方法是将二叉树进行前序线索化
         * @param: [preNode]
         * @retrun: void
         * @auther: 1226134406@qq.com
         * @date: 2020/10/3 23:17
         */
        Node<E> makePreClue(Node<E> preNode) {
            if (preNode != null && preNode.rightNode == null) {
                //如果前驱节点不为空并且前驱节点的右节点是空的话就讲前驱节点的右指针指向本节点
                preNode.rightNode = this;
            }
            if (this.leftNode == null) {
                //如果本节点的左节点是空的话，就讲本节点的左指针指向前驱节点
                this.leftNode = preNode;
            } else {
                //如果本节点的左节点不是空的，就让前驱节点等于左节点线索化后的节点
                preNode = this.leftNode.makePreClue(this);
            }
            if (this.rightNode == null) { //如果本节点的右节是空的话
                //如果本节点的左节点是空的话就返回本节点
                //如果本节点的左节点不是空的话，就返回左节点返回的Node
                return this.leftNode == null ? this : preNode;
            } else {
                return this.rightNode.makePreClue(preNode);
            }


        }

        /**
         * @description: makeCenterClue方法是将二叉树进行中序线索化
         * @param: [preNode]
         * @retrun: void
         * @auther: 1226134406@qq.com
         * @date: 2020/10/3 23:34
         */
        Node<E> makeCenterClue(Node<E> preNode) {
            if (this.leftNode != null) {
                preNode = this.leftNode.makeCenterClue(preNode);
            } else {
                if (preNode != null) {
                    this.leftNode = preNode;
                    if (preNode.rightNode == null) {
                        preNode.rightNode = this;
                    }
                }
            }
            if (this.rightNode == null) {
                return this;
            } else {
                return this.rightNode.makeCenterClue(this);
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", e=" + e +
                    '}';
        }
        /**
         *@description: creatBST方法是创建二叉排序树
         *@param: [node]
         *@retrun: void
         *@auther: 1226134406@qq.com
         *@date: 2020/10/6 18:19
         */
        public void creatBST(Node<E> node,Node<E> parent,int flag){
            if (node==null){
                return;
            }
            if(node.val>this.val){
                if (this.rightNode==null){
                    this.rightNode=node;
                }else {
                    this.rightNode.creatBST(node,this,1);
                }
            }else {
                if (this.leftNode==null){
                    this.leftNode=node;
                }else {
                    this.leftNode.creatBST(node,this,0);
                }
            }
            int left=0;
            int right=0;
            if (this.rightNode!=null){
                right=this.rightNode.height(1);
            }
            if (this.leftNode!=null){
                left=this.leftNode.height(1);
            }
            if (left-right>1){
                this.rightRotate(parent, flag);
            }else if (right-left>1){
                this.leftRotate(parent, flag);
            }

        }
        public Node<E> removeNodeOnBST(int val,Node<E> parent,int flag){
            if (this.val==val){
                Node<E> node=null;
                if (this.rightNode!=null&&this.leftNode!=null) {
                    node = this.leftNode.removeMaxNodeOnBst();
                    if (node!=this.leftNode){
                        node.leftNode=this.leftNode;
                    }
                    node.rightNode=this.rightNode;
                }else {
                    node=this.rightNode==null? this.leftNode:this.rightNode;

                }

                if (flag==0){
                    parent.leftNode=node;
                }else {
                    parent.rightNode=node;
                }
                this.rightNode=null;
                this.leftNode=null;
                return this;
            }else if (this.val>val&&this.leftNode!=null){
                return this.leftNode.removeNodeOnBST(val, this, 0);
            }else if (this.val<val&&this.rightNode!=null){
                return this.rightNode.removeNodeOnBST(val, this, 1);
            }
            return  null;
        }
        /**
         *@description:  方法是删除子树的值最大的节点
         *@param: []
         *@retrun: tree.BinaryTree.Node<E>
         *@auther: 1226134406@qq.com
         *@date: 2020/10/8 11:46
         */
        private Node<E> removeMaxNodeOnBst(){
            //找到子树的最右边的节点，将其删除并返回
            if (this.rightNode==null){
                return this;
            }else {
                Node<E> node=this.rightNode;
                Node<E> parent=this;
                while (node.rightNode!=null){
                    parent=node;
                    node=node.rightNode;
                }
                parent.rightNode=node.leftNode;
                node.leftNode=null;
                return node;
            }
        }
        /**
         *@description: height方法是返回以该节点为根节点的树的高度
         *@param: [a]
         *@retrun: int
         *@auther: 1226134406@qq.com
         *@date: 2020/10/8 15:20
         */
        int height(int a){
            if (this.leftNode==null&&this.rightNode==null){
                return a;
            }else {
                int h=0;
                if (this.leftNode!=null){
                    h=this.leftNode.height(a+1);
                }
                if (this.rightNode!=null){
                    int height = this.rightNode.height(a + 1);
                    h=h>height?h : height;
                }
                return h;
            }

        }
        /**
         *@description: leftRotate方法是左旋，让子树的根节点的右子节点当根节点。原来的根节点当左子节点，指向以前
         * 其右子节点的左子节点
         *@param: [parent：this节点的父节点, flag 0为左节点，1是右节点]
         *@retrun: tree.BinaryTree.Node<E> 子树的根节点
         *@auther: 1226134406@qq.com
         *@date: 2020/10/8 19:57
         */
        Node<E> leftRotate(Node<E> parent,int flag){
            Node<E> node=this.rightNode;
            this.rightNode=node.leftNode;
            node.leftNode=this;
            if (flag==0){
                parent.leftNode=node;
            }else {
                parent.rightNode=node;
            }
            return node;
        }
        /**
         *@description: rightRotate方法是右旋
         *@param: []
         *@retrun: tree.BinaryTree.Node<E>
         *@auther: 1226134406@qq.com
         *@date: 2020/10/8 20:41
         */
        Node<E> rightRotate(Node<E> parent,int flag){
            Node<E> node=this.leftNode;
            this.leftNode=node.rightNode;
            node.rightNode=this;
            if (flag==0){
                parent.leftNode=node;
            }else {
                parent.rightNode=node;
            }
            return node;
        }


    }


}
