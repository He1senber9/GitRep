package club.vann.leetcode.offer.daily;

import java.util.Stack;

/**
 * <p>难度：Hard</p>
 * <p>题目：最长有效括号</p>
 * <p>描述：给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 通过次数67,423提交次数215,996
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/4
 * Time: 8:54
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_32 {
    public static void main(String[] args) {
        LeetCode_32 leetCode = new LeetCode_32();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.longestValidParentheses(TestCase.STR));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.longestValidParentheses(TestCase.STR1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.longestValidParentheses(TestCase.STR2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.longestValidParentheses(TestCase.STR3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.longestValidParentheses(TestCase.STR4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.longestValidParentheses(TestCase.STR5));
        System.out.println("Result["+TestCase.ANS6+"] : " + leetCode.longestValidParentheses(TestCase.STR6));
        System.out.println("Result["+TestCase.ANS7+"] : " + leetCode.longestValidParentheses(TestCase.STR7));
        System.out.println("Result["+TestCase.ANS8+"] : " + leetCode.longestValidParentheses(TestCase.STR8));
        System.out.println("Result["+TestCase.ANS9+"] : " + leetCode.longestValidParentheses(TestCase.STR9));
        System.out.println("Result["+TestCase.ANS10+"] : " + leetCode.longestValidParentheses(TestCase.STR10));
        System.out.println("Result["+TestCase.ANS11+"] : " + leetCode.longestValidParentheses(TestCase.STR11));
        System.out.println("Result["+TestCase.ANS12+"] : " + leetCode.longestValidParentheses(TestCase.STR12));
        System.out.println("Result["+TestCase.ANS13+"] : " + leetCode.longestValidParentheses(TestCase.STR13));
    }

    /**
     * 解法一：
     * 暴力破解，判读子串是否为有效括号串
     * @param s
     * @return
     */
    private int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();

        // 如果是有效括号字符串，则长度一定是偶数
        int size = len%2 == 0 ? len : len-1;
        for(int newSize = size; newSize >= 2; newSize -= 2) {
            for(int n = 0; n+newSize-1 < len; n ++) {
                if(isValid(s.substring(n, n+newSize))) {
                    return newSize;
                }
            }
        }

        return 0;
    }

    /**
     * 判断一个字符串是否为有效字符串
     * 借助栈
     * @param subStr
     * @return
     */
    private boolean isValid(String subStr) {
        Stack<Character> stack = new Stack<>();
        int len = subStr.length();
        for(int n = 0; n < len; n ++) {
            if(subStr.charAt(n) == '(') {
                stack.push(subStr.charAt(n));
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }

    static class TestCase{
        public static final int ANS = 2;
        public static final String STR = "(()";

        public static final int ANS1 = 4;
        public static final String STR1 = ")()())";

        public static final int ANS2 = 6;
        public static final String STR2 = "((()))";

        public static final int ANS3 = 6;
        public static final String STR3 = "((())))";

        public static final int ANS4 = 6;
        public static final String STR4 = "(((()))";

        public static final int ANS5 = 10;
        public static final String STR5 = "(((()))()()";

        public static final int ANS6 = 10;
        public static final String STR6 = "(((()))()()";

        public static final int ANS7 = 8;
        public static final String STR7 = "()()()(()()()()";

        public static final int ANS8 = 10;
        public static final String STR8 = "()()()((()()()())";

        public static final int ANS9 = 16;
        public static final String STR9 = "()()()(()()()())";

        public static final int ANS10 = 16;
        public static final String STR10 = "()()()(()()()()))";

        public static final int ANS11 = 10;
        public static final String STR11 = "((()(())))";

        public static final int ANS12 = 8;
        public static final String STR12 = "()()(()()()()(()()()";

        public static final int ANS13 = 6;
        public static final String STR13 = "(((()))";

        public static final int ANS14 = 0;
        public static final String STR14 = ")))(((";
    }
}
