package tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 1226134406@qq.com
 * @description
 * @create 2020/10/8 15:37
 */
public class BinaryTreeTest {

    @Test
    public void putBST() {

//        BinaryTree<Character> binaryTree=new BinaryTree<>(20);
//        binaryTree.putBST(16);
//        binaryTree.putBST(13);
//        binaryTree.putBST(17);
//        binaryTree.putBST(12);
//        binaryTree.putBST(14);
//        binaryTree.putBST(30);
//        binaryTree.putBST(25);
//        binaryTree.putBST(31);
        BinaryTree<Character> binaryTree=new BinaryTree<>(10);
        binaryTree.putBST(11);
        binaryTree.putBST(7);
        binaryTree.putBST(6);
        binaryTree.putBST(8);
        binaryTree.putBST(9);
        binaryTree.preTraverse();
        System.out.println("==================");
        binaryTree.removeBSTNode(16);
        binaryTree.preTraverse();


        System.out.println(binaryTree.height());
    }
}