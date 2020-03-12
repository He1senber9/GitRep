package club.vann.leetcode.offer.daily;

import java.util.LinkedList;

/**
 * <p>难度：Easy</p>
 * <p>题目：字符串的最大公因子</p>
 * <p>描述：对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * <p>
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 * 通过次数16,172提交次数28,115
 * <p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/12
 * Time: 18:07
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1071 {
    public static void main(String[] args) {
        String str1 = "", str2 = "";
        String result = "";
        LeetCode_1071 leetCode = new LeetCode_1071();

        str1 = "ABCABC";
        str2 = "ABC";
        result = leetCode.gcdOfStrings(str1, str2);
        System.out.println("Result[ABC] :" + result);

        str1 = "ABABAB";
        str2 = "ABAB";
        result = leetCode.gcdOfStrings(str1, str2);
        System.out.println("Result[AB] :" + result);

        str1 = "LEET";
        str2 = "CODE";
        result = leetCode.gcdOfStrings(str1, str2);
        System.out.println("Result[] :" + result);

        str1 = "ABCDEF";
        str2 = "ABC";
        result = leetCode.gcdOfStrings(str1, str2);
        System.out.println("Result[] :" + result);

    }

    /**
     * 思路：
     * 关键词：除尽，当存在结果字符串 x时，字符串str1= xxxx，str2= xxxxx。
     * @param str1


     * @param str2
     * @return
     */
    private String gcdOfStrings(String str1, String str2) {
        if(str1 == null || str1 == "" || str2 == null || str2 == "") {
            return null;
        }

        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        String result = str1.substring(0, this.findGCD(str1.length(), str2.length()));
        return result;
    }

    /**
     * 求两个数的最大公约数.
     * @param one
     * @param two
     * @return
     */
    private int findGCD(int one, int two) {
        while(one != two) {
            if(one > two) {
                one -= two;
            } else {
                two -= one;
            }
        }
        return one;
    }
}
