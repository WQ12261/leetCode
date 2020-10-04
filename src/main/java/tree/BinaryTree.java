package tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import tree.util.ClueStatue;

/**
 * @author 1226134406@qq.com
 * @className BinaryTree
 * @description 二叉树的学习
 * @time 2020/9/27 23:05
 */
public class BinaryTree<T> {

    private Node<T> root;

    public BinaryTree(T t) {
        this.root = new Node<T>(t);
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
        if (t == null ) {
            throw new NullPointerException();
        }
        if (this.root.e.equals(t)) {
            this.root = null;
            return true;
        }
        return this.root.remove(t);
    }
    /**
     *@description: centerClueTree方法是 将树进行中序线索化
     *@param: []
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/4 17:11
     */
    public void centerClueTree(){
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
        if (left<arr.length){
            show(arr, left);
        }
        if (right<arr.length){
            show(arr, right);
        }
    }
    /**
     *@description: makePreClue方法是将树进行前序序列化
     *@param: []
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/4 18:07
     */
    public void makePreClue(){
        judge();
        root.makePreClue(null);
    }
    /**
     *@description: makeCenterClue方法是将树进行中序序列化
     *@param: []
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/4 18:10
     */
    public void makeCenterClue(){
        judge();
        root.makeCenterClue(null);
    }


    /**
     *@description: judgeBeforeClue方法是在线索化或者遍历前进行判断
     *@param: []
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/4 18:13
     */
    private void judge(){
        if (clueStatue!=null){
            throw new RuntimeException("已"+clueStatue.getDesc());
        }
        if (this.root==null){
            throw new RuntimeException("根节点为null");
        }
    }
    /**
     *@description: preClueTraverse方法是前序线索化后进行的遍历
     *@param: []
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/4 18:36
     */
    public void preClueTraverse(){
        if (this.root==null){
            throw new RuntimeException("根节点为null");
        }
        if (ClueStatue.PRE_CLUE!=clueStatue){
            throw new RuntimeException("还没有进行前序线索化或已进行其他的线索化");
        }
        Node<T> node=root;
        Node<T> preNode=null;
        while (node!=null){//如果节点为空就停止遍历
            System.out.println(root.e);
            if (node.leftNode==preNode){
                //如果节点的前驱节点和该节点的左节点相同就向右节点遍历
                preNode=node;
                node=node.rightNode;
            }else {
                preNode=node;
                node=node.leftNode;
            }
        }
    }
    /**
     *@description: centerClueTraverse方法是中序线索化后进行的中序遍历
     *@param: []
     *@retrun: void
     *@auther: 1226134406@qq.com
     *@date: 2020/10/4 19:11
     */
    public void centerClueTraverse(){
        if (this.root==null){
            throw new RuntimeException("根节点为null");
        }
        if (ClueStatue.CENTER_CLUE!=clueStatue){
            throw new RuntimeException("还没有进行前序线索化或已进行其他的线索化");
        }
        Node<T> node=root;
        Node<T> preNode=null;
        while (node.leftNode!=null){
            node=node.leftNode;
        }
        while (node!=null){
            System.out.println(node.e);
            if (node.leftNode==preNode){
                preNode=node;
                node=node.rightNode;
            }else {
                preNode=node;
                node=node.leftNode;
            }
        }
    }

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
            System.out.println(this.e);
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
         *@description: makePreClue方法是将二叉树进行前序线索化
         *@param: [preNode]
         *@retrun: void
         *@auther: 1226134406@qq.com
         *@date: 2020/10/3 23:17
         */
        Node<E> makePreClue(Node<E> preNode){
            if (preNode!=null&&preNode.rightNode==null){
                //如果前驱节点不为空并且前驱节点的右节点是空的话就讲前驱节点的右指针指向本节点
                preNode.rightNode=this;
            }
            if (this.leftNode ==null){
                //如果本节点的左节点是空的话，就讲本节点的左指针指向前驱节点
                this.leftNode=preNode;
            }else {
                //如果本节点的左节点不是空的，就让前驱节点等于左节点线索化后的节点
                preNode=this.leftNode.makePreClue(this);
            }
            if (this.rightNode==null){ //如果本节点的右节是空的话
                //如果本节点的左节点是空的话就返回本节点
                //如果本节点的左节点不是空的话，就返回左节点返回的Node
                return this.leftNode==null? this:preNode;
            }else {
                return this.rightNode.makePreClue(preNode);
            }


        }
        /**
         *@description: makeCenterClue方法是将二叉树进行中序线索化
         *@param: [preNode]
         *@retrun: void
         *@auther: 1226134406@qq.com
         *@date: 2020/10/3 23:34
         */
        Node<E> makeCenterClue(Node<E> preNode){
            if(this.leftNode!=null){
                preNode=this.leftNode.makeCenterClue(preNode);
            }else {
                if (preNode!=null){
                    this.leftNode=preNode;
                    if (preNode.rightNode==null){
                        preNode.rightNode=this;
                    }
                }
            }
            if (this.rightNode==null){
                return this;
            }else {
                return this.rightNode.makeCenterClue(this);
            }
        }

    }


}
