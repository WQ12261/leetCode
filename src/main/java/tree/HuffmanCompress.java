package tree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.*;

/**
 *@className HuffmanCompress
 *@description
 *@author 1226134406@qq.com
 *@time 2020/10/5 20:36
 *@version
 */
public class HuffmanCompress<E> {
    private Node<E> root;
    public static Map<Byte,Integer> getByte(String str){
        Map<Byte,Integer> map=new HashMap<>();
        byte[] bytes = str.getBytes();
        for (Byte b:bytes){
            Integer integer = map.get(b);
            if (integer==null){
                integer=1;
            }else {
                integer+=1;
            }
            map.put(b,integer);
        }
        return map;
    }
    public  Node<E> createHuffmanTree(Map<E,Integer> map){
        Set<Map.Entry<E, Integer>> entries =map.entrySet();
        Iterator<Map.Entry<E, Integer>> iterator = entries.iterator();
        List<Node<E>> list=new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<E, Integer> entry = iterator.next();
            Node<E> node=new Node<>(entry.getKey(), entry.getValue());
            list.add(node);
        }
        Collections.sort(list, Comparator.comparingInt(a -> a.value));

        while (list.size()>1){
            Node<E> one = list.remove(0);
            Node<E> tow = list.remove(0);
            Node<E> node=new Node<>(one.value+tow.value);
            node.rightNode=tow;
            node.leftNode=one;
            list.add(node);
            Collections.sort(list, Comparator.comparingInt(a -> a.value));
        }
        return list.get(0);
    }

    public Map<E,String> getCode(Node<E> node){
        Map<E,String> map=new HashMap<>();
        node.createCode("", map);
        return map;
    }
    

    private static class Node<T>{
        T t;
        int value;
        Node<T> leftNode;
        Node<T> rightNode;
        Node(T t, int value){
            this.t=t;
            this.value=value;
        }
        Node(int value){
            this.value=value;
        }

        void createCode(String str,Map<T,String> map){
            if (leftNode==null&&rightNode==null){
                map.put(t, str);
            }
            if (leftNode!=null){
                leftNode.createCode(str+1,map);
            }
            if (rightNode!=null){
                rightNode.createCode(str+0,map);
            }

        }
    }

    public static void main(String[] args) {
        String str="i like like like java do you like a java";
        Map<Character,Integer> map=new HashMap<>();
        char[] chars = str.toCharArray();
        for(char c:chars){
            Integer integer = map.get(c);
            if (integer!=null){
                integer+=1;
            }else {
                integer=1;
            }
            map.put(c, integer);
        }
        HuffmanCompress<Character> compress=new HuffmanCompress<>();
        Node<Character> huffmanTree = compress.createHuffmanTree(map);
        Map<Character, String> code = compress.getCode(huffmanTree);
        System.out.println(code);
    }
}
