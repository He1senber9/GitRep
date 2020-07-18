package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：交错字符串</p>
 * <p>描述：给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * 通过次数19,842提交次数46,894
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/18
 * Time: 11:04
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_97 {
    public static void main(String[] args) {
        LeetCode_97 leetCode = new LeetCode_97();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.isInterleave(TestCase.PARAMS[0],TestCase.PARAMS[1],TestCase.PARAMS[2]));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.isInterleave(TestCase.PARAMS1[0],TestCase.PARAMS1[1],TestCase.PARAMS1[2]));
    }

    /**
     * 解法一：
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len = s3.length();
        if(len1+len2 != len) {
            return false;
        }

        // 动态规划
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int i = 0; i <= len1; i ++) {
            for(int j = 0; j <= len2; j ++) {
                if(i>0) {
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
                if(j>0) {
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                }
            }
        }

        return dp[len1][len2];
    }

    static class TestCase {
        public static boolean ANS = true;
        public static String[] PARAMS = {"aabcc",  "dbbca", "aadbbcbcac"};

        public static boolean ANS1 = false;
        public static String[] PARAMS1 = {"aabcc",  "dbbca", "aadbbbaccc"};
    }
}
