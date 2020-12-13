package club.vann.leetcode.race;

/**
 * <p>难度：Medium</p>
 * <p>题目：石子游戏 VII</p>
 * <p>描述：石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。
 *
 * 有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得分较高者获胜。
 *
 * 鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。
 *
 * 给你一个整数数组 stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分的差值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：stones = [5,3,1,4,2]
 * 输出：6
 * 解释：
 * - 爱丽丝移除 2 ，得分 5 + 3 + 1 + 4 = 13 。游戏情况：爱丽丝 = 13 ，鲍勃 = 0 ，石子 = [5,3,1,4] 。
 * - 鲍勃移除 5 ，得分 3 + 1 + 4 = 8 。游戏情况：爱丽丝 = 13 ，鲍勃 = 8 ，石子 = [3,1,4] 。
 * - 爱丽丝移除 3 ，得分 1 + 4 = 5 。游戏情况：爱丽丝 = 18 ，鲍勃 = 8 ，石子 = [1,4] 。
 * - 鲍勃移除 1 ，得分 4 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [4] 。
 * - 爱丽丝移除 4 ，得分 0 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [] 。
 * 得分的差值 18 - 12 = 6 。
 * 示例 2：
 *
 * 输入：stones = [7,90,5,1,100,10,10,2]
 * 输出：122
 *
 *
 * 提示：
 *
 * n == stones.length
 * 2 <= n <= 1000
 * 1 <= stones[i] <= 1000</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-12-13 11:35
 **/
public class LeetCode_5627 {
    public static void main(String[] args) {
        LeetCode_5627 leetCode = new LeetCode_5627();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.stoneGameVII(TestCase.STONES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.stoneGameVII(TestCase.STONES1));
    }

    /**
     * 解法一：
     * @param stones
     * @return
     */
    public int stoneGameVII(int[] stones) {
        int len = stones.length;
        if(len == 2) {
            return Math.max(stones[0], stones[1]);
        }

        int res = 0;
        int left = 0, right = len-1;
        while(left+1 <= right) {
            int temp1 = 0;
            if(stones[left+1] <= stones[right]) {
                temp1 = stones[left+1];
                left ++;
            } else {
                temp1 = stones[right];
                right --;
            }

            int temp2 = 0;
            if(stones[left] <= stones[right-1]) {
                temp2 = stones[left];
                left ++;
            } else {
                temp2 = stones[right-1];
                right --;
            }

            if(temp1 <= temp2) {
                res += temp1;
            }
        }

        res += Math.max(stones[left], stones[right]);
        return res;
    }

    static class TestCase {
        public static int ANS = 6;
        public static int[] STONES = {5,3,1,4,2};

        public static int ANS1 = 122;
        public static int[] STONES1 = {7,90,5,1,100,10,10,2};
    }
}
