package club.vann.leetcode;

/**
 * <p>题目：最长公共子序列</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-27 14:31
 **/
public class LeetCode_371 {
    public static void main(String[] args) {
        LeetCode_371 leetCode = new LeetCode_371();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxLong2(TestCase.PARAMS[0], TestCase.PARAMS[1]));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxLong2(TestCase.PARAMS1[0], TestCase.PARAMS1[1]));
    }

    /**
     * 解法一：
     *
     * @param str1
     * @param str2
     * @return
     */
    private int maxLong(String str1, String str2) {
        if(str1 == null || str2 == null || str1.length()==0 || str2.length()==0) {
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
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    /**
     * 解法二：
     * 空间优化
     *
     * @param str1
     * @param str2
     * @return
     */
    private int maxLong1(String str1, String str2) {
        if(str1 == null || str2 == null ||  str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int n = str1.length();
        int m = str2.length();

        int last = 0;
        int[] dp = new int[m+1];
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                int val = dp[j];
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[j] = last + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                last = val;
            }
        }
         return dp[m];
    }

    /**
     * 解法三：
     *
     * @param str1
     * @param str2
     * @return
     */
    private int maxLong2(String str1, String str2) {
        if(str1 == null || str2 == null ||  str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int n = str1.length();
        int m = str2.length();

        int[] dp = new int[m+1];
        for(int i = 1; i <= n; i ++) {
            for(int j = m; j >= 1; j --) {

                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[j] = dp[j-1] + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
            }
        }
        return dp[m];
    }

    static class TestCase {
        public static int ANS = 3;
        public static String[] PARAMS = {"people", "eplm"};

        public static int ANS1 = 3;
        public static String[] PARAMS1 = {"abc", "ahbgdc"};
    }
}
