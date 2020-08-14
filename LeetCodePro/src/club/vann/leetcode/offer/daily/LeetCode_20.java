package club.vann.leetcode.offer.daily;

import java.util.Stack;

/**
 * <p>难度：Easy</p>
 * <p>题目：有效的括号</p>
 * <p>描述：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 * 通过次数370,523提交次数869,958
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-08-14 15:49
 **/
public class LeetCode_20 {
    public static void main(String[] args) {
        LeetCode_20 leetCode = new LeetCode_20();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.isValid(TestCase.STR));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.isValid(TestCase.STR1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.isValid(TestCase.STR2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.isValid(TestCase.STR3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.isValid(TestCase.STR4));
    }

    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        char[] ch = s.toCharArray();
        int len = ch.length;

        if(len%2 != 0) {
            return false;
        }

        // 借助栈思想
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < len; i ++) {
            if(!stack.isEmpty() && isFormat(stack.peek(), ch[i])) {
                stack.pop();
            } else {
                stack.push(ch[i]);
            }

        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isFormat(char s1, char s2) {
        if((s1 == '(' && s2 == ')') || (s1 == '{' && s2 == '}') || (s1 == '[' && s2 == ']')) {
            return true;
        } else {
            return false;
        }
    }

    static class TestCase {
        public static boolean ANS = true;
        public static String STR = "()";

        public static boolean ANS1 = true;
        public static String STR1 = "()[]{}";

        public static boolean ANS2 = false;
        public static String STR2 = "(]";

        public static boolean ANS3 = false;
        public static String STR3 = "([)]";

        public static boolean ANS4 = true;
        public static String STR4 = "{[]}";
    }
}
