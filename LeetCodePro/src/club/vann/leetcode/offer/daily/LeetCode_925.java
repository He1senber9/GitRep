package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：长按键入</p>
 * <p>描述：你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 *
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 *
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 *
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 *  
 *
 * 提示：
 *
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 *  
 *
 *  
 *
 * 通过次数13,996提交次数34,888
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/long-pressed-name
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/10/21
 * Time: 8:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_925 {
    public static void main(String[] args) {
        LeetCode_925 leetCode = new LeetCode_925();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.isLongPressedName(TestCase.NAME, TestCase.TYPED));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.isLongPressedName(TestCase.NAME1, TestCase.TYPED1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.isLongPressedName(TestCase.NAME2, TestCase.TYPED2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.isLongPressedName(TestCase.NAME3, TestCase.TYPED3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.isLongPressedName(TestCase.NAME4, TestCase.TYPED4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.isLongPressedName(TestCase.NAME5, TestCase.TYPED5));
        System.out.println("Result["+TestCase.ANS6+"] : " + leetCode.isLongPressedName(TestCase.NAME6, TestCase.TYPED6));
    }

    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    static class TestCase {
        public static boolean ANS = true;
        public static String NAME = "alex";
        public static String TYPED = "aaleex";

        public static boolean ANS1 = false;
        public static String NAME1 = "saeed";
        public static String TYPED1 = "ssaaedd";

        public static boolean ANS2 = true;
        public static String NAME2 = "leelee";
        public static String TYPED2 = "lleeelee";

        public static boolean ANS3 = true;
        public static String NAME3 = "laiden";
        public static String TYPED3 = "laiden";

        public static boolean ANS4 = true;
        public static String NAME4 = "vtkgn";
        public static String TYPED4 = "vttkgnn";

        public static boolean ANS5 = true;
        public static String NAME5 = "abcd";
        public static String TYPED5 = "aaabbbcccddd";

        public static boolean ANS6 = false;
        public static String NAME6 = "pyplrz";
        public static String TYPED6 = "ppyypllr";

        public static boolean ANS7 = false;
        public static String NAME7 = "alex";
        public static String TYPED7 = "alexxr";

    }
}
