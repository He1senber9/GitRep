package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * <p>难度：Hard</p>
 * <p>题目：公交路线</p>
 * <p>描述：给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 *
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 *
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * 示例 2：
 *
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 * 通过次数10,521提交次数30,173
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bus-routes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-28  07:51:00
 */
public class LeetCode_815 {
    public static void main(String[] args) {
        LeetCode_815 leetCode = new LeetCode_815();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.numBusesToDestination1(TestCase.ROUTES, TestCase.SOURCE, TestCase.TARGET));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.numBusesToDestination1(TestCase.ROUTES1, TestCase.SOURCE1, TestCase.TARGET1));
    }

    /**
     * 解法一：
     *
     * @param routes
     * @param source
     * @param target
     * @return
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        Map<Integer, List<Integer>> rec = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = rec.getOrDefault(site, new ArrayList<Integer>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                rec.put(site, list);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> que = new LinkedList<Integer>();
        for (int site : rec.getOrDefault(source, new ArrayList<Integer>())) {
            dis[site] = 1;
            que.offer(site);
        }
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int site : rec.getOrDefault(target, new ArrayList<Integer>())) {
            if (dis[site] != -1) {
                ret = Math.min(ret, dis[site]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    public int numBusesToDestination1(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }

        int n = routes.length;
        // K: 车站， V:该车站经过的公交车
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int bus = 0; bus < n; bus ++) {
            int[] sites = routes[bus];
            for(int site: sites) {
                List<Integer> buses = map.getOrDefault(site, new ArrayList<Integer>());
                buses.add(bus);
                map.put(site, buses);
            }
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(source);

        Set<Integer> vis = new HashSet<>();

        int count = 0;
        while(!linkedList.isEmpty()) {
            count ++;
            int size = linkedList.size();

            // 从当前车站扩展，都是不用换乘的站点
            // 循环结束，没有找到target说明需要换乘一次，count++
            for(int i = 0; i < size; i ++) {
                int curSite = linkedList.poll();

                // 所有经过 curSite 的车
                List<Integer> buses = map.get(curSite);
                for(int bus : buses) {
                    if(vis.contains(bus)) {
                        continue;
                    }

                    vis.add(bus);

                    for(int nextSite : routes[bus]) {
                        if(nextSite == target) {
                            return count;
                        }

                        if(nextSite == curSite) {
                            continue;
                        }

                        linkedList.add(nextSite);
                    }
                }
            }
        }

        return -1;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[][] ROUTES = {{1, 2, 7}, {3, 6, 7}};
        public static int SOURCE = 1;
        public static int TARGET = 6;

        public static int ANS1 = -1;
        public static int[][] ROUTES1 = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        public static int SOURCE1 = 15;
        public static int TARGET1 = 12;
    }
}
