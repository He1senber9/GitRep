package club.vann.leetcode.race;

/**
 * @ClassName LeetCode_5738
 * @Description TODO
 * @User fanyu
 * @Date 2021/4/25 11:02
 */
public class LeetCode_5738 {
    public static void main(String[] args) {
        LeetCode_5738 leetCode = new LeetCode_5738();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.sumBase(TestCase.N, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.sumBase(TestCase.N1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.sumBase(TestCase.N2, TestCase.K2));
    }

    public int sumBase(int n, int k) {
        if(n < k) {
            return n;
        }
        int ans = 0;

        int pow = k;
        while(n/pow >= k) {
            pow *= k;
        }

        int val = n/pow;
        int lift = n - val*pow;
        ans += val;
        ans += sumBase(lift, k);
        return ans;
    }

    static class TestCase {
        public static int ANS = 9;
        public static int N = 34;
        public static int K = 6;

        public static int ANS1 = 1;
        public static int N1 = 10;
        public static int K1 = 10;

        public static int ANS2 = 3;
        public static int N2 = 42;
        public static int K2 = 2;
    }
}
