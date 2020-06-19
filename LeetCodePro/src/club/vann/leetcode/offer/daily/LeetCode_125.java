package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：验证回文串</p>
 * <p>描述：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 通过次数114,996提交次数259,078
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-19 08:59
 **/
public class LeetCode_125 {

    public static void main(String[] args) {
        LeetCode_125 leetCode = new LeetCode_125();

//        System.out.println("Result["+TestCase.ANS+"]: " + leetCode.isPalindrome(TestCase.STR));
        System.out.println("Result["+TestCase.ANS1+"]: " + leetCode.isPalindrome(TestCase.STR1));
        System.out.println("Result["+TestCase.ANS2+"]: " + leetCode.isPalindrome(TestCase.STR2));
        System.out.println("Result["+TestCase.ANS3+"]: " + leetCode.isPalindrome(TestCase.STR3));
        System.out.println("Result["+TestCase.ANS4+"]: " + leetCode.isPalindrome(TestCase.STR4));
    }

    /**
     * 解法一：
     *
     * @param s
     * @return
     */
    private boolean isPalindrome(String s) {
        if(s == null || s == "") {
            return true;
        }

        int len = s.length();
        int left = 0, right = len-1;

        int offset = 'a' - 'A';
        while(left <= right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            if(!( ('a' <= leftC && leftC <= 'z') || ('A' <= leftC && leftC <= 'Z') || ('0' <= leftC && leftC <= '9') ) ) {
                left ++;
                continue;
            }

            if(!(('a' <= rightC && rightC <= 'z') || ('A' <= rightC && rightC <= 'Z') || ('0' <= rightC && rightC <= '9'))) {
                right --;
                continue;
            }

            if(leftC == rightC) {
                left ++;
                right --;
                continue;
            }

            if(('0' <= leftC && leftC <= '9') || ('0' <= rightC && rightC <= '9')) {
                return false;
            }

            if(leftC == rightC+offset || rightC == leftC+offset) {
                left ++;
                right --;
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    static class TestCase {
        public static final boolean ANS = true;
        public static final String STR = "A man, a plan, a canal: Panama";

        public static final boolean ANS1 = false;
        public static final String STR1 = "race a car";

        public static final boolean ANS2 = true;
        public static final String STR2 = "a";

        public static final boolean ANS3 = true;
        public static final String STR3 = "a ";

        public static final boolean ANS4 = false;
        public static final String STR4 = "0P";

    }
}
