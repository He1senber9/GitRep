package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Hard</p>
 * <p>题目：给表达式添加运算符</p>
 * <p>描述：给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"]
 * 示例 2:
 *
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 * 示例 3:
 *
 * 输入: num = "105", target = 5
 * 输出: ["1*0+5","10-5"]
 * 示例 4:
 *
 * 输入: num = "00", target = 0
 * 输出: ["0+0", "0-0", "0*0"]
 * 示例 5:
 *
 * 输入: num = "3456237490", target = 9191
 * 输出: []
 *  
 *
 * 提示：
 *
 * 1 <= num.length <= 10
 * num 仅含数字
 * -231 <= target <= 231 - 1
 * 通过次数8,827提交次数21,232
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/expression-add-operators
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-10-16  09:53:14
 */
public class LeetCode_282 {
    public static void main(String[] args) {
        LeetCode_282 leetCode = new LeetCode_282();

        List<String> result = null;
        result = leetCode.addOperators(TestCase.NUM, TestCase.TARGET);
        result = leetCode.addOperators(TestCase.NUM1, TestCase.TARGET1);
        result = leetCode.addOperators(TestCase.NUM2, TestCase.TARGET2);
        result = leetCode.addOperators(TestCase.NUM3, TestCase.TARGET3);
        result = leetCode.addOperators(TestCase.NUM4, TestCase.TARGET4);
    }

    int n;
    String num;
    int target;
    List<String> ans;
    /**
     * 解法一：
     *
     * @param num
     * @param target
     * @return
     */
    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.num = num;
        this.target = target;
        this.ans = new ArrayList<String>();
        StringBuffer expr = new StringBuffer();
        backtrack(expr, 0, 0, 0);
        return ans;
    }

    /**
     *
     * @param expr 当前已经构建的表达式
     * @param i 当前枚举到了第 i 个字符
     * @param res 当前表达式计算的结果
     * @param mul 表达式最后一个连乘串的结果
     */
    public void backtrack(StringBuffer expr, int i, long res, long mul) {
        if (i == n) {
            if (res == target) {
                ans.add(expr.toString());
            }
            return;
        }
        int signIndex = expr.length();
        if (i > 0) {
            expr.append(0); // 占位，下面填充符号
        }
        long val = 0;
        // 枚举截取的数字长度（取多少位），注意数字可以是单个 0 但不能有前导零
        for (int j = i; j < n && (j == i || num.charAt(i) != '0'); ++j) {
            val = val * 10 + num.charAt(j) - '0';
            expr.append(num.charAt(j));
            if (i == 0) { // 表达式开头不能添加符号
                backtrack(expr, j + 1, val, val);
            } else { // 枚举符号
                expr.setCharAt(signIndex, '+');
                backtrack(expr, j + 1, res + val, val);
                expr.setCharAt(signIndex, '-');
                backtrack(expr, j + 1, res - val, -val);
                expr.setCharAt(signIndex, '*');
                backtrack(expr, j + 1, res - mul + mul * val, mul * val);
            }
        }
        expr.setLength(signIndex);
    }

    static class TestCase {
        public static String NUM = "123";
        public static int TARGET = 6;

        public static String NUM1 = "232";
        public static int TARGET1 = 8;

        public static String NUM2 = "105";
        public static int TARGET2 = 5;

        public static String NUM3 = "00";
        public static int TARGET3 = 0;

        public static String NUM4 = "3456237490";
        public static int TARGET4 = 9191;
    }
}
