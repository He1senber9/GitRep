package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：移除最多的同行或同列石头</p>
 * <p>描述：n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 *
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 *
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 解释：一种移除 5 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
 * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
 * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
 * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
 * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
 * 示例 2：
 *
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 解释：一种移除 3 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
 * 2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
 * 3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
 * 示例 3：
 *
 * 输入：stones = [[0,0]]
 * 输出：0
 * 解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。
 *  
 *
 * 提示：
 *
 * 1 <= stones.length <= 1000
 * 0 <= xi, yi <= 104
 * 不会有两块石头放在同一个坐标点上
 * 通过次数5,004提交次数8,981
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_947
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/15 8:30
 */
public class LeetCode_947 {
    public static void main(String[] args) {
        LeetCode_947 leetCode = new LeetCode_947();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.removeStones1(TestCase.STONES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.removeStones1(TestCase.STONES1));
    }

    /**
     * 解法一：
     * dfs 时间复杂度：O(n²)，空间复杂度：O(n²)。
     * @param stones
     * @return
     */
    public int removeStones(int[][] stones) {
        // 总共有n个石头
        int n = stones.length;

        // 记录起止点集合
        List<List<Integer>> path = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            path.add(new ArrayList<Integer>());
            for(int j = 0; j < n; j ++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    path.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int num = 0;
        for(int i = 0; i < n; i ++) {
            if(!visited[i]) {
                num ++;
                dfs(path, visited, i);
            }
        }
        return n - num;
    }

    private void dfs(List<List<Integer>> path, boolean[] visited, int x) {
        visited[x] = true;
        for(int y : path.get(x)) {
            if(!visited[y]) {
                dfs(path, visited, y);
            }
        }
    }

    /**
     * 解法一：
     * 并查集。
     * @param stones
     * @return
     */
    public int removeStones1(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        // n 个石头
        int n = stones.length;
        for(int[] stone : stones) {
            unionFind.union(stone[0], stone[1]+10001);
        }
        return n - unionFind.count;
    }

    private class UnionFind {
        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return;
            }
            parent.put(rootX, rootY);
            count --;
        }

        private int find(int x) {
            if(!parent.containsKey(x)) {
                parent.put(x, x);
                count ++;
            }
            if(x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }
    }

    static class TestCase {
        public static int ANS = 5;
        public static int[][] STONES = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};

        public static int ANS1 = 3;
        public static int[][] STONES1 = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};

        public static int ANS2 = 0;
        public static int[][] STONES2 = {{0, 0}};
    }
}
