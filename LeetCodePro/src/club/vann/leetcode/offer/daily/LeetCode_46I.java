package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：把数字翻译成字符串</p>
 * <p>描述：给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 *
 * 0 <= num < 231
 * 通过次数12,502提交次数23,818
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-09 08:36
 **/
public class LeetCode_46I {
    public static void main(String[] args) {
        LeetCode_46I leetCode = new LeetCode_46I();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.translateNum(TestCase.num));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.translateNum(TestCase.num1));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.translateNum(TestCase.num2));
        System.out.println("Result["+TestCase.ans3+"] : " + leetCode.translateNum(TestCase.num3));
        System.out.println("Result["+TestCase.ans4+"] : " + leetCode.translateNum(TestCase.num4));
        System.out.println("Result["+TestCase.ans5+"] : " + leetCode.translateNum(TestCase.num5));
        System.out.println("Result["+TestCase.ans6+"] : " + leetCode.translateNum(TestCase.num6));
        System.out.println("Result["+TestCase.ans7+"] : " + leetCode.translateNum(TestCase.num7));
    }

    /**
     * 解法一：
     * 由于字母最大能表示25，故只需要判断能组成多少个2位数
     * @param num
     * @return
     */
    private int translateNum(int num) {
        if(num <= 9) {
            return 1;
        }

        int tmp = num % 100;
        if(10 <= tmp && tmp <= 25) {
            return translateNum(num/10) + translateNum(num/100);
        } else {
            return translateNum(num/10);
        }
    }

    static class TestCase {
        public static final int ans = 5;
        public static final int num = 12258;

        public static final int ans1 = 5;
        public static final int num1 = 1122;

        public static final int ans2 = 13;
        public static final int num2 = 112211;

        public static final int ans3 = 2;
        public static final int num3 = 11;

        public static final int ans4 = 3;
        public static final int num4 = 111;

        public static final int ans5 = 5;
        public static final int num5 = 1111;

        public static final int ans6 = 8;
        public static final int num6 = 11111;

        public static final int ans7 = 13;
        public static final int num7 = 111111;

        public static final int ans8 = 2;
        public static final int num8 = 25;

        public static final int ans9 = 3;
        public static final int num9 = 225;

        public static final int ans10 = 4;
        public static final int num10 = 2525;

        public static final int ans11 = 8;
        public static final int num11 = 22525;
    }
}
