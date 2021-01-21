package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>难度：Hard</p>
 * <p>题目：找到最小生成树里的关键边和伪关键边</p>
 * <p>描述：给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，其中 edges[i] = [fromi, toi, weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。
 *
 * 请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
 *
 * 请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
 * 输出：[[0,1],[2,3,4,5]]
 * 解释：上图描述了给定图。
 * 下图是所有的最小生成树。
 *
 * 注意到第 0 条边和第 1 条边出现在了所有最小生成树中，所以它们是关键边，我们将这两个下标作为输出的第一个列表。
 * 边 2，3，4 和 5 是所有 MST 的剩余边，所以它们是伪关键边。我们将它们作为输出的第二个列表。
 * 示例 2 ：
 *
 *
 *
 * 输入：n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]
 * 输出：[[],[0,1,2,3]]
 * 解释：可以观察到 4 条边都有相同的权值，任选它们中的 3 条可以形成一棵 MST 。所以 4 条边都是伪关键边。
 *  
 *
 * 提示：
 *
 * 2 <= n <= 100
 * 1 <= edges.length <= min(200, n * (n - 1) / 2)
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti <= 1000
 * 所有 (fromi, toi) 数对都是互不相同的。
 * 通过次数1,553提交次数2,742
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_1489
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/21 8:25
 */
public class LeetCode_1489 {
    public static void main(String[] args) {
        LeetCode_1489 leetCode = new LeetCode_1489();

        List<List<Integer>> res = null;

        res = leetCode.findCriticalAndPseudoCriticalEdges(TestCase.N, TestCase.EDGES);
        res = leetCode.findCriticalAndPseudoCriticalEdges(TestCase.N1, TestCase.EDGES1);

        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param n
     * @param edges
     * @return
     */
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // 1.先映射边与序号的关系
        int edges_len = edges.length;
        int[][] new_edges = new int[edges_len][4];
        for(int i = 0; i < edges_len; i ++) {
            for(int j = 0; j < 3; j ++) {
                new_edges[i][j] = edges[i][j];
            }
            new_edges[i][3] = i;
        }

        // 2.将边按照权重排序
        Arrays.sort(new_edges, (x, y) -> {
            return x[2]-y[2];
        });

        UnionUtil unionUtil = new UnionUtil(n);
        // 3.求构成最小生成树的value
        int minValue = 0;
        for(int i = 0; i < edges_len; i ++) {
            int from = new_edges[i][0];
            int to = new_edges[i][1];
            int weight = new_edges[i][2];
            int index = new_edges[i][3];

            int rootFrom = unionUtil.find(from);
            int rootTo = unionUtil.find(to);
            if(rootFrom == rootTo) {
                continue;
            }

            unionUtil.union(from, to);
            minValue += weight;
        }

        List<List<Integer>> rest = new ArrayList<>();
        rest.add(new ArrayList<>()); // 关键边集合
        rest.add(new ArrayList<>()); // 伪关键边集合

        // 4.遍历每一条边，判断是否是关键边
        for(int i = 0; i < edges_len; i ++) {
            UnionUtil unionUtilNew = new UnionUtil(n);
            int value = 0;
            for(int j = 0; j < edges_len; j ++) {
                int rootFrom = unionUtilNew.find(new_edges[j][0]);
                int rootTo = unionUtilNew.find(new_edges[j][1]);
                int weight = new_edges[j][2];
                // 排除当前边 i
                if(i != j && rootFrom != rootTo) {
                    unionUtilNew.union(new_edges[j][0], new_edges[j][1]);
                    value += weight;
                }
            }

            // 排除当前边 i 构建最小生成树后，如果最终导致出现了两个树，或者生成的最小树权值大于value，则证明当前边是关键边
            if (unionUtilNew.count != 1 || (unionUtilNew.count == 1 && value > minValue)) {
                rest.get(0).add(new_edges[i][3]);
                continue;
            }

            // 判断是否是伪关键边
            unionUtilNew = new UnionUtil(n);
            unionUtilNew.union(new_edges[i][0], new_edges[i][1]);
            value = new_edges[i][2];
            for (int j = 0; j < edges_len; ++j) {
                int rootFrom = unionUtilNew.find(new_edges[j][0]);
                int rootTo = unionUtilNew.find(new_edges[j][1]);
                if (i != j && rootFrom != rootTo) {
                    unionUtilNew.union(new_edges[j][0], new_edges[j][1]);
                    value += new_edges[j][2];
                }
            }

            // 如果排除当前边后，还能构成最小生成树
            if (value == minValue) {
                rest.get(1).add(new_edges[i][3]);
            }
        }

        return rest;
    }

    /**
     * 并查集辅助工具类。
     *
     */
    public class UnionUtil {
        int[] parent;
        // 当前连通分量数目
        int count;
        public UnionUtil(int n) {
            this.count = n;
            parent = new int[n];
            for(int i=0; i < n; i ++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return;
            }
            this.count --;
            parent[rootX] = rootY;
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }
    }

    static class TestCase {
        public static int[][] ANS = {{0,1}, {2,3,4,5}};
        public static int N = 5;
        public static int[][] EDGES = {{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}};

        public static int[][] ANS1 = {{}, {0,1,2,3}};
        public static int N1 = 4;
        public static int[][] EDGES1 = {{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {0, 3, 1}};
    }
}
