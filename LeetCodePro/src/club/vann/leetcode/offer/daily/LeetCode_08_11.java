package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：硬币</p>
 * <p>描述：硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= n (总金额) <= 1000000
 * 通过次数3,221提交次数6,299
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/23
 * Time: 9:47
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_08_11 {
    public static void main(String[] args) {
        LeetCode_08_11 leetCode = new LeetCode_08_11();

        System.out.println("Result["+TestCase.ans+"] " + leetCode.waysToChange(TestCase.param));
        System.out.println("Result["+TestCase.ans1+"] " + leetCode.waysToChange(TestCase.param1));
    }

    /**
     *  解法一：
     *  注意：硬币数量不限
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        return 0;
    }

    static class TestCase {
        public static final int ans = 2;
        public static final int param = 5;

        public static final int ans1 = 4;
        public static final int param1 = 10;
    }
}
