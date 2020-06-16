package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：最佳观光组合</p>
 * <p>描述：给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 *  
 *
 * 示例：
 *
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 * 通过次数6,496提交次数13,100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/17
 * Time: 7:08
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1014 {
    public static void main(String[] args) {
        LeetCode_1014 leetCode = new LeetCode_1014();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.maxScoreSightseeingPair(TestCase.nums));
    }

    private int maxScoreSightseeingPair(int[] A) {
        if(A == null || A.length < 2) {
            return 0;
        }

        int max = 0;
        int len = A.length;
        for(int i = 0; i < len-1; i ++) {
            for(int j = i+1; j < len; j ++) {
                int tmp = A[j] + A[i] + i - j;
                max = Math.max(max, tmp);
            }
        }
        return max;
    }

    static class TestCase {
        public static final int ans = 11;
        public static final int[] nums = {8,1,5,2,6};
    }
}
