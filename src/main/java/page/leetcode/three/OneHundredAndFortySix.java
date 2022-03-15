package page.leetcode.three;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneHundredAndFortySix {
    private static class LRUCache {

        private final  int capacity ;
        Map<Integer, LRUNode> map = new HashMap<>();
        private LRUNode head;
        private LRUNode last;
        private int size;
        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            LRUNode lruNode = map.get(key);
            if (lruNode == null){
                return -1;
            }
            if (head != lruNode){
                remove(lruNode);
                toHead(lruNode);
            }
            return lruNode.value;
        }

        public void put(int key, int value) {
            LRUNode lruNode = map.get(key);
            if (lruNode != null){
                lruNode.value = value;
                if (lruNode == head){
                    return;
                }
                remove(lruNode);
                size --;
            }
            lruNode = new LRUNode(key, value);
            map.put(key, lruNode);
            toHead(lruNode);
            size ++;
            if (size > capacity){
                LRUNode pre = last.pre;
                map.remove(last.key);
                remove(last);
                size --;
                if (pre == null){
                    last = head;
                }else {
                    last = pre;
                }
            }
        }

        private void remove(LRUNode lruNode){
            LRUNode lruPre = lruNode.pre;
            LRUNode lruNext = lruNode.next;
            lruPre.next = lruNext;
            if (lruNext != null){
                lruNext.pre = lruPre;
            }else {
                last = lruPre;
            }
            lruNode.pre = null;
            lruNode.next = null;
        }

        private void toHead(LRUNode lruNode){
            if (lruNode == head){
                return;
            }

            lruNode.pre = null;
            lruNode.next = head;
            if (head != null){
                head.pre = lruNode;
            }
            head = lruNode;
            if (last == null){
                last = head;
            }
        }
        private static class LRUNode {
            int value;
            int key;
            LRUNode pre;
            LRUNode next;

            public LRUNode(int key,int value ){
                this.value = value;
                this.key = key;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2,3);
        lruCache.put(4, 1);
        lruCache.get(1);
        lruCache.get(2);
        System.out.println("hello");
    }
}
