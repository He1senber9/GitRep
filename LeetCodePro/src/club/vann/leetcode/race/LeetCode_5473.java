package club.vann.leetcode.race;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/26
 * Time: 10:58
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5473 {
    public static void main(String[] args) {
        LeetCode_5473 leetCode = new LeetCode_5473();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minFlips1(TestCase.TARGET));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minFlips1(TestCase.TARGET1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.minFlips1(TestCase.TARGET2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.minFlips1(TestCase.TARGET3));
    }

    /**
     * 解法一：
     *
     * @param target
     * @return
     */
    private int minFlips(String target) {
        int len = target.length();
        char[] ch = target.toCharArray();
        int res = 0;
        for(int i = 0; i < len; i ++) {
            if(ch[i]=='0') {
                continue;
            } else {
                res ++;
                for(int k = i; k < len; k ++) {
                    ch[k] = ch[k]=='0' ? '1' : '0';
                }
            }
        }
        return res;
    }

    private int minFlips1(String target) {
        int len = target.length();
        char[] ch = target.toCharArray();
        int tag = 1;
        int res = 0;
        for(int i = 0; i < len; i ++) {
            if(tag == 1) {
                if(target.charAt(i) == '1') {
                    res ++;
                    tag *= -1;
                }
            } else {
                if(target.charAt(i)=='0') {
                    res ++;
                    tag *= -1;
                }
            }
        }
        return res;
    }

    static class TestCase {
        public static int ANS = 3;
        public static String TARGET = "10111";

        public static int ANS1 = 3;
        public static String TARGET1 = "101";

        public static int ANS2 = 0;
        public static String TARGET2 = "00000";

        public static int ANS3 = 5;
        public static String TARGET3 = "001011101";
    }
}
