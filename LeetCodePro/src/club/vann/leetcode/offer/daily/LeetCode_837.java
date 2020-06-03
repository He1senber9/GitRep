package club.vann.leetcode.offer.daily;

/**
 * <p>难度：medium</p>
 * <p>题目：新21点</p>
 * <p>描述：爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 *
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
 *
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 *
 * 示例 1：
 *
 * 输入：N = 10, K = 1, W = 10
 * 输出：1.00000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 示例 2：
 *
 * 输入：N = 6, K = 1, W = 10
 * 输出：0.60000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
 * 示例 3：
 *
 * 输入：N = 21, K = 17, W = 10
 * 输出：0.73278
 * 提示：
 *
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * 如果答案与正确答案的误差不超过 10^-5，则该答案将被视为正确答案通过。
 * 此问题的判断限制时间已经减少。
 * 通过次数6,424提交次数17,134
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/new-21-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-03 13:37
 **/
public class LeetCode_837 {
    public static void main(String[] args) {
        LeetCode_837 leetCode = new LeetCode_837();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.new21Game(TestCase.nums[0], TestCase.nums[1], TestCase.nums[2]));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.new21Game(TestCase.nums1[0], TestCase.nums1[1], TestCase.nums1[2]));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.new21Game(TestCase.nums2[0], TestCase.nums2[1], TestCase.nums2[2]));
    }

    private double new21Game(int N, int K, int W) {
        
        return 0.0;
    }

    static class TestCase {
        public static final double ans = 1.00000;
        public static final int[] nums = {10, 1, 10};

        public static final double ans1 = 0.60000;
        public static final int[] nums1 = {6, 1, 10};

        public static final double ans2 = 0.73278;
        public static final int[] nums2 = {21, 17, 10};

        public static final double ans3 = 0.10000;
        public static final int[] nums3 = {1, 1, 10};

        public static final double ans4 = 0.99000;
        public static final int[] nums4 = {10, 2, 10};

        public static final double ans5 = 0.50000;
        public static final int[] nums5 = {1, 1, 2};

        public static final double ans6 = 1.00000;
        public static final int[] nums6 = {2, 1, 2};

        public static final double ans7 = 0.00000;
        public static final int[] nums7 = {1, 2, 1};

        public static final double ans8 = 1.00000;
        public static final int[] nums8 = {1, 1, 1};

        public static final double ans9 = 0.75000;
        public static final int[] nums9 = {2, 2, 2};

        public static final double ans10 = 0.59259;
        public static final int[] nums10 = {3, 3, 3};
    }
}
