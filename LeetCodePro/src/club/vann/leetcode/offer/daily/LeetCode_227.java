package club.vann.leetcode.offer.daily;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>难度：Medium</p>
 * <p>题目：基本计算器II</p>
 * <p>描述：给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * 通过次数36,584提交次数92,179
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-11:08:09:35
 */
public class LeetCode_227 {
    public static void main(String[] args) {
        LeetCode_227 leetCode = new LeetCode_227();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.calculate(TestCase.S));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.calculate(TestCase.S1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.calculate(TestCase.S2));
    }

    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n-1){
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    static class TestCase {
        public static int ANS = 7;
        public static String S = "3+2*2";

        public static int ANS1 = 1;
        public static String S1 = " 3/2 ";

        public static int ANS2 = 5;
        public static String S2 = " 3+5 / 2 ";
    }
}
