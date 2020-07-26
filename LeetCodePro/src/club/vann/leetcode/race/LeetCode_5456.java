package club.vann.leetcode.race;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/25
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5456 {
    public static void main(String[] args) {
        LeetCode_5456 leetCode = new LeetCode_5456();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.countOdds(TestCase.PARAMS[0], TestCase.PARAMS[1]));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.countOdds(TestCase.PARAMS1[0], TestCase.PARAMS1[1]));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.countOdds(TestCase.PARAMS2[0], TestCase.PARAMS2[1]));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.countOdds(TestCase.PARAMS3[0], TestCase.PARAMS3[1]));
    }

    public int countOdds(int low, int high) {
        int count = 0;
        int val = (high-low)+1;
        if(val %2 == 0) {
            count = val/2;
        } else {
            count = low % 2 == 0 ? val/2 : val/2+1;
        }

        return count;
    }

    static class TestCase {
        public static int ANS = 3;
        public static int[] PARAMS = {3,7};

        public static int ANS1 = 1;
        public static int[] PARAMS1 = {8,10};

        public static int ANS2 = 4;
        public static int[] PARAMS2 = {13,20};

        public static int ANS3 = 145459898;
        public static int[] PARAMS3 = {278382788,569302584};



    }
}
