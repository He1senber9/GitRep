package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：子数组异或查询</p>
 * <p>描述：有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 * 示例 2：
 *
 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * 输出：[8,0,4,4]
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 10^9
 * 1 <= queries.length <= 3 * 10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] < arr.length
 * 通过次数7,719提交次数11,074
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_1310
 * @Description TODO
 * @User fanyu
 * @Date 2021/5/12 8:16
 */
public class LeetCode_1310 {
    public static void main(String[] args) {
        LeetCode_1310 leetCode = new LeetCode_1310();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS) +"] : " + Arrays.toString(leetCode.xorQueries(TestCase.ARR, TestCase.QUERIES)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1) +"] : " + Arrays.toString(leetCode.xorQueries(TestCase.ARR1, TestCase.QUERIES1)));
    }

    /**
     * 解法一：
     *
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int index = 0;
        for(int[] query : queries) {
            int begin = query[0];
            int end = query[1];

            int sum = 0;
            for(int i = begin; i <= end; i ++) {
                sum ^= arr[i];
            }
            ans[index] = sum;
            index ++;
        }
        return ans;
    }



    static class TestCase {
        public static int[] ANS = {2,7,14,8};
        public static int[] ARR = {1,3,4,8};
        public static int[][] QUERIES = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};

        public static int[] ANS1 = {8,0,4,4};
        public static int[] ARR1 = {4,8,2,10};
        public static int[][] QUERIES1 = {{2, 3}, {1, 3}, {0, 0}, {0, 3}};
    }
}
