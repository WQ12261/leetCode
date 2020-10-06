package tree;

import java.util.*;

/**
 *@className HuffmanTree 霍夫曼树
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/5 11:36
 *@version
 */
public class HuffmanTree {
    private int[] arr;

    private Node root;

    public HuffmanTree(int[] arr){
        this.arr=arr;
        Arrays.sort(arr);
        this.root=createHuffmanTree(arr);
    }
    public static Node createHuffmanTree(int [] arr){
        List<Node> list=new ArrayList<>();
        for (int n:arr){
            Node node=new Node(n);
            list.add(node);
        }
        while (list.size()>1){
            Node one = list.remove(0);
            Node tow = list.remove(0);
            int value=one.value+tow.value;
            Node node=new Node(value);
            node.rightNode=one;
            node.leftNode=tow;
            list.add(node);
            Collections.sort(list, (a,b)->{
                return a.value-b.value;
            });
        }
       return list.get(0);
    }
    public void preSearch(){
        if (this.root!=null){
            root.preSearch();
        }
    }

    private static class Node{
        int value;
        Node leftNode;
        Node rightNode;
        Node(int value){
            this.value=value;
        }

        void preSearch(){
            System.out.println(value);
            if (leftNode!=null){
                leftNode.preSearch();
            }
            if (rightNode!=null){
                rightNode.preSearch();
            }
        }

    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        HuffmanTree huffmanTree=new HuffmanTree(arr);
        huffmanTree.preSearch();
    }
}
