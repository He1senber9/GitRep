package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：所有可能的路径</p>
 * <p>描述：给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 *
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 *
 *
 *
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * 示例 3：
 *
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 * 示例 4：
 *
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 * 示例 5：
 *
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 *  
 *
 * 提示：
 *
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即，不存在自环）
 * graph[i] 中的所有元素 互不相同
 * 保证输入为 有向无环图（DAG）
 * 通过次数18,978提交次数25,140
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-08-25  08:25:11
 */
public class LeetCode_797 {
    public static void main(String[] args) {
        LeetCode_797 leetCode = new LeetCode_797();

        List<List<Integer>> result = null;
        result = leetCode.allPathsSourceTarget(TestCase.GRAPH);
        result = leetCode.allPathsSourceTarget(TestCase.GRAPH1);
        result = leetCode.allPathsSourceTarget(TestCase.GRAPH2);
        result = leetCode.allPathsSourceTarget(TestCase.GRAPH3);
        result = leetCode.allPathsSourceTarget(TestCase.GRAPH4);
        System.out.println();
    }

    /**
     * 解法一：
     *
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);

        dfs(paths, linkedList, graph, 0, graph.length-1);

        return paths;
    }

    private void dfs(List<List<Integer>> paths, LinkedList<Integer> linkedList, int[][] graph, int x, int n) {
        if (x == n) {
            paths.add(new ArrayList<Integer>(linkedList));
            return;
        }

        for(int y : graph[x]) {
            linkedList.addLast(y);
            dfs(paths, linkedList, graph, y, n);
            linkedList.pollLast();
        }
    }

    static class TestCase {
        public static int[][] GRAPH = {{1, 2}, {3}, {3}, {}};
        public static int[][] GRAPH1 = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        public static int[][] GRAPH2 = {{1}, {}};
        public static int[][] GRAPH3 = {{1, 2, 3}, {2}, {3}, {}};
        public static int[][] GRAPH4 = {{1, 3}, {2}, {3}, {}};
    }
}
