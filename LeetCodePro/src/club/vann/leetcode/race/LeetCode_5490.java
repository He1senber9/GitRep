package club.vann.leetcode.race;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/8/16
 * Time: 11:47
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5490 {
    public static void main(String[] args) {
        LeetCode_5490 leetCode = new LeetCode_5490();

        System.out.println("Result["+TestCase.ANS+"] :" + leetCode.minDays(TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"] :" + leetCode.minDays(TestCase.N1));
        System.out.println("Result["+TestCase.ANS2+"] :" + leetCode.minDays(TestCase.N2));
        System.out.println("Result["+TestCase.ANS3+"] :" + leetCode.minDays(TestCase.N3));
        System.out.println("Result["+TestCase.ANS4+"] :" + leetCode.minDays(TestCase.N4));
    }

    int res = 0;
    public int minDays(int n) {
        // 采用 BFS 方案探索

        int res = 0;
        if(n <= 0) {
            return 0;
        }

        int val1 = Integer.MAX_VALUE;
        int val2 = Integer.MAX_VALUE;
        int val3 = Integer.MAX_VALUE;
        // 尝试 吃一个
        val1 = Math.min(val1, 1 + minDays(n-1));

        if(n%2==0) {
            val2 = Math.min(val2, 1 + minDays(n-n/2));
        }
        if(n%3==0) {
            val3 = Math.min(val3, 1 + minDays(n - 2 * (n/3)));
        }

        int val = Math.min(val1, val2);
        val = Math.min(val, val3);
        return val;
    }

    static class TestCase {
        public static int ANS = 4;
        public static int N = 10;

        public static int ANS1 = 1;
        public static int N1 = 1;

        public static int ANS2 = 3;
        public static int N2 = 6;

        public static int ANS3 = 6;
        public static int N3 = 56;

        public static int ANS4 = 8;
        public static int N4 = 540;
    }
}
