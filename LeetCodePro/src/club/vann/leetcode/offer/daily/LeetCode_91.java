package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：解码方法</p>
 * <p>描述：一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 *
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 *
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 * 通过次数98,047提交次数370,724
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_91
 * @Description TODO
 * @User fanyu
 * @Date 2021/4/21 8:26
 */
public class LeetCode_91 {
    public static void main(String[] args) {
        LeetCode_91 leetCode = new LeetCode_91();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.numDecodings2(TestCase.STR));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.numDecodings2(TestCase.STR1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.numDecodings2(TestCase.STR2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.numDecodings2(TestCase.STR3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.numDecodings2(TestCase.STR4));
    }

    /**
     * 解法一：
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        List<String> path = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        doParse(ans, path, s, 0);
        return ans.size();
    }

    private void doParse(List<Integer> ans, List<String> path, String str, int index) {
        if(index >= str.length()) {
            ans.add(1);
            return;
        }

        for(int i = index; i < str.length(); i ++) {
            if(i - index + 1 > 3) {
                continue;
            }
            char c = str.charAt(index);
            if(c == '0') {
                break;
            }

            String subString = str.substring(index, i+1);
            if(Integer.parseInt(subString) > 26) {
                continue;
            }
            path.add(subString);
            doParse(ans, path, str, i+1);
            path.remove(path.size()-1);
        }
    }

    /**
     * 解法二：
     *
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i = 1; i <= n; i ++) {
            if(s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }

            if(i > 1 && s.charAt(i-2) != '0' && ((s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0') <= 26)) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }

    /**
     * 解法三：
     *
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        int n = s.length();
        int left = 0, right = 1;
        int ans = 0;

        for(int i = 1; i <= n; i ++) {
            ans = 0;
            if(s.charAt(i-1) != '0') {
                ans += right;
            }

            if(i > 1 && s.charAt(i-2) != '0' && ((s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0') <= 26)) {
                ans += left;
            }
            left = right;
            right = ans;
        }

        return ans;
    }

    static class TestCase {
        public static int ANS = 2;
        public static String STR = "12";

        public static int ANS1 = 3;
        public static String STR1 = "226";

        public static int ANS2 = 0;
        public static String STR2 = "0";

        public static int ANS3 = 0;
        public static String STR3 = "06";

        public static int ANS4 = 1;
        public static String STR4 = "27";
    }
}
