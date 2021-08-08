package club.vann.leetcode.race.race20210808;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>难度：Medium</p>
 * <p>题目：移除石子使总数最小</p>
 * <p>描述：给你一个整数数组 piles ，数组 下标从 0 开始 ，其中 piles[i] 表示第 i 堆石子中的石子数量。另给你一个整数 k ，请你执行下述操作 恰好 k 次：
 *
 * 选出任一石子堆 piles[i] ，并从中 移除 floor(piles[i] / 2) 颗石子。
 * 注意：你可以对 同一堆 石子多次执行此操作。
 *
 * 返回执行 k 次操作后，剩下石子的 最小 总数。
 *
 * floor(x) 为 小于 或 等于 x 的 最大 整数。（即，对 x 向下取整）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：piles = [5,4,9], k = 2
 * 输出：12
 * 解释：可能的执行情景如下：
 * - 对第 2 堆石子执行移除操作，石子分布情况变成 [5,4,5] 。
 * - 对第 0 堆石子执行移除操作，石子分布情况变成 [3,4,5] 。
 * 剩下石子的总数为 12 。
 * 示例 2：
 *
 * 输入：piles = [4,3,6,7], k = 3
 * 输出：12
 * 解释：可能的执行情景如下：
 * - 对第 2 堆石子执行移除操作，石子分布情况变成 [4,3,3,7] 。
 * - 对第 3 堆石子执行移除操作，石子分布情况变成 [4,3,3,4] 。
 * - 对第 0 堆石子执行移除操作，石子分布情况变成 [2,3,3,4] 。
 * 剩下石子的总数为 12 。
 *
 *
 * 提示：
 *
 * 1 <= piles.length <= 105
 * 1 <= piles[i] <= 104
 * 1 <= k <= 105</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-08-08  11:30:47
 */
public class LeetCode_5839 {
    public static void main(String[] args) {
        LeetCode_5839 leetCode = new LeetCode_5839();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minStoneSum(TestCase.PILES, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minStoneSum(TestCase.PILES1, TestCase.K1));
    }

    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i : piles) {
            queue.add(i);
        }

        int cnt = 0;
        while(cnt < k && !queue.isEmpty()) {
            int cur = queue.poll();
            int val = (cur - cur/2);
            queue.add(val);
            cnt ++;
        }

        int res = 0;
        while(!queue.isEmpty()) {
            res += queue.poll();
        }

        return res;
    }

    static class TestCase {
        public static int ANS = 12;
        public static int[] PILES = {5,4,9};
        public static int K = 2;

        public static int ANS1 = 12;
        public static int[] PILES1 = {4,3,6,7};
        public static int K1 = 3;
    }
}
