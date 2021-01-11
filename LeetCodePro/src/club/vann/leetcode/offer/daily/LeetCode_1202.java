package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Meidum</p>
 * <p>题目：交换字符串中的元素</p>
 * <p>描述：给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 *
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 * 通过次数5,602提交次数14,969
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_1202
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/11 9:18
 */
public class LeetCode_1202 {
    public static void main(String[] args) {
        LeetCode_1202 leetCode = new LeetCode_1202();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.smallestStringWithSwaps(TestCase.STR, TestCase.PARIS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.smallestStringWithSwaps(TestCase.STR1, TestCase.PARIS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.smallestStringWithSwaps(TestCase.STR2, TestCase.PARIS2));
    }

    /**
     * 解法一：
     * 并查集解法。
     * @param s
     * @param pairs
     * @return
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(s == null || s.length() == 0) {
            return s;
        }

        char[] ch = s.toCharArray();
        int len = ch.length;

        // 并查集
        int[] parent = new int[len];
        for(int i = 0; i < len; i ++) {
            parent[i] = i;
        }

        for(List<Integer> list : pairs) {
            int x = list.get(0);
            int y = list.get(1);
            union(parent, x, y);
        }

        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();

        for(int i = 0; i < len; i ++) {
            int root = find(parent, i);
            if(map.containsKey(root)) {
                PriorityQueue<Character> queue = map.get(root);
                queue.offer(ch[i]);
            } else {
                PriorityQueue<Character> queue = new PriorityQueue<>();
                queue.offer(ch[i]);
                map.put(root, queue);
            }
        }

        for(int i = 0; i < len; i ++) {
            int root = find(parent, i);
            ch[i] = map.get(root).poll();
        }
        return new String(ch);
    }

    /**
     * 路径压缩， 遍历过程中的所有父节点直接指向根节点，
     * 减少后续查找次数
     * @param parent
     * @param x
     * @return
     */
    private int find(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    /**
     * 合并两个节点。
     *
     * @param parent
     * @param x
     * @param y
     */
    private void union(int[] parent, int x, int y) {
        int parentX = find(parent, x);
        int parentY = find(parent, y);
        parent[parentX] = parentY;
//        parent[find(parent, x)] = find(parent, y);
    }

    static class TestCase {
        public static String ANS = "bacd";
        public static String STR = "dcab";
        public static List<List<Integer>> PARIS = fun(new int[][]{{0,3},{1,2}});

        public static String ANS1 = "bacd";
        public static String STR1 = "dcab";
        public static List<List<Integer>> PARIS1 = fun(new int[][]{{0,3},{1,2},{0,2}});

        public static String ANS2 = "abc";
        public static String STR2 = "cba";
        public static List<List<Integer>> PARIS2 = fun(new int[][]{{0,1},{1,2}});

        private static List<List<Integer>> fun(int[][] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums == null || nums.length == 0) {
                return res;
            }

            for(int[] arr : nums) {
                List<Integer> list = new ArrayList<>();
                for(int i : arr) {
                    list.add(i);
                }
                res.add(list);
            }
            return res;
        }
    }
}
