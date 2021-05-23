package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>难度：Hard</p>
 * <p>题目：与数组中元素的最大异或值</p>
 * <p>描述：给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 *
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 *
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * 输出：[3,3,7]
 * 解释：
 * 1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 * 示例 2：
 *
 * 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * 输出：[15,-1,5]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length, queries.length <= 105
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 109
 * 通过次数2,802提交次数6,100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-05-23  08:42:30
 */
public class LeetCode_1707 {
    public static void main(String[] args) {
        LeetCode_1707 leetCode = new LeetCode_1707();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.maximizeXor1(TestCase.NUMS, TestCase.QUERIES)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.maximizeXor1(TestCase.NUMS1, TestCase.QUERIES1)));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param queries
     * @return
     */
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;

        int[] ans = new int[n];

        for(int i = 0; i < n; i ++) {
            int[] query = queries[i];
            int max = -1;
            for(int j = 0; j < nums.length; j ++) {
                if(nums[j] <= query[1]) {
                    max = Math.max(max, query[0] ^ nums[j]);
                }

            }
            ans[i] = max;
        }

        return ans;
    }

    /**
     * 解法二：
     *
     * @param nums
     * @param queries
     * @return
     */
    public int[] maximizeXor1(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int numQ = queries.length;
        int[][] newQueries = new int[numQ][3];
        for (int i = 0; i < numQ; ++i) {
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = i;
        }
        Arrays.sort(newQueries, new Comparator<int[]>() {
            public int compare(int[] query1, int[] query2) {
                return query1[1] - query2[1];
            }
        });

        int[] ans = new int[numQ];
        Trie trie = new Trie();
        int idx = 0, n = nums.length;
        for (int[] query : newQueries) {
            int x = query[0], m = query[1], qid = query[2];
            while (idx < n && nums[idx] <= m) {
                trie.insert(nums[idx]);
                ++idx;
            }
            if (idx == 0) { // 字典树为空
                ans[qid] = -1;
            } else {
                ans[qid] = trie.getMaxXor(x);
            }
        }
        return ans;
    }

    class Trie {
        static final int L = 30;
        Trie[] children = new Trie[2];

        public void insert(int val) {
            Trie node = this;
            for(int i = L-1; i >= 0; i --) {
                int bit = (val >> i) & 1;
                if(node.children[bit] == null) {
                    node.children[bit] = new Trie();
                }
                node = node.children[bit];
            }
        }

        public int getMaxXor(int val) {
            int ans = 0;
            Trie node = this;
            for(int i = L-1; i >= 0; i --) {
                int bit = (val >> i) & 1;
                if(node.children[bit^1] != null) {
                    ans |= 1 << i;
                    bit ^= 1;
                }

                node = node.children[bit];
            }
            return ans;
        }
    }

    static class TestCase {
        public static int[] ANS = {3,3,7};
        public static int[] NUMS = {0,1,2,3,4};
        public static int[][] QUERIES = {{3, 1}, {1, 3}, {5, 6}};

        public static int[] ANS1 = {15,-1,5};
        public static int[] NUMS1 = {5,2,4,6,6,3};
        public static int[][] QUERIES1 = {{12, 4}, {8, 1}, {6, 3}};
    }
}
