package club.vann.leetcode.race;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/8/30
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5499 {
    public static void main(String[] args) {
        LeetCode_5499 leetCode = new LeetCode_5499();

        System.out.println("Result["+TestCase.ANS+"] :" + leetCode.containsPattern(TestCase.ARR, TestCase.M, TestCase.K));
    }

    public boolean containsPattern(int[] arr, int m, int k) {
        if(arr == null || arr.length < m*k) {
            return false;
        }

        int len = arr.length;
        A:for(int i = 0; i <= len-(m*k); i ++) {
            for(int n = i; n < i+m; n ++) {
                for(int t = 1; t <= k-1; t ++) {
                    if(arr[n] != arr[n+t*m]) {
                        continue A;
                    }
                }
            }
            return true;
        }

        return false;
    }

    static class TestCase {
        public static boolean ANS = false;
        public static int M = 2;
        public static int K = 3;
        public static int[] ARR = {1,2,1,2,1,3};
    }
}
