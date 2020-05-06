package club.vann.leetcode.common;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>LRU缓存工具</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/29
 * Time: 10:34
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LRUHashMapCache<K, V> implements Cache<K, V> {
    /** 缓存集合限量 */
    private volatile int capacity;

    /** 缓存数据存储 */
    private Map<K,Node> cacheMap;

    /** 链表头节点 */
    private Node first;
    /** 链表尾节点 */
    private Node last;

    public LRUHashMapCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<K, Node>();
    }

    /**
     * 向缓存中添加元素：
     * 如果是新元素：需要判断当前集合是否超过限量，如果超过，则要先删除链表中的最后一个元素，再新增新元素到链表头
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {
        Node node = cacheMap.get(key);
        // 新元素
        if(node == null) {
            if(cacheMap.size() >= this.capacity) {
                // 删除尾节点元素
                this.removeLast();
            }
            node = new Node(key, value);
        }

        cacheMap.put(key, node);
        // 移动到头
        this.moveToFirst(node);
    }

    @Override
    public V get(K key) {
        Node node = cacheMap.get(key);
        if(node == null) {
            return null;
        }

        this.moveToFirst(node);
        return (V) node.getV();
    }

    @Override
    public V remove(K key) {
        Node node = cacheMap.get(key);
        if(node != null) {
            if(node.pre != null) {
                node.pre.next = node.next;
            }

            if(node.next != null) {
                node.next.pre = node.pre;
            }

            if(node == first) {
                first = node.next;
            }

            if(node == last) {
                last = node.pre;
            }
        }

        return (V) cacheMap.remove(key);
    }

    /**
     * 自定义双向链表
     * @param <K>
     * @param <V>
     */
    class Node<K, V> {
        private K k;
        private V v;
        private Node pre;
        private Node next;

        Node(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public V getV() {
            return this.v;
        }
    }

    /**
     * 删除链表中的最后一个元素
     */
    private void removeLast() {
        if(this.last == null) {
            return;
        }

        if(this.last.pre != null) {
            this.last = this.last.pre;
            this.last.next = null;
        } else {
            this.last.next = null;
            this.last = null;
        }

    }

    /**
     * 将指定元素移动的链表头
     * @param node
     */
    private void moveToFirst(Node node) {
        if(node == this.first) {
            return;
        }

        if(node.next != null) {
            node.next.pre = node.pre;
        }

        if(node.pre != null) {
            node.pre.next = node.next;
        }

        if(first == null || last == null) {
            first = last = node;
            return;
        }

        node.next = first;
        node.pre = null;
        first.pre = node;
        first = node;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node node = first;
        while(node != null) {
            builder.append(node.getV() + ", ");
            node = node.next;
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        LRUHashMapCache<Integer, Integer> lruCache = new LRUHashMapCache<Integer, Integer>(5);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        System.out.println("初始链表：" + lruCache.toString());

        lruCache.get(4);
        System.out.println("链表：" + lruCache.toString());

        lruCache.put(6, 6);
        System.out.println("链表：" + lruCache.toString());

        lruCache.remove(3);
        System.out.println("链表：" + lruCache.toString());
    }
}
