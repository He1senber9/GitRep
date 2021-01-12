package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Medium</p>
 * <p>题目：课程表II</p>
 * <p>描述：现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 *
 * 通过次数56,482提交次数107,813
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_210
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/12 11:23
 */
public class LeetCode_210 {
    public static void main(String[] args) {
        LeetCode_210 leetCode = new LeetCode_210();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.findOrder(TestCase.NUMCOURSES, TestCase.PREREQUISITES)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.findOrder(TestCase.NUMCOURSES1, TestCase.PREREQUISITES1)));
    }

    /**
     * 解法一：
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 借助BFS实现
        // 记录每个节点的入度
        int[] inCounts = new int[numCourses];
        List<List<Integer>> path = new ArrayList<>();
        for(int i = 0; i < numCourses; i ++) {
            path.add(new ArrayList<Integer>());
        }

        for(int[] req : prerequisites) {
            int in = req[1];
            int out = req[0];
            path.get(in).add(out);
            inCounts[out] ++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++) {
            if(inCounts[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int count = 0;
        while(!queue.isEmpty()) {
            int point = queue.poll();
            // 入度为0的节点先排序
            result[count++] = point;
            List<Integer> list = path.get(point);
            // 针对point的每个节点的入度减一
            for(int j : list) {
                inCounts[j] --;
                if(inCounts[j] == 0) {
                    queue.offer(j);
                }
            }
        }

        if(count == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }

    static class TestCase {
        public static int[] ANS = {0,1};
        public static int NUMCOURSES = 2;
        public static int[][] PREREQUISITES = {{1,0}};

        public static int[] ANS1 = {0, 1, 2, 3};
        public static int NUMCOURSES1 = 4;
        public static int[][] PREREQUISITES1 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    }
}
