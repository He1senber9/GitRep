package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Medium</p>
 * <p>题目：冗余链接</p>
 * <p>描述：在本问题中, 树指的是一个连通且无环的无向图。
 *
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 *
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 *
 * 示例 1：
 *
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 *   1
 *  / \
 * 2 - 3
 * 示例 2：
 *
 * 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * 解释: 给定的无向图为:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * 注意:
 *
 * 输入的二维数组大小在 3 到 1000。
 * 二维数组中的整数在1到N之间，其中N是输入数组的大小。
 * 更新(2017-09-26):
 * 我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。
 *
 * 通过次数26,249提交次数41,821
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_684
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/13 8:34
 */
public class LeetCode_684 {
    public static void main(String[] args) {
        LeetCode_684 leetCode = new LeetCode_684();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.findRedundantConnection1(TestCase.EDGES)));
        System.out.println("Result["+Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.findRedundantConnection1(TestCase.EDGES1)));
        System.out.println("Result["+Arrays.toString(TestCase.ANS2)+"] : " + Arrays.toString(leetCode.findRedundantConnection1(TestCase.EDGES2)));
    }

    /**
     * 解法一：
     * 采用bfs。
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // 统计边关系。
        List<List<Integer>> path = new ArrayList<>();
        for(int i = 0; i < n+1; i ++) {
            path.add(new ArrayList<Integer>());
        }
        // 分析题意：要删除的是属于环形的边，如果有多个，那就删除的是出现最晚的那一条。
        int[] inCounts = new int[n+1];
        for(int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            inCounts[start] ++;
            inCounts[end] ++;
            path.get(start).add(end);
            path.get(end).add(start);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n+1; i ++) {
            if(inCounts[i] == 1) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int point = queue.poll();
            inCounts[point] --;
            List<Integer> ends = path.get(point);
            for(int end : ends) {
                inCounts[end] --;
                if(inCounts[end] == 1) {
                    queue.offer(end);
                }
            }
        }

        // 经过上一步处理后剩下的节点组成环形。
        // 需要看剩下环形的边在入参中出现的顺序，取最后一个出现的即可
        int index = 0;
        for(int i = 1; i <= n; i ++) {
            if(inCounts[i] != 2) {
                continue;
            }

            int start = i;
            int end = i;
            List<Integer> ends = path.get(start);
            for(int j : ends) {
                if(inCounts[j] == 0) {
                    continue;
                }
                end = j;

                for(int t = 0; t < n; t ++) {
                    if((start == edges[t][0] && end == edges[t][1]) || (start == edges[t][1] && end == edges[t][0])) {
                        index = Math.max(index, t);
                    }
                }
            }


        }
        return edges[index];
    }

    /**
     * 解法二：
     * 采用并查集。
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection1(int[][] edges) {
        int n = edges.length;
        // 有 n 个顶点，初始每个顶点属于不同的连通分量
        int[] parent = new int[n+1];
        for(int i = 0; i <= n; i ++) {
            parent[i] = i;
        }

        for(int i = 0; i < n; i ++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int rootX = find(parent, x);
            int rootY = find(parent, y);
            if(rootX != rootY) {
                union(parent, x, y);
            } else {
                return edges[i];
            }
        }
        return null;
    }

    /**
     * 合并顶点的连通分量。
     * @param parent
     * @param x
     * @param y
     */
    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if(rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    private int find(int[] parent, int x) {
        if(x != parent[x]) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    static class TestCase {
        public static int[] ANS = {2,3};
        public static int[][] EDGES = {{1,2},{1,3},{2,3}};

        public static int[] ANS1 = {1,4};
        public static int[][] EDGES1 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};

        public static int[] ANS2 = {4,10};
        public static int[][] EDGES2 = {{9, 10}, {5, 8}, {2, 6}, {1, 5}, {3, 8}, {4, 9}, {8, 10}, {4, 10}, {6, 8}, {7, 9}};
    }
}
