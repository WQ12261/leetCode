package LRU;


import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;

public class LRU<K,T> {


    private final LinkList<T> linkList;

    private final Map<K,Node<T>> map;

    public LRU(int capacity){
        linkList = new LinkList<T>(capacity);
        map = new HashMap<>();
    }

    public void put(K key,T value){
        Node<T> node = map.get(key);
        if (node == null){
            node = new Node<T>(value);
            map.put(key, node);
            linkList.putNode(node);
        }else {
            node.t = value;
        }

    }

    public T get(K key){
        Node<T> node = map.get(key);
        if (node == null){
            return null;
        }else {
            node.hotValue += 1;
            linkList.getNode(node);
            return node.t;
        }
    }



    private final static class Node<T>{
        private Node<T> pre;

        private Node<T> next;

        private int hotValue;

        private T t;

        public Node(T t){
            this.t = t;
        }
    }

    private final static class  LinkList<T> {
        private Node<T> head;

        private Node<T> tail;

        private int size;

        private final int capacity;

        public LinkList(int capacity){
            if (capacity <= 0){
                throw new IllegalArgumentException();
            }
            this.capacity = capacity;
        }

        public void putNode(Node<T> node){
            if (capacity == 1 || head == null){
                head = node;
                tail = node;
                size = 1;
                return;
            }
            if (capacity == size){
                Node<T> preNode = tail.next;
                preNode.next = node;
                node.pre = preNode;
            }else {
                tail.next = node;
                node.pre = tail;
                size ++;
            }
            tail = node;
        }

        public void getNode(Node<T> node){
            if (capacity == 1){
                return;
            }
            while (node.pre != null){
                Node<T> preNode = node.pre;
                Node<T> nextNode = node.next;
                if (node.hotValue < preNode.hotValue){
                    break;
                }
                node.pre = preNode.pre;
                node.next = preNode;
                if (preNode == head){
                    head = node;
                }else if (tail == node){
                    tail = preNode;
                }
                preNode.next = nextNode;
                preNode.pre = node;
                if (nextNode != null){
                    nextNode.pre = preNode;
                }
            }
        }

    }
}
