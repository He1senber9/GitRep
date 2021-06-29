package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：Excel表列名称</p>
 * <p>描述：给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 * 通过次数54,906提交次数137,656
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-29  08:09:15
 */
public class LeetCode_168 {
    public static void main(String[] args) {
        LeetCode_168 leetCode = new LeetCode_168();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.convertToTitle(TestCase.COLUMNNUMBER));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.convertToTitle(TestCase.COLUMNNUMBER1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.convertToTitle(TestCase.COLUMNNUMBER2));
    }

    /**
     * 解法一：
     * 10进制转26进制。[1,26]
     * an,an-1,an-2....a2,a1,a0
     * a0 = (num-1)%26;
     * num = (num-a0)/26;
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while(columnNumber > 0) {
            int pow = (columnNumber-1)%26;
            builder.append((char) (pow+'A'));
            columnNumber = (columnNumber-pow)/26;
        }

        return builder.reverse().toString();
    }

    static class TestCase {
        public static String ANS = "A";
        public static int COLUMNNUMBER = 1;

        public static String ANS1 = "AB";
        public static int COLUMNNUMBER1 = 28;

        public static String ANS2 = "ZY";
        public static int COLUMNNUMBER2 = 701;
    }
}
