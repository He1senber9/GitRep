package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：完全平方数</p>
 * <p>描述：给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *  
 * 提示：
 *
 * 1 <= n <= 104
 * 通过次数144,468提交次数237,313
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-11  07:43:02
 */
public class LeetCode_279 {
    public static void main(String[] args) {
        LeetCode_279 leetCode = new LeetCode_279();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.numSquares1(TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.numSquares1(TestCase.N1));
    }

    /**
     * 解法一：
     * dp[i][j] 表示从前 i 个元素中选取他们的平方和能组成 j 的最少个数。
     * dp[0][0] = 0;
     * @param n
     * @return
     */
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int id = 1;
        while(id*id <= n) {
            list.add(id * id);
            id ++;
        }

        int len = list.size();
        int[][] dp = new int[len+1][n+1];

//        for(int i = 1; i <= len; i ++) {
//            dp[i][0] = -1;
//        }

//        for(int j = 1; j <= n; j ++) {
//            dp[0][j] = j;
//        }

        for(int i = 1; i <= len; i ++) {
            int val = list.get(i-1);
            for(int j = 0; j <= n; j ++) {
                dp[0][j] = j;
                dp[i][j] = dp[i-1][j];
                for(int k = 1; k*val <= j; k ++) {
//                    if(dp[i-1][j-k*val] != -1) {
//
//                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-k*val] + k);
                }
            }
        }
        return dp[len][n];
    }

    /**
     * 解法二：
     * dp[i]代表考虑到当前物品为止，凑出 j 所使用到的最小元素个数
     * @param n
     * @return
     */
    public int numSquares1(int n) {
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i ++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j ++) {
                min = Math.min(min, dp[i-j*j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    static class TestCase {
        public static int ANS = 3;
        public static int N = 12;

        public static int ANS1 = 2;
        public static int N1 = 13;
    }
}
