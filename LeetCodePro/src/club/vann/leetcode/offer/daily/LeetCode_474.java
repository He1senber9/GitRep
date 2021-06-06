package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：一和零</p>
 * <p>描述：给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *  
 *
 * 提示：
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * 通过次数43,753提交次数76,494
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-06  08:51:10
 */
public class LeetCode_474 {
    public static void main(String[] args) {
        LeetCode_474 leetCode = new LeetCode_474();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.findMaxForm(TestCase.STRS, TestCase.M, TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.findMaxForm(TestCase.STRS1, TestCase.M1, TestCase.N1));
    }

    /**
     * 解法一：
     * 令：dp[i][j][k] 为前 i 个字符串中 使用 j 个 1，k 个 0 最多可以得到的的字符串数量。
     *
     * 当 i = 0 时，dp[0][i][j] = 0;
     * 当 i > 0 时：
     *    第 i 个字符串中有 x 个 1， y 个 0：
     *    当 x > j 或者 y > k 时， 第 i 个字符串不能选，则 dp[i][j][k] = dp[i-1][j][k]
     *    当 x <= j && y <= k 时，
     *          如果不选第 i 个字符串，则 dp[i][j][k] = dp[i-1][j][k]
     *          如果选择第 i 个字符串，则 dp[i][j][k] = dp[i-1][j-x][k-y] + 1
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;

        int[][][] dp = new int[size+1][n+1][m+1];

        for(int i = 1; i <= size; i ++) {
            // 计算第 i 个字符串中 1 和 0 的数量
            String str = strs[i-1];
            int count1 = sizeStr(str);
            int count0 = str.length() - count1;
            for(int j = 0; j <= n; j ++) {
                for(int k = 0; k <= m; k ++) {
                    dp[i][j][k] = dp[i-1][j][k];
                    if(count1 <= j && count0 <= k) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-count1][k-count0] + 1);
                    }
                }
            }
        }
        return dp[size][n][m];
    }

    private int sizeStr(String str) {
        char[] ch = str.toCharArray();
        int count = 0;
        for(int i = 0; i < ch.length; i ++) {
            if(ch[i] == '1') {
                count ++;
            }
        }
        return count;
    }

    static class TestCase {
        public static int ANS = 4;
        public static String[] STRS = {"10", "0001", "111001", "1", "0"};
        public static int M = 5;
        public static int N = 3;

        public static int ANS1 = 2;
        public static String[] STRS1 = {"10", "0", "1"};
        public static int M1 = 1;
        public static int N1 = 1;
    }
}
