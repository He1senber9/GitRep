package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>通配符匹配</p>
 * <p>描述：给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 * 通过次数33,853提交次数119,486
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/5
 * Time: 7:36
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_44 {
    public static void main(String[] args) {
        LeetCode_44 leetCode = new LeetCode_44();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.isMatch(TestCase.PARAMS[0], TestCase.PARAMS[1]));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.isMatch(TestCase.PARAMS1[0], TestCase.PARAMS1[1]));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.isMatch(TestCase.PARAMS2[0], TestCase.PARAMS2[1]));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.isMatch(TestCase.PARAMS3[0], TestCase.PARAMS3[1]));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.isMatch(TestCase.PARAMS4[0], TestCase.PARAMS4[1]));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.isMatch(TestCase.PARAMS5[0], TestCase.PARAMS5[1]));
        System.out.println("Result["+TestCase.ANS6+"] : " + leetCode.isMatch(TestCase.PARAMS6[0], TestCase.PARAMS6[1]));
    }

    /**
     * 解法一：
     * 暴力解法
     * @param s
     * @param p
     * @return
     */
    private boolean isMatch(String s, String p) {
        if((s==null || s.length()==0) && (p==null || p.length()==0)) {
            return true;
        }
        
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    static class TestCase {
        public static final boolean ANS = false;
        public static final String[] PARAMS = {"aa", "a"};

        public static final boolean ANS1 = true;
        public static final String[] PARAMS1 = {"aa", "*"};

        public static final boolean ANS2 = false;
        public static final String[] PARAMS2 = {"cb", "?a"};

        public static final boolean ANS3 = true;
        public static final String[] PARAMS3 = {"adceb", "*a*b"};

        public static final boolean ANS4 = false;
        public static final String[] PARAMS4 = {"acdcb", "a*c?b"};

        public static final boolean ANS5 = true;
        public static final String[] PARAMS5 = {"abceb", "*a*b"};

        public static final boolean ANS6 = true;
        public static final String[] PARAMS6 = {"", "*"};
    }
}
