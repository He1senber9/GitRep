package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Midum</p>
 * <p>题目：字符串转换整数 (atoi)</p>
 * <p>描述：请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *  
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * 通过次数129,029提交次数661,110
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/3
 * Time: 9:16
 * Description:
 */
public class LeetCode_8 {
    public static void main(String[] args) {
        LeetCode_8 leetCode = new LeetCode_8();

        System.out.println("Result["+TestCase.ans_str+"] " + leetCode.myAtoi(TestCase.str));
        System.out.println("Result["+TestCase.ans_str1+"] " + leetCode.myAtoi(TestCase.str1));
        System.out.println("Result["+TestCase.ans_str2+"] " + leetCode.myAtoi(TestCase.str2));
        System.out.println("Result["+TestCase.ans_str3+"] " + leetCode.myAtoi(TestCase.str3));
        System.out.println("Result["+TestCase.ans_str4+"] " + leetCode.myAtoi(TestCase.str4));
        System.out.println("Result["+TestCase.ans_str4+"] " + leetCode.myAtoi(TestCase.str4));
        System.out.println("Result["+TestCase.ans_str5+"] " + leetCode.myAtoi(TestCase.str5));
        System.out.println("Result["+TestCase.ans_str6+"] " + leetCode.myAtoi(TestCase.str6));
        System.out.println("Result["+TestCase.ans_str7+"] " + leetCode.myAtoi(TestCase.str7));
        System.out.println("Result["+TestCase.ans_str8+"] " + leetCode.myAtoi(TestCase.str8));
        System.out.println("Result["+TestCase.ans_str9+"] " + leetCode.myAtoi(TestCase.str9));
        System.out.println("Result["+TestCase.ans_str10+"] " + leetCode.myAtoi(TestCase.str10));
        System.out.println("Result["+TestCase.ans_str11+"] " + leetCode.myAtoi(TestCase.str11));
        System.out.println("Result["+TestCase.ans_str12+"] " + leetCode.myAtoi(TestCase.str12));
        System.out.println("Result["+TestCase.ans_str13+"] " + leetCode.myAtoi(TestCase.str13));
    }

    private int myAtoi(String str) {
        int result = 0;

        if(str == null) {
            return result;
        }

        str = str.trim();
        if(str.length() == 0) {
            return result;
        }

        int flag = 1; // 正负号标志
        int pow = 10;
        for(int n = 0; n < str.length(); n ++) {
            int v = str.charAt(n);

            if(n==0 && v == '-') {
                flag = -1;
            } else if(n == 0 && v == '+') {
                flag = 1;
            } else if('0' <= v && v <= '9') {
                int t = v-'0';
                int tag1 = result*pow+t;
                int tag2 = result;
                if(flag*tag1/pow != flag*tag2) { // 检查是否溢出
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                result = tag1;
            } else {
                break;
            }
        }

        return result*flag;
    }

    static class TestCase {
        public static final int ans_str = 42;
        public static final String str = "42";

        public static final int ans_str1 = -42;
        public static final String str1 = "   -42";

        public static final int ans_str2 = 4193;
        public static final String str2 = "4193 with words";

        public static final int ans_str3 = 0;
        public static final String str3 = "words and 987";

        public static final int ans_str4 = -2147483648;
        public static final String str4 = "-91283472332";

        public static final int ans_str5 = 0;
        public static final String str5 = "";

        public static final int ans_str6 = 0;
        public static final String str6 = "   ";

        public static final int ans_str7 = 0;
        public static final String str7 = "-abc89";

        public static final int ans_str8 = 42;
        public static final String str8 = "+42";

        public static final int ans_str9 = 0;
        public static final String str9 = "+-2";

        public static final int ans_str10 = 2147483647;
        public static final String str10 = "2147483648";

        public static final int ans_str11 = 2147483646;
        public static final String str11 = "2147483646";

        public static final int ans_str12 = -2147483648;
        public static final String str12 = "-2147483649";

        public static final int ans_str13 =-2147483647;
        public static final String str13 = "-2147483647";
    }
}
