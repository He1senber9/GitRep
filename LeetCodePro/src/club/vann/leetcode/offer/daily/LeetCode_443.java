package club.vann.leetcode.offer.daily;

/**
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-08-21  11:02:02
 */
public class LeetCode_443 {
    public static void main(String[] args) {
        LeetCode_443 leetCode = new LeetCode_443();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.compress(TestCase.CHARS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.compress(TestCase.CHARS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.compress(TestCase.CHARS2));
    }

    /**
     * 解法一：
     *
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read ++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write ++] = chars[read];
                int num = read - left + 1;

                if (num > 1) {
//                    int anchor = write;
//                    while (num > 0) {
//                        chars[write++] = (char) (num % 10 + '0');
//                        num /= 10;
//                    }
//                    reverse(chars, anchor, write - 1);
                    String str = String.valueOf(num);
                    char[] ch = str.toCharArray();
                    for(int i = 0; i < ch.length; i ++) {
                        chars[write++] = ch[i];
                    }
                }
                left = read + 1;
            }
        }

        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    static class TestCase {
        public static int ANS = 6;
        public static char[] CHARS = {'a','a','b','b','c','c','c'};

        public static int ANS1 = 1;
        public static char[] CHARS1 = {'a'};

        public static int ANS2 = 4;
        public static char[] CHARS2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
    }
}
