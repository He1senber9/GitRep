package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：回文数</p>
 * <p>描述：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 通过次数343,068提交次数594,003
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-10 08:57
 **/
public class LeetCode_9 {
    public static void main(String[] args) {
        LeetCode_9 leetCode = new LeetCode_9();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.isPalindrome(TestCase.num));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.isPalindrome(TestCase.num1));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.isPalindrome(TestCase.num2));
        System.out.println("Result["+TestCase.ans3+"] : " + leetCode.isPalindrome(TestCase.num3));
    }

    /**
     * 解法一：
     * 由于是一个整数，倒转后的数据如果与原整数相同，则表明是回文数。
     * @param x
     * @return
     */
    private boolean isPalindrome(int x) {
        // 负数直接返回false
        if(x < 0) {
            return false;
        }

        int xx = x;
        int remainder = xx % 10;
        int tmp = xx / 10;

        while(tmp > 0) {
            remainder = remainder * 10;
            remainder = remainder + (tmp % 10);
            tmp = tmp / 10;
        }

        return remainder == x;
    }

    static class TestCase {
        public static final boolean ans = true;
        public static final int num = 121;

        public static final boolean ans1 = false;
        public static final int num1 = -121;

        public static final boolean ans2 = false;
        public static final int num2 = 10;

        public static final boolean ans3 = true;
        public static final int num3 = 0;
    }

}
