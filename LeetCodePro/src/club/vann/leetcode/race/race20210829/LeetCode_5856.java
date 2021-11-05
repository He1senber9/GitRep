package club.vann.leetcode.race.race20210829;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：完成任务的最少工作时间段</p>
 * <p>描述：你被安排了 n 个任务。任务需要花费的时间用长度为 n 的整数数组 tasks 表示，第 i 个任务需要花费 tasks[i] 小时完成。一个 工作时间段 中，你可以 至多 连续工作 sessionTime 个小时，然后休息一会儿。
 *
 * 你需要按照如下条件完成给定任务：
 *
 * 如果你在某一个时间段开始一个任务，你需要在 同一个 时间段完成它。
 * 完成一个任务后，你可以 立马 开始一个新的任务。
 * 你可以按 任意顺序 完成任务。
 * 给你 tasks 和 sessionTime ，请你按照上述要求，返回完成所有任务所需要的 最少 数目的 工作时间段 。
 *
 * 测试数据保证 sessionTime 大于等于 tasks[i] 中的 最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tasks = [1,2,3], sessionTime = 3
 * 输出：2
 * 解释：你可以在两个工作时间段内完成所有任务。
 * - 第一个工作时间段：完成第一和第二个任务，花费 1 + 2 = 3 小时。
 * - 第二个工作时间段：完成第三个任务，花费 3 小时。
 * 示例 2：
 *
 * 输入：tasks = [3,1,3,1,1], sessionTime = 8
 * 输出：2
 * 解释：你可以在两个工作时间段内完成所有任务。
 * - 第一个工作时间段：完成除了最后一个任务以外的所有任务，花费 3 + 1 + 3 + 1 = 8 小时。
 * - 第二个工作时间段，完成最后一个任务，花费 1 小时。
 * 示例 3：
 *
 * 输入：tasks = [1,2,3,4,5], sessionTime = 15
 * 输出：1
 * 解释：你可以在一个工作时间段以内完成所有任务。
 *
 *
 * 提示：
 *
 * n == tasks.length
 * 1 <= n <= 14
 * 1 <= tasks[i] <= 10
 * max(tasks[i]) <= sessionTime <= 15</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-08-29  10:59:04
 */
public class LeetCode_5856 {
    public static void main(String[] args) {
        LeetCode_5856 leetCode = new LeetCode_5856();

//        System.out.println("Result["+ TestCase.ANS + "] : " + leetCode.minSessions(TestCase.TASKS, TestCase.SESSIONTIME));
//        System.out.println("Result["+ TestCase.ANS1 + "] : " + leetCode.minSessions(TestCase.TASKS1, TestCase.SESSIONTIME1));
//        System.out.println("Result["+ TestCase.ANS2 + "] : " + leetCode.minSessions(TestCase.TASKS2, TestCase.SESSIONTIME2));
        System.out.println("Result["+ TestCase.ANS3 + "] : " + leetCode.minSessions(TestCase.TASKS3, TestCase.SESSIONTIME3));
    }

    /**
     * 解法一：
     *
     * @param tasks
     * @param sessionTime
     * @return
     */
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);

        int n = tasks.length;
        for(int i = n-2; i >= 0; i --) {
            for(int j = n-1; j >= i+1; j --) {
                if(tasks[j] == 0) {
                    continue;
                }

                if(tasks[j] + tasks[i] <= sessionTime) {
                    tasks[j] = tasks[j] + tasks[i];
                    tasks[i] = 0;
                    break;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i ++) {
            if(tasks[i] != 0) {
                ans ++;
            }
        }

        return ans;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[] TASKS = {1,2,3};
        public static int SESSIONTIME = 3;

        public static int ANS1 = 2;
        public static int[] TASKS1 = {3,1,3,1,1};
        public static int SESSIONTIME1 = 8;

        public static int ANS2 = 1;
        public static int[] TASKS2 = {1,2,3,4,5};
        public static int SESSIONTIME2 = 15;

        public static int ANS3 = 4;
        public static int[] TASKS3 = {2,3,3,4,4,4,5,6,7,10};
        public static int SESSIONTIME3 = 12;
    }
}
