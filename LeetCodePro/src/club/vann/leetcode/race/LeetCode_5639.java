package club.vann.leetcode.race;

/**
 * <p>难度：Hard</p>
 * <p>题目：完成所有工作的最短时间</p>
 * <p>描述：给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 *
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 * 示例 2：
 *
 * 输入：jobs = [1,2,4,7,8], k = 2
 * 输出：11
 * 解释：按下述方式分配工作：
 * 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
 * 2 号工人：4、7（工作时间 = 4 + 7 = 11）
 * 最大工作时间是 11 。
 *  
 *
 * 提示：
 *
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 107
 * 通过次数336提交次数2,388
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_5639
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/10 12:27
 */
public class LeetCode_5639 {
    public static void main(String[] args) {
        LeetCode_5639 leetCode = new LeetCode_5639();

//        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minimumTimeRequired(TestCase.JOBS, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minimumTimeRequired(TestCase.JOBS1, TestCase.K1));
//        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.minimumTimeRequired(TestCase.JOBS2, TestCase.K2));
    }

    int minMax = Integer.MAX_VALUE;

    /**
     * 回溯算法：
     * 超时
     * @param jobs
     * @param k
     * @return
     */
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] sum = new int[k];

        // 暴力计算
        min(jobs, sum, 0);
        return minMax;
    }

    private void min(int[] jobs, int[] sum, int index) {
        int n = jobs.length;
        if(index == n) {
            int max = Integer.MIN_VALUE;
            for(int i : sum) {
                max = Math.max(max, i);
            }
            minMax = Math.min(minMax, max);
            return;
        }

        for(int i = 0; i < sum.length; i ++) {
            sum[i] += jobs[index];
            min(jobs, sum, index+1);
            sum[i] -= jobs[index];
        }
    }

    static class TestCase {
        public static int ANS = 3;
        public static int[] JOBS = {3,2,3};
        public static int K = 3;

        public static int ANS1 = 11;
        public static int[] JOBS1 = {1,2,4,7,8};
        public static int K1 = 2;

        public static int ANS2 = 17;
        public static int[] JOBS2 = {11,2,4};
        public static int K2 = 1;
    }
}
