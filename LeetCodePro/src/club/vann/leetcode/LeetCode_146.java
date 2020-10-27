package club.vann.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-10-20 09:20
 **/
public class LeetCode_146 {
    public static void main(String[] args) {

    }

    /**
     * LRU缓存
     */
    class LRUCache {
        int capacity = 0;
        // 数据容器集合
        private LRUDATA<Integer, Integer> dataMap = null;


        /**
         * 初始化缓存容量。
         *
         * @param capacity
         */
        public LRUCache(int capacity) {
            this.capacity = capacity;
            dataMap = new LRUDATA<>();
        }

        public int get(int key) {
            return dataMap.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            dataMap.put(key, value);
        }

        class LRUDATA<K,T> extends LinkedHashMap<Integer, Integer> {

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        }
    }


}
