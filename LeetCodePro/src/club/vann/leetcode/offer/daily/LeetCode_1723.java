package club.vann.leetcode.offer.daily;

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
 * 通过次数3,943提交次数8,771
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_1723
 * @Description TODO
 * @User fanyu
 * @Date 2021/5/8 9:01
 */
public class LeetCode_1723 {
    public static void main(String[] args) {
        LeetCode_1723 leetCode = new LeetCode_1723();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minimumTimeRequired(TestCase.JOBS, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minimumTimeRequired(TestCase.JOBS1, TestCase.K1));
    }

    int ans = Integer.MAX_VALUE;
    /**
     * 解法一：
     *
     * @param jobs
     * @param k
     * @return
     */
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] sum = new int[k];
        dfs(jobs, k, 0, 0, 0, sum);
        return ans;
    }

    /**
     *
     * @param jobs 当前任务集合
     * @param k 工人数量
     * @param i 当前待分配任务
     * @param used 已经分配的工人
     * @param max 当前最大工作量
     * @param sum
     */
    private void dfs(int[] jobs, int k, int i, int used, int max, int[] sum) {
        if(max >= ans) {
            return;
        }

        if(i == jobs.length) {
            ans = max;
            return;
        }

        if(used < k) {
            sum[used] = jobs[i];
            dfs(jobs, k, i+1, used+1, Math.max(sum[used], max), sum);
            sum[used] = 0;
        }

        for(int t = 0;t < used; t ++) {
            sum[t] += jobs[i];
            dfs(jobs, k, i+1, used, Math.max(sum[t], max), sum);
            sum[t] -= jobs[i];
        }
    }

    int[] jobs;
    int n, k;
    int ans1 = 0x3f3f3f3f;
    public int minimumTimeRequired1(int[] _jobs, int _k) {
        jobs = _jobs;
        n = jobs.length;
        k = _k;
        int[] sum = new int[k];
        dfs(0, 0, sum, 0);
        return ans1;
    }
    /**
     * u     : 当前处理到那个 job
     * used : 当前分配给了多少个工人了
     * sum   : 工人的分配情况          例如：sum[0] = x 代表 0 号工人工作量为 x
     * max   : 当前的「最大工作时间」
     */
    void dfs(int u, int used, int[] sum, int max) {
        if (max >= ans1) return;
        if (u == n) {
            ans1 = max;
            return;
        }
        // 优先分配给「空闲工人」
        if (used < k) {
            sum[used] = jobs[u];
            dfs(u + 1, used + 1, sum, Math.max(sum[used], max));
            sum[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            sum[i] += jobs[u];
            dfs(u + 1, used, sum, Math.max(sum[i], max));
            sum[i] -= jobs[u];
        }
    }

    static class TestCase {
        public static int ANS = 3;
        public static int[] JOBS = {3,2,3};
        public static int K = 3;

        public static int ANS1 = 11;
        public static int[] JOBS1 = {1,2,4,7,8};
        public static int K1 = 2;
    }
}
