package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Hard</p>
 * <p>题目：青蛙过河</p>
 * <p>描述：一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 *
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 *
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 *
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：stones = [0,1,3,5,6,8,12,17]
 * 输出：true
 * 解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
 * 示例 2：
 *
 * 输入：stones = [0,1,2,3,4,8,9,11]
 * 输出：false
 * 解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 *  
 *
 * 提示：
 *
 * 2 <= stones.length <= 2000
 * 0 <= stones[i] <= 231 - 1
 * stones[0] == 0
 * 通过次数16,308提交次数39,834
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_403
 * @Description TODO
 * @User fanyu
 * @Date 2021/4/29 8:37
 */
public class LeetCode_403 {
    public static void main(String[] args) {
        LeetCode_403 leetCode = new LeetCode_403();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.canCross(TestCase.STONES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.canCross(TestCase.STONES1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.canCross(TestCase.STONES2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.canCross(TestCase.STONES3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.canCross(TestCase.STONES4));
    }

    /**
     * 解法一：
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        int n = stones.length;

        Boolean[][] memo = new Boolean[n][n];

        return helper(stones, memo,0, 0);
    }

    private boolean helper(int[] stones, Boolean[][] memo, int i, int lastDis) {
        if(i >= stones.length-1) {
            return true;
        }

        if(memo[i][lastDis] != null) {
            return memo[i][lastDis];
        }

        for(int k = lastDis-1; k <= lastDis+1; k ++) {
            if(k > 0) {
                int j = Arrays.binarySearch(stones, i + 1, stones.length,  k + stones[i]);
                if(j >= 0 && helper(stones, memo, j, k)) {
                    return memo[i][lastDis] = true;
                }
            }
        }
        return memo[i][lastDis] = false;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] STONES = {0,1,3,5,6,8,12,17};

        public static boolean ANS1 = false;
        public static int[] STONES1 = {0,1,2,3,4,8,9,11};

        public static boolean ANS2 = true;
        public static int[] STONES2 = {0,1,2,3,4,5,6};

        public static boolean ANS3 = false;
        public static int[] STONES3 = {0,1,3,6,7};

        public static boolean ANS4 = false;
        public static int[] STONES4 = {0,2147483647};
    }
}
