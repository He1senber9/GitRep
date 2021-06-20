package club.vann.leetcode.race.race20210620;

/**
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-20  10:55:01
 */
public class LeetCode_5788 {
    public static void main(String[] args) {
        LeetCode_5788 leetCode = new LeetCode_5788();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.largestOddNumber(TestCase.NUM));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.largestOddNumber(TestCase.NUM1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.largestOddNumber(TestCase.NUM2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.largestOddNumber(TestCase.NUM3));
    }

    /**
     * 解法一：
     *
     * @param num
     * @return
     */
    public String largestOddNumber(String num) {
        char[] ch = num.toCharArray();
        int len = ch.length;
        int index = len-1;
        while(index >= 0) {
            if(ch[index] % 2 == 0) {
                index --;
            } else {
                break;
            }
        }

        if(index < 0) {
            return "";
        }

        return num.substring(0, index+1);
    }

    static class TestCase {
        public static String ANS = "5";
        public static String NUM = "52";

        public static String ANS1 = "";
        public static String NUM1 = "4206";

        public static String ANS2 = "35427";
        public static String NUM2 = "35427";

        public static String ANS3 = "239537672423884969653287101";
        public static String NUM3 = "239537672423884969653287101";
    }
}
