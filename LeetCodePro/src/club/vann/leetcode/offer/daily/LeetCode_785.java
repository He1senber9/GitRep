package club.vann.leetcode.offer.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>难度：Medium</p>
 * <p>题目：判断二分图</p>
 * <p>描述：给定一个无向图graph，当这个图为二分图时返回true。
 *
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 *
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 *
 *
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 *
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 * 注意:
 *
 * graph 的长度范围为 [1, 100]。
 * graph[i] 中的元素的范围为 [0, graph.length - 1]。
 * graph[i] 不会包含 i 或者有重复的值。
 * 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 * 通过次数9,384提交次数20,291
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-16 08:32
 **/
public class LeetCode_785 {
    public static void main(String[] args) {
        LeetCode_785 leetCode = new LeetCode_785();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.isBipartite(TestCase.graph));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.isBipartite(TestCase.graph1));
    }

    /**
     * 解法一：
     * graph[i] i 与元素互斥，即如果存在一个集合P，里面元素包含 i 与 graph[i]中的任意元素，即不能构成二分图
     * @param graph
     * @return
     */
    private boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] dp = new int[len];
        int flag = 1; // 接下来要被染的颜色
        for(int i = 0; i < len; i ++) {
            if(dp[i] == 0 || dp[i] == flag) {
                dp[i] = flag;
                // 对应的元素需要被染成反色
                flag = flag * -1;
                for(int index = 0; index < graph[i].length; index ++) {
                    int point = graph[i][index];
                    if(dp[point] == 0 || dp[point] == flag) {
                        dp[point] = flag;
                        continue;
                    } else {
                        return false;
                    }
                }
                flag = flag * -1;
            } else {
                return false;
            }
        }
        return true;
    }

    static class TestCase {
        public static boolean ans = true;
        public static int[][] graph = {{1,3},{0,2},{1,3},{0,2}};

        public static boolean ans1 = false;
        public static int[][] graph1 = {{1,2,3},{0,2},{0,1,3},{0,2}};
    }
}
