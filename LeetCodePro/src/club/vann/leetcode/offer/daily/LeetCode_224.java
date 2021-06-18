package club.vann.leetcode.offer.daily;

import java.util.Stack;

/**
 * <p>难度：Hard</p>
 * <p>题目：基本计算器</p>
 * <p>描述：给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * 通过次数61,721提交次数148,388
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-18  11:02:50
 */
public class LeetCode_224 {
    public static void main(String[] args) {
        LeetCode_224 leetCode = new LeetCode_224();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.calculate(TestCase.S));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.calculate(TestCase.S1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.calculate(TestCase.S2));
    }

    /**
     * 解法一：
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int ans = 0;
        char[] ch = s.toCharArray();
        int len = ch.length;
        Stack<Integer> stack_nums = new Stack<>();
        Stack<Integer> stack_sign = new Stack<>();
        int sign = 1;
        for(int i = 0; i < len; i ++) {
            char c = ch[i];
            if(c == ' ') {
                continue;
            }

            if(c == '+' || c == '-') {
                sign = (c=='+') ? 1 : -1;
            } else if(c >= '0' && c <= '9') {
                int num = c - '0';
                while(i < len-1 && ch[i+1] >= '0' && ch[i+1] <= '9') {
                    num = num*10 + (ch[i+1]-'0');
                }
                ans += sign * num;
            } else if(c == '(') {
                stack_nums.push(ans);
                stack_sign.push(sign);

                ans = 0;
                sign = 1;
            } else {
                ans=stack_nums.pop()+ans*stack_sign.pop();
            }
        }
        return ans;
    }

    static class TestCase {
        public static int ANS = 2;
        public static String S = "1 + 1";

        public static int ANS1 = 3;
        public static String S1 = "2-1 + 2";

        public static int ANS2 = 23;
        public static String S2 = "(1+(4+5+2)-3)+(6+8)";
    }
}
