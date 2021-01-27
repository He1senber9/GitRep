package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Hard</p>
 * <p>题目：保证图可完全遍历</p>
 * <p>描述：Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
 *
 * 类型 1：只能由 Alice 遍历。
 * 类型 2：只能由 Bob 遍历。
 * 类型 3：Alice 和 Bob 都可以遍历。
 * 给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
 *
 * 返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
 * 输出：2
 * 解释：如果删除 [1,1,2] 和 [1,1,3] 这两条边，Alice 和 Bob 仍然可以完全遍历这个图。再删除任何其他的边都无法保证图可以完全遍历。所以可以删除的最大边数是 2 。
 * 示例 2：
 *
 *
 *
 * 输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
 * 输出：0
 * 解释：注意，删除任何一条边都会使 Alice 和 Bob 无法完全遍历这个图。
 * 示例 3：
 *
 *
 *
 * 输入：n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
 * 输出：-1
 * 解释：在当前图中，Alice 无法从其他节点到达节点 4 。类似地，Bob 也不能达到节点 1 。因此，图无法完全遍历。
 *  
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 * 1 <= edges.length <= min(10^5, 3 * n * (n-1) / 2)
 * edges[i].length == 3
 * 1 <= edges[i][0] <= 3
 * 1 <= edges[i][1] < edges[i][2] <= n
 * 所有元组 (typei, ui, vi) 互不相同
 * 通过次数2,819提交次数5,508
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2021/1/27
 * Time: 8:52
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1579 {
    public static void main(String[] args) {
        LeetCode_1579 leetCode = new LeetCode_1579();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxNumEdgesToRemove(TestCase.N, TestCase.EDGES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxNumEdgesToRemove(TestCase.N1, TestCase.EDGES1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxNumEdgesToRemove(TestCase.N2, TestCase.EDGES2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.maxNumEdgesToRemove(TestCase.N3, TestCase.EDGES3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.maxNumEdgesToRemove(TestCase.N4, TestCase.EDGES4));
    }

    /**
     * 解法一：
     * 答案是A可以删除的边+B可以删除的边。
     *
     * @param n
     * @param edges
     * @return
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionUtil unionUtilA = new UnionUtil(n+1);
        UnionUtil unionUtilB = new UnionUtil(n+1);

        int count = 0;
        // 先处理公共边
        for(int[] edge : edges) {
            int type = edge[0];
            int x = edge[1];
            int y = edge[2];

            if(type != 3) {
                continue;
            }

            // 如果该公共边连接的两个点已经连通，则可以删除。
            if(unionUtilA.find(x) == unionUtilA.find(y)) {
                count ++;
            } else {
                unionUtilA.union(x, y);
                unionUtilB.union(x, y);
            }
        }

        // 在处理独占边
        for(int[] edge : edges) {
            int type = edge[0];
            int x = edge[1];
            int y = edge[2];

            if(type == 1) {
                if(unionUtilA.find(x) == unionUtilA.find(y)) {
                    // 这两个点已经合并过了
                    count ++;
                } else {
//                    unionUtilA.union(x, y);
                }
            } else if(type == 2) {
                if(unionUtilB.find(x) == unionUtilB.find(y)) {
                    // 这两个点已经合并过了
                    count ++;
                } else {
//                    unionUtilB.union(x, y);
                }
            }
        }

        // 判断A、B本身是否能连通
        if(unionUtilA.count != 2 || unionUtilB.count != 2) {
            return -1;
        }
        return count;
    }

    /**
     * 解法二：
     * @param n
     * @param edges
     * @return
     */
    public int maxNumEdgesToRemove1(int n, int[][] edges) {
        UnionFind ufa = new UnionFind(n);
        UnionFind ufb = new UnionFind(n);
        int ans = 0;

        // 节点编号改为从 0 开始
        for (int[] edge : edges) {
            --edge[1];
            --edge[2];
        }

        // 公共边
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!ufa.unite(edge[1], edge[2])) {
                    ++ans;
                } else {
                    ufb.unite(edge[1], edge[2]);
                }
            }
        }

        // 独占边
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                // Alice 独占边
                if (!ufa.unite(edge[1], edge[2])) {
                    ++ans;
                }
            } else if (edge[0] == 2) {
                // Bob 独占边
                if (!ufb.unite(edge[1], edge[2])) {
                    ++ans;
                }
            }
        }

        if (ufa.setCount != 1 || ufb.setCount != 1) {
            return -1;
        }
        return ans;
    }

    class UnionUtil {
        int[] parent;
        int count;

        public UnionUtil(int n) {
            parent = new int[n];
            count = n;
            for(int i = 0; i < n; i ++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            count --;
        }

        private int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    static class TestCase {
        public static int ANS = 2;
        public static int N = 4;
        public static int[][] EDGES = {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};

        public static int ANS1 = 0;
        public static int N1 = 4;
        public static int[][] EDGES1 = {{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}};

        public static int ANS2 = -1;
        public static int N2 = 4;
        public static int[][] EDGES2 = {{3, 2, 3}, {1, 1, 2}, {2, 3, 4}};

        public static int ANS3 = 2;
        public static int N3 = 2;
        public static int[][] EDGES3 = {{1, 1, 2}, {2, 1, 2}, {3, 1, 2}};

        public static int ANS4 = 114;
        public static int N4 = 13;
        public static int[][] EDGES4 = {{1,1,2},{2,1,3},{3,2,4},{3,2,5},{1,2,6},{3,6,7},{3,7,8},{3,6,9},{3,4,10},{2,3,11},{1,5,12},{3,3,13},{2,1,10},{2,6,11},{3,5,13},{1,9,12},{1,6,8},{3,6,13},{2,1,4},{1,1,13},{2,9,10},{2,1,6},{2,10,13},{2,2,9},{3,4,12},{2,4,7},{1,1,10},{1,3,7},{1,7,11},{3,3,12},{2,4,8},{3,8,9},{1,9,13},{2,4,10},{1,6,9},{3,10,13},{1,7,10},{1,1,11},{2,4,9},{3,5,11},{3,2,6},{2,1,5},{2,5,11},{2,1,7},{2,3,8},{2,8,9},{3,4,13},{3,3,8},{3,3,11},{2,9,11},{3,1,8},{2,1,8},{3,8,13},{2,10,11},{3,1,5},{1,10,11},{1,7,12},{2,3,5},{3,1,13},{2,4,11},{2,3,9},{2,6,9},{2,1,13},{3,1,12},{2,7,8},{2,5,6},{3,1,9},{1,5,10},{3,2,13},{2,3,6},{2,2,10},{3,4,11},{1,4,13},{3,5,10},{1,4,10},{1,1,8},{3,3,4},{2,4,6},{2,7,11},{2,7,10},{2,3,12},{3,7,11},{3,9,10},{2,11,13},{1,1,12},{2,10,12},{1,7,13},{1,4,11},{2,4,5},{1,3,10},{2,12,13},{3,3,10},{1,6,12},{3,6,10},{1,3,4},{2,7,9},{1,3,11},{2,2,8},{1,2,8},{1,11,13},{1,2,13},{2,2,6},{1,4,6},{1,6,11},{3,1,2},{1,1,3},{2,11,12},{3,2,11},{1,9,10},{2,6,12},{3,1,7},{1,4,9},{1,10,12},{2,6,13},{2,2,12},{2,1,11},{2,5,9},{1,3,8},{1,7,8},{1,2,12},{1,5,11},{2,7,12},{3,1,11},{3,9,12},{3,2,9},{3,10,11}};

    }
}

// 并查集模板
class UnionFind {
    int[] parent;
    int[] size;
    int n;
    // 当前连通分量数目
    int setCount;

    public UnionFind(int n) {
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int findset(int x) {
        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
    }

    public boolean unite(int x, int y) {
        x = findset(x);
        y = findset(y);
        if (x == y) {
            return false;
        }
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
        --setCount;
        return true;
    }

    public boolean connected(int x, int y) {
        x = findset(x);
        y = findset(y);
        return x == y;
    }
}
