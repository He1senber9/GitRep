package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-08-03 08:25
 **/
public class LeetCode_415 {
    public static void main(String[] args) {
        LeetCode_415 leetCode = new LeetCode_415();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.addStrings(TestCase.STRINGS[0], TestCase.STRINGS[1]));
    }

    /**
     * 解法一：
     *
     * @param num1
     * @param num2
     * @return
     */
    private String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        int len1 = chars1.length;
        int len2 = chars2.length;
        int len = Math.max(len1, len2)+1;

        char[] ch = new char[len];
        int index1 = len1-1;
        int index2 = len2-1;
        int pos = 0;
        int index = len-1;
        while(index1>=0 || index2 >= 0) {
            int val = 0;
            if(index1 >= 0) {
                val += chars1[index1--] - '0';
            }
            if(index2 >= 0) {
                val += chars2[index2--] - '0';
            }

            val += pos;
            ch[index--] = (char) (val%10 + '0');
            pos = val/10;
        }
        if(pos > 0) {
            ch[index] = (char) (pos + '0');
            return new String(ch);
        } else {
            return new String(ch).substring(1);
        }
    }

    static class TestCase {
        public static String ANS = "246";
        public static String[] STRINGS = {"123", "123"};
    }
}
