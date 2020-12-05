package club.vann.leetcode.offer.daily;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.CharArrayReader;
import java.util.*;

/**
 * <p>难度：Medium</p>
 * <p>题目：任务调度器</p>
 * <p>描述：给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 *
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的 最短时间 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * 示例 2：
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 0
 * 输出：6
 * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * 诸如此类
 * 示例 3：
 *
 * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * 输出：16
 * 解释：一种可能的解决方案是：
 *      A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
 *  
 *
 * 提示：
 *
 * 1 <= task.length <= 104
 * tasks[i] 是大写英文字母
 * n 的取值范围为 [0, 100]
 * 通过次数37,908提交次数73,097
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-12-05 08:37
 **/
public class LeetCode_621 {
    public static void main(String[] args) {
        LeetCode_621 leetCode = new LeetCode_621();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.leastInterval(TestCase.TASKS, TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.leastInterval(TestCase.TASKS1, TestCase.N1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.leastInterval(TestCase.TASKS2, TestCase.N2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.leastInterval(TestCase.TASKS3, TestCase.N3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.leastInterval(TestCase.TASKS4, TestCase.N4));
    }

    /**
     * 解法一：
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int ans = 0;

        return ans;
    }

    static class TestCase {
        public static int ANS = 8;
        public static char[] TASKS = {'A','A','A','B','B','B'};
        public static int N = 2;

        public static int ANS1 = 6;
        public static char[] TASKS1 = {'A','A','A','B','B','B'};
        public static int N1 = 0;

        public static int ANS2 = 16;
        public static char[] TASKS2 = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        public static int N2 = 2;

        public static int ANS3 = 7;
        public static char[] TASKS3 = {'A','A','A'};
        public static int N3 = 2;

        public static int ANS4 = 7;
        public static char[] TASKS4 = {'A','A','A','B'};
        public static int N4 = 2;

        public static int ANS5 = 16;
        public static char[] TASKS5 = {'A','A','B','C','D','E','F','G'};
        public static int N5 = 2;
    }
}
