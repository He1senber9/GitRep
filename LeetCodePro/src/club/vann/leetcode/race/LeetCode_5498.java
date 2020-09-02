package club.vann.leetcode.race;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/8/23
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5498 {
    public static void main(String[] args) {
        LeetCode_5498 leetCode = new LeetCode_5498();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.stoneGameV(TestCase.STONEVALUE));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.stoneGameV(TestCase.STONEVALUE1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.stoneGameV(TestCase.STONEVALUE2));
    }

    /**
     * 解法一：
     * @param stoneValue
     * @return
     */
    private int stoneGameV(int[] stoneValue) {
        int len = stoneValue.length;
        if(len == 1) {
            return 0;
        }

        if(len == 2) {
            return Math.min(stoneValue[0], stoneValue[1]);
        }

        return 0;
    }

    static class TestCase {
        public static int ANS = 18;
        public static int[] STONEVALUE = {6,2,3,4,5,5};

        public static int ANS1 = 28;
        public static int[] STONEVALUE1 = {7,7,7,7,7,7,7};

        public static int ANS2 = 0;
        public static int[] STONEVALUE2 = {4};
    }
}
