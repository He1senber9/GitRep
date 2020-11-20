package club.vann.leetcode;

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

        public LRUCache(int capacity) {

        }

        public int get(int key) {
            return 0;
        }

        public void put(int key, int value) {

        }
    }
}
