package club.vann.leetcode.offer.daily;

import java.lang.instrument.ClassFileTransformer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <p>难度：Hard</p>
 * <p>题目：LFU缓存</p>
 * <p>描述：设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 *
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 * 示例：
 *
 * LFUCache cache = new LFUCache(2);
 *
 * cache.put(1,1);
 *cache.put(2,2);
 *cache.get(1);       // 返回 1
 *cache.put(3,3);    // 去除 key 2
 *cache.get(2);       // 返回 -1 (未找到key 2)
 *cache.get(3);       // 返回 3
 *cache.put(4,4);    // 去除 key 1
 *cache.get(1);       // 返回 -1 (未找到 key 1)
 *cache.get(3);       // 返回 3
 *cache.get(4);       // 返回 4
 *通过次数3,645提交次数10,235
 *
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/lfu-cache
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/5
 * Time: 9:41
 * Description:
 */
public class LeetCode_460 {
    public static void main(String[] args) {
        LeetCode_460 leetCode = new LeetCode_460();

        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println("Result[1] : " + lfuCache.get(1));
        lfuCache.put(3, 3); // 覆盖掉 2
        System.out.println("Result[-1] : " + lfuCache.get(2));
        System.out.println("Result[3] : " + lfuCache.get(3));
        lfuCache.put(4, 4); // 覆盖 1
        System.out.println("Result[-1] : " + lfuCache.get(1));
        System.out.println("Result[3] : " + lfuCache.get(3));
        System.out.println("Result[4] : " + lfuCache.get(4));

        LFUCache lfuCache1 = new LFUCache(3);
        lfuCache1.put(2, 2);
        lfuCache1.put(1, 1);
        System.out.println("Result[2] : " + lfuCache1.get(2));
        System.out.println("Result[1] : " + lfuCache1.get(1));
        System.out.println("Result[2] : " + lfuCache1.get(2));
        lfuCache1.put(3, 3);
        lfuCache1.put(4, 4);
        System.out.println("Result[-1] : " + lfuCache1.get(3));
        System.out.println("Result[2] : " + lfuCache1.get(2));
        System.out.println("Result[1] : " + lfuCache1.get(1));
        System.out.println("Result[4] : " + lfuCache1.get(4));

        LFUCache lfuCache2 = new LFUCache(0);
        lfuCache2.put(0, 0);
        System.out.println("Result[-1] : " + lfuCache2.get(0));

        LFUCache lfuCache3 = new LFUCache(3);
        lfuCache3.put(1,1);
        lfuCache3.put(2,2);
        lfuCache3.put(3,3);
        lfuCache3.put(4,4);
        System.out.println("Result[4] : " + lfuCache3.get(4));
        System.out.println("Result[3] : " + lfuCache3.get(3));
        System.out.println("Result[2] : " + lfuCache3.get(2));
        System.out.println("Result[-1] : " + lfuCache3.get(1));
        lfuCache3.put(5,5);
        System.out.println("Result[-1] : " + lfuCache3.get(1));
        System.out.println("Result[2] : " + lfuCache3.get(2));
        System.out.println("Result[3] : " + lfuCache3.get(3));
        System.out.println("Result[-1] : " + lfuCache3.get(4));
        System.out.println("Result[5] : " + lfuCache3.get(5));

    }
}

class LFUCache {

    private final int count;
    private Map<Integer, Integer> dataMap = null; // 数据集合
    private Map<Integer, Integer> ageMap = null; // 数据年龄集合
    private LinkedList<Integer> list = null;

    public LFUCache(int capacity) {
        count = capacity;
        dataMap = new HashMap<Integer, Integer>();
        ageMap = new HashMap<Integer, Integer>();
        list = new LinkedList<Integer>();
    }

    public int get(int key) {
        if(dataMap.containsKey(key)) {
            // 年龄加一
            ageMap.put(key, ageMap.get(key) + 1);
            insert(key, ageMap.get(key)+1);
            return dataMap.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(dataMap.size() < count) {
            dataMap.put(key, value);
            ageMap.put(key, 0); // 针对新加入的元素，年龄都统一为0
            insert(key, 0);
        } else {
            // 去除年龄最小的元素，或者是相同年龄但是最近没有使用的元素
            int k =list.pollFirst();
            dataMap.remove(k);
            ageMap.remove(k);

            dataMap.put(key, value);
            ageMap.put(key, 0);
            insert(key, 0);
            list.offerLast(key);
        }
    }

    private void insert(int key, int age) {
        if(list.size() == 0) {
            list.add(age);
        }

        for(int n = 0; n < list.size(); n ++) {
            if(list.get(n) > age) {
                list.add(age, n-1);
                break;
            }
        }

        if(!list.contains(key)) {
            list.add(age);
        }
    }
}
