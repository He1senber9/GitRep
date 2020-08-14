package club.vann.leetcode;

import java.util.LinkedList;

/**
 * <p>难度：Medium</p>
 * <p>题目：Z字型变换</p>
 * <p>描述：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 通过次数155,648提交次数321,273
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-08-06 15:52
 **/
public class LeetCode_6 {
    public static void main(String[] args) {
        LeetCode_6 leetCode = new LeetCode_6();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.convert(TestCase.STR, TestCase.NUM));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.convert(TestCase.STR1, TestCase.NUM1));
    }

    /**
     * 解法一：
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        int len = s.length();

        if(numRows == 1) {
            return s;
        }

        char[] ch = s.toCharArray();
        StringBuilder builder = new StringBuilder();

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);

        while(!linkedList.isEmpty()) {
            int index = linkedList.pollFirst();
            builder.append(ch[index]);

            if(index-1 > 0) {
                linkedList.addLast(index-1);
            }
            if(index+1 < len) {
                linkedList.addLast(index+1);
            }

            // 计算以index为起点
            int newIndex = index+(2*numRows-2);
            while(newIndex < len) {
                builder.append(ch[newIndex]);
            }
        }

        return builder.toString();
    }

    private void convert(char[] ch, StringBuilder builder) {

    }

    static class TestCase{
        public static String ANS = "LCIRETOESIIGEDHN";
        public static int NUM = 3;
        public static String STR = "LEETCODEISHIRING";

        public static String ANS1 = "LEETCODEISHIRING";
        public static int NUM1 = 4;
        public static String STR1 = "LDREOEIIECIHNTSG";

    }
}
