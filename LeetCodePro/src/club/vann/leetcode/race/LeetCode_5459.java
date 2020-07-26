package club.vann.leetcode.race;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/25
 * Time: 23:44
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5459 {
    public static void main(String[] args) {
        LeetCode_5459 leetCode = new LeetCode_5459();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minNumberOperations(TestCase.TARGET));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minNumberOperations(TestCase.TARGET1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.minNumberOperations(TestCase.TARGET2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.minNumberOperations(TestCase.TARGET3));
    }

    /**
     * 解法一：
     *
     * @param target
     * @return
     */
    private int minNumberOperations(int[] target) {
        int len = target.length;
        return count(target, 0, len-1);
    }

    private int count(int[] target, int left, int right) {
        if(left > right) {
            return 0;
        }

        if(left == right) {
            return target[left];
        }

        int val = 0;
        int begin = left;
        for(int n = left; n <= right; n ++) {
            if(target[n] > 0) {
                continue;
            } else {
                val += count(target, left, n-1);
                left = n;
            }
        }
        return 0;
    }

    static class TestCase {
        public static int ANS = 3;
        public static int[] TARGET = {1,2,3,2,1};

        public static int ANS1 = 4;
        public static int[] TARGET1 = {3,1,1,2};

        public static int ANS2 = 7;
        public static int[] TARGET2 = {3,1,5,4,2};

        public static int ANS3 = 1;
        public static int[] TARGET3 = {1,1,1,1};
    }
}
