package club.vann.leetcode.offer.daily;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <p>难度：Medium</p>
 * <p>题目：反转每对括号间的子串</p>
 * <p>描述：给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 *
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 * 通过次数14,735提交次数24,411
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-05-26  08:02:39
 */
public class LeetCode_1190 {
    public static void main(String[] args) {
        LeetCode_1190 leetCode = new LeetCode_1190();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.reverseParentheses(TestCase.S));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.reverseParentheses(TestCase.S1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.reverseParentheses(TestCase.S2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.reverseParentheses(TestCase.S3));
    }

    public String reverseParentheses(String s) {
        Stack<Character> dataStack = new Stack<>();
        LinkedList<Character> list = new LinkedList<>();

        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i ++) {
            if(ch[i] == ')') {
                while(!dataStack.isEmpty() && dataStack.peek() != '(') {
                    list.addLast(dataStack.pop());
                }
                dataStack.pop();

                while(!list.isEmpty()) {
                    dataStack.push(list.pollFirst());
                }
            } else {
                dataStack.push(ch[i]);
            }
        }

        char[] newChar = new char[dataStack.size()];
        int index = newChar.length-1;
        while(!dataStack.isEmpty()) {
            newChar[index] = dataStack.pop();
            index --;
        }

        return new String(newChar);
    }

    static class TestCase {
        public static String ANS = "dcba";
        public static String S = "(abcd)";

        public static String ANS1 = "iloveu";
        public static String S1 = "(u(love)i)";

        public static String ANS2 = "leetcode";
        public static String S2 = "(ed(et(oc))el)";

        public static String ANS3 = "apmnolkjihgfedcbq";
        public static String S3 = "a(bcdefghijkl(mno)p)q";
    }
}
