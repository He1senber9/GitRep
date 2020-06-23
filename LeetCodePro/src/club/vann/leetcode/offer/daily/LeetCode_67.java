package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p>题目：二进制求和</p>
 * <p>描述：给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * 通过次数97,402提交次数181,672
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-23 11:32
 **/
public class LeetCode_67 {
    public static void main(String[] args) {
        LeetCode_67 leetCode = new LeetCode_67();

        System.out.println("Result["+TestCase.ans+"]: " + leetCode.addBinary(TestCase.strs[0], TestCase.strs[1]));
        System.out.println("Result["+TestCase.ans1+"]: " + leetCode.addBinary(TestCase.strs1[0], TestCase.strs1[1]));
        System.out.println("Result["+TestCase.ans2+"]: " + leetCode.addBinary(TestCase.strs2[0], TestCase.strs2[1]));
        System.out.println("Result["+TestCase.ans3+"]: " + leetCode.addBinary(TestCase.strs3[0], TestCase.strs3[1]));
        System.out.println("Result["+TestCase.ans4+"]: " + leetCode.addBinary(TestCase.strs4[0], TestCase.strs4[1]));
    }

    /**
     * 解法一：
     *
     * @param a
     * @param b
     * @return
     */
    private String addBinary(String a, String b) {
        int len_a = a.length();
        int len_b = b.length();

        int len = Math.max(len_a, len_b);
        char[] ch = new char[len+1];

        int index_a = len_a-1;
        int index_b = len_b-1;
        for(int n = len; n >= 0; n --) {
            char c_a = '0';
            if(index_a>=0) {
                c_a = a.charAt(index_a);
            }

            char c_b = '0';
            if(index_b>=0) {
                c_b = b.charAt(index_b);
            }

            index_a --;
            index_b --;

            if(c_a == '0' && c_b == '0') {
                if(ch[n] != '1') {
                    ch[n] = '0';
                }
                continue;
            }

            if(c_a == '1' && c_b == '1') {
                if(ch[n] == '1') {
                    ch[n-1] = '1';
                } else {
                    ch[n] = '0';
                    ch[n-1] = '1';
                }
                continue;
            }

            if(c_a == '1' || c_b == '1') {
                if(ch[n] == '1') {
                    ch[n] = '0';
                    ch[n-1] = '1';
                } else {
                    ch[n] = '1';
                }
                continue;
            }
        }

        String result = new String(ch);
        if(ch[0] == '0') {
            result = result.substring(1);
        }
        return result;
    }

    static class TestCase {
        public static final String ans = "100";
        public static final String[] strs = {"11", "1"};

        public static final String ans1 = "10101";
        public static final String[] strs1 = {"1010", "1011"};

        public static final String ans2 = "10101";
        public static final String[] strs2 = {"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"};

        public static final String ans3 = "110";
        public static final String[] strs3 = {"11", "11"};

        public static final String ans4 = "1100";
        public static final String[] strs4 = {"1001", "11"};

    }
}
