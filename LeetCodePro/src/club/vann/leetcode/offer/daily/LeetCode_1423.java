package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：可获得的最大点数</p>
 * <p>描述：几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 *
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 *
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 *
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 * 示例 2：
 *
 * 输入：cardPoints = [2,2,2], k = 2
 * 输出：4
 * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
 * 示例 3：
 *
 * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
 * 输出：55
 * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
 * 示例 4：
 *
 * 输入：cardPoints = [1,1000,1], k = 1
 * 输出：1
 * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
 * 示例 5：
 *
 * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * 输出：202
 *  
 *
 * 提示：
 *
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 * 通过次数10,427提交次数21,325
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-06:09:36:11
 */
public class LeetCode_1423 {
    public static void main(String[] args) {
        LeetCode_1423 leetCode = new LeetCode_1423();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxScore(TestCase.CARDPOINTS, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxScore(TestCase.CARDPOINTS1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxScore(TestCase.CARDPOINTS2, TestCase.K2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.maxScore(TestCase.CARDPOINTS3, TestCase.K3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.maxScore(TestCase.CARDPOINTS4, TestCase.K4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.maxScore(TestCase.CARDPOINTS5, TestCase.K5));
    }

    /**
     * 解法一：
     *
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        // 总和
        int allSum = 0;
        for(int i = 0; i < len; i ++) {
            allSum += cardPoints[i];
        }

        if(k == len) {
            return allSum;
        }

        int start = 0, end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(end < len) {
            sum += cardPoints[end];
            if(end-start+1 == len-k) {
                res = Math.min(res, sum);
                sum -= cardPoints[start];
                start ++;
            }
            end ++;
        }
        return allSum - res;
    }

    static class TestCase {
        public static int ANS = 12;
        public static int[] CARDPOINTS = {1,2,3,4,5,6,1};
        public static int K = 3;

        public static int ANS1 = 4;
        public static int[] CARDPOINTS1 = {2,2,2};
        public static int K1 = 2;

        public static int ANS2 = 55;
        public static int[] CARDPOINTS2 = {9,7,7,9,7,7,9};
        public static int K2 = 7;

        public static int ANS3 = 1;
        public static int[] CARDPOINTS3 = {1,1000,1};
        public static int K3 = 1;

        public static int ANS4 = 202;
        public static int[] CARDPOINTS4 = {1,79,80,1,1,1,200,1};
        public static int K4 = 3;

        public static int ANS5 = 232;
        public static int[] CARDPOINTS5 = {11,49,100,20,86,29,72};
        public static int K5 = 4;

    }
}
