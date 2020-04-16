package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Midum</p>
 * <p>题目：机器人的运动范围</p>
 * <p>描述：地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * 通过次数16,758提交次数34,776
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-04-08 12:27
 **/
public class LeetCode_13 {
    public static void main(String[] args) {
        LeetCode_13 leetCode = new LeetCode_13();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.movingCount(TestCase.params[0], TestCase.params[1], TestCase.params[2]));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.movingCount(TestCase.params1[0], TestCase.params1[1], TestCase.params1[2]));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.movingCount(TestCase.params2[0], TestCase.params2[1], TestCase.params2[2]));
        System.out.println("Result["+TestCase.ans3+"] : " + leetCode.movingCount(TestCase.params3[0], TestCase.params3[1], TestCase.params3[2]));
    }

    /**
     * 解法一：
     * 采用数学思想
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        int result = 0;

        return result;
    }

    static class TestCase {

        public static final int ans = 3;
        public static final int[] params = {2, 3, 1};

        public static final int ans1 = 1;
        public static final int[] params1 = {3, 1, 0};

        public static final int ans2 = 6;
        public static final int[] params2 = {3, 2, 17};

        public static final int ans3 = 88;
        public static final int[] params3 = {11, 8, 16};
    }
}
