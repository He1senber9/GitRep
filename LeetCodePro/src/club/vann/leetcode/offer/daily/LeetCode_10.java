package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：正则表达式匹配</p>
 * <p>描述：给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * 通过次数88,922提交次数305,557
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/20
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_10 {
    public static void main(String[] args) {
        LeetCode_10 leetCode = new LeetCode_10();

    }

    private boolean isMatch(String s, String p) {
        return false;
    }

    static class TestCase {
        public static final boolean ans = false;
        public static final String[] strs = {"aa", "a"};

        public static final boolean ans1 = true;
        public static final String[] strs1 = {"aa", "a*"};

        public static final boolean ans2 = true;
        public static final String[] strs2 = {"ab", ".*"};

        public static final boolean ans3 = true;
        public static final String[] strs3 = {"aab", "c*a*b"};

        public static final boolean ans4 = false;
        public static final String[] strs4 = {"mississippi", "mis*is*p*."};
    }
}
