package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：键值映射</p>
 * <p>描述：实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *  
 *
 * 提示：
 *
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 * 通过次数17,332提交次数27,570
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: fanyu
 * @create: 2021/11/14 09:01
 */
public class LeetCode_677 {
    public static void main(String[] args) {
        LeetCode_677 leetCode = new LeetCode_677();

        MapSum mapSum = leetCode.new MapSum();
        mapSum.insert("apple", 3);
        System.out.println("Result: " + mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println("Result: " + mapSum.sum("ap"));
    }

    class MapSum {
        private Tair tair;
        private Map<String, Integer> map;
        public MapSum() {
            tair = new Tair();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            int delta = val - map.getOrDefault(key, 0);
            map.put(key, val);
            Tair node = tair;
            char[] ch = key.toCharArray();
            for (char c : ch) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new Tair();
                }
                node = node.next[c - 'a'];
                node.sum += delta;
            }
        }

        public int sum(String prefix) {
            Tair node = tair;
            char[] ch = prefix.toCharArray();
            for (char c : ch) {
                if (node.next[c - 'a'] == null) {
                    return 0;
                }
                node = node.next[c - 'a'];
            }
            return node.sum;
        }

        class Tair {
            int sum;
            Tair[] next;
            Tair() {
                sum = 0;
                next = new Tair[26];
            }
        }
    }
}
