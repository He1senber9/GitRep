package club.vann.leetcode;

/**
 * <p>题目：最长公共子串</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-27 14:22
 **/
public class LeetCode_370 {
    public static void main(String[] args) {
        LeetCode_370 leetCode = new LeetCode_370();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxLong1(TestCase.PARAMS[0], TestCase.PARAMS[1]));
    }

    /**
     * 解法一：
     *
     * @param str1
     * @param str2
     * @return
     */
    private int maxLong(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        int n = str1.length();
        int m = str2.length();

        int max = 0;
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    /**
     * 解法二：
     * 空间优化
     * @param str1
     * @param str2
     * @return
     */
    private int maxLong1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        int n = str1.length();
        int m = str2.length();

        int max = 0;
        int[] dp = new int[m+1];
        for(int i = 1; i <= n; i ++) {
            for(int j = m; j >= 1; j --) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[j] = dp[j-1] + 1;
                } else {
                    dp[j] = 0;
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }

    static class TestCase {
        public static int ANS = 2;
        public static String[] PARAMS = {"people", "eplm"};
    }
}
