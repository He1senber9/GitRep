package club.vann.leetcode;

import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：LRU缓存</p>
 * <p>描述：设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 示例:
 *
 </p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-19 16:12
 **/
public class LeetCode_16_25 {
    public static void main(String[] args) {
        LeetCode_16_25 leetCode = new LeetCode_16_25();

        System.out.println("Result[");
    }

    class LRUCache {

        private Map<Integer, LRULinkedNode> indexMap = null; //
        private LRULinkedNode head, tail; // 顺序存放KV对
        private int size;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;

            // 伪头部，伪末尾节点 在添加或者删除节点时就不需要判断相邻节点是否存在了
            head = new LRULinkedNode();
            tail = new LRULinkedNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if(!indexMap.containsKey(key)) {
                return -1;
            }

            LRULinkedNode node = indexMap.get(key);
            // 将需要获取的节点移动到双向列表的头部
            moveToHead(node);

            return node.val;
        }

        public void put(int key, int value) {
            if(indexMap.containsKey(key)) {
                LRULinkedNode node = indexMap.get(key);
                node.val = value;
                moveToHead(indexMap.get(key));
            } else {
                LRULinkedNode node = new LRULinkedNode(key, value);
                indexMap.put(key, node);

                LRULinkedNode next = head.next;
                head.next = node;
                node.next = next;
                next.pre = node;
                node.pre = head;
                ++size;

                // 超出容量，需要删除尾节点
                if(size > capacity) {
                    LRULinkedNode pre = tail.pre.pre;
                }
            }
        }

        /**
         * 移动到头节点
         * @param node
         */
        private void moveToHead(LRULinkedNode node) {

        }

        /**
         * 删除尾节点
         */
        private void removeTail() {

        }

        class LRULinkedNode {
            int key;
            int val;
            LRULinkedNode pre;
            LRULinkedNode next;

            LRULinkedNode() {}
            LRULinkedNode(int key, int value) {
                this.key = key;
                this.val = value;
            }
        }
    }
}
