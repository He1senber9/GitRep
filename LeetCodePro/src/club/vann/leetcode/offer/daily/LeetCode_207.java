package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>难度：Meidum</p>
 * <p>题目：课程表</p>
 * <p>描述：你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *  
 *
 * 提示：
 *
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 * 通过次数88,525提交次数161,981
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_207
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/12 10:10
 */
public class LeetCode_207 {
    public static void main(String[] args) {
        LeetCode_207 leetCode = new LeetCode_207();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.canFinish(TestCase.NUM, TestCase.PREREQUISITES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.canFinish(TestCase.NUM1, TestCase.PREREQUISITES1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.canFinish(TestCase.NUM2, TestCase.PREREQUISITES2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.canFinish(TestCase.NUM3, TestCase.PREREQUISITES3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.canFinish(TestCase.NUM4, TestCase.PREREQUISITES4));
    }

    /**
     * 解法一：
     * 深度优先搜索。
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 标志每个节点的访问状态，0：未访问；1：访问中；2：访问完成
        int[] visited = new int[numCourses];

        // 记录有向边关系
        List<List<Integer>> path = new ArrayList<>();
        for(int i = 0; i < numCourses; i ++) {
            path.add(new ArrayList<>());
        }

        for(int[] req : prerequisites) {
            int start = req[1];
            int end = req[0];
            path.get(start).add(end);
        }

        boolean result = true;
        for(int i = 0; i < numCourses; i ++) {
            if(visited[i] == 0) {
                result = (result && dfs(path, visited, i));
            }
        }
        return result;
    }

    private boolean dfs(List<List<Integer>> path, int[] visited, int start) {
        // 当前节点标志为访问中
        visited[start] = 1;
        List<Integer> list = path.get(start);
        for(int end : list) {
            if(visited[end] == 0) {
                boolean flag = dfs(path, visited, end);
                if(!flag) {
                    return false;
                }
            } else if(visited[end] == 1) {
                return false;
            }
        }
        visited[start] = 2;
        return true;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int NUM = 2;
        public static int[][] PREREQUISITES = {{1,0}};

        public static boolean ANS1 = false;
        public static int NUM1 = 2;
        public static int[][] PREREQUISITES1 = {{1,0},{0,1}};

        public static boolean ANS2 = true;
        public static int NUM2 = 2;
        public static int[][] PREREQUISITES2 = {{0,1}};

        public static boolean ANS3 = true;
        public static int NUM3 = 4;
        public static int[][] PREREQUISITES3 = {{3,0},{0,1}};

        public static boolean ANS4 = false;
        public static int NUM4 = 3;
        public static int[][] PREREQUISITES4 = {{1,0},{2,0},{0,2}};
    }
}
