package club.vann.leetcode.race;

import java.util.Arrays;

/**
 * @ClassName LeetCode_5649
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/10 11:07
 */
public class LeetCode_5649 {
    public static void main(String[] args) {
        LeetCode_5649 leetCode = new LeetCode_5649();
        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.decode(TestCase.ENCODED, TestCase.FIRST)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.decode(TestCase.ENCODED1, TestCase.FIRST1)));
    }

    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] ans = new int[n+1];
        ans[0] = first;

        for(int i = 1; i < n+1; i ++) {
            int temp = encoded[i-1];
            ans[i] = first ^ temp;
            first = ans[i];
        }
        return ans;
    }

    static class TestCase {
        public static int[] ANS = {1,0,2,1};
        public static int[] ENCODED = {1,2,3};
        public static int FIRST = 1;

        public static int[] ANS1 = {4,2,0,7,4};
        public static int[] ENCODED1 = {6,2,7,3};
        public static int FIRST1 = 4;
    }
}
