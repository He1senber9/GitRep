package club.vann.leetcode.offer.daily;

import java.util.Scanner;

/**
 * <p>难度：Medium</p>
 * <p>题目：零钱兑换II</p>
 * <p>描述：给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *  
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 * 通过次数60,545提交次数101,089
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-10  08:14:29
 */
public class LeetCode_518 {
    public static void main(String[] args) {
        LeetCode_518 leetCode = new LeetCode_518();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.change(TestCase.AMOUNT, TestCase.COINS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.change(TestCase.AMOUNT1, TestCase.COINS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.change(TestCase.AMOUNT2, TestCase.COINS2));
    }

    /**
     * 解法一：
     * dp[i][j] 表示使用前 i 中硬币，能凑成金额 j 的方式数量。则答案为 dp[conins.length][amount]
     * dp[i][0] = 1;
     *
     * 当第 i 个硬币可以选择的条件是：
     *  j 是 conins[i] 的倍数.
     *  dp[i][j] = dp[i-1][j] + 1;
     *  否则：
     *  dp[i][j] = dp[i-1][j];
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;

        // dp[i][j] 表示 使用前 i 个硬币，凑成 金额 j 的组合数
        /*
           dp[0][j] = 0;
           如果可以选择第 i 个硬币：
                dp[i][j] = dp[i-1][j] + dp[i-1][j-coins[i]]
           如果不能选择第 i 个硬币：
                dp[i][j] = dp[i-1][j]
         */
        int[][] dp = new int[n+1][amount+1];

        //初始化基本状态
        for (int k = 0; k <= n; k++){
            dp[k][0] = 1;
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= amount; j ++) {
                if(j >= coins[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

    static class TestCase {
        public static int ANS = 4;
        public static int AMOUNT = 5;
        public static int[] COINS = {1, 2, 5};

        public static int ANS1 = 0;
        public static int AMOUNT1 = 3;
        public static int[] COINS1 = {2};

        public static int ANS2 = 1;
        public static int AMOUNT2 = 10;
        public static int[] COINS2 = {10};
    }
}
