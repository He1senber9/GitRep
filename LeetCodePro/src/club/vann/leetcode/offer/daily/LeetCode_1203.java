package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Hard</p>
 * <p>题目：项目管理</p>
 * <p>描述：公司共有 n 个项目和  m 个小组，每个项目要不无人接手，要不就由 m 个小组之一负责。
 *
 * group[i] 表示第 i 个项目所属的小组，如果这个项目目前无人接手，那么 group[i] 就等于 -1。（项目和小组都是从零开始编号的）小组可能存在没有接手任何项目的情况。
 *
 * 请你帮忙按要求安排这些项目的进度，并返回排序后的项目列表：
 *
 * 同一小组的项目，排序后在列表中彼此相邻。
 * 项目之间存在一定的依赖关系，我们用一个列表 beforeItems 来表示，其中 beforeItems[i] 表示在进行第 i 个项目前（位于第 i 个项目左侧）应该完成的所有项目。
 * 如果存在多个解决方案，只需要返回其中任意一个即可。如果没有合适的解决方案，就请返回一个 空列表 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
 * 输出：[6,3,4,1,5,2,0,7]
 * 示例 2：
 *
 * 输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]
 * 输出：[]
 * 解释：与示例 1 大致相同，但是在排序后的列表中，4 必须放在 6 的前面。
 *  
 *
 * 提示：
 *
 * 1 <= m <= n <= 3 * 104
 * group.length == beforeItems.length == n
 * -1 <= group[i] <= m - 1
 * 0 <= beforeItems[i].length <= n - 1
 * 0 <= beforeItems[i][j] <= n - 1
 * i != beforeItems[i][j]
 * beforeItems[i] 不含重复元素
 * 通过次数2,076提交次数4,499
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-items-by-groups-respecting-dependencies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_1203
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/12 9:07
 */
public class LeetCode_1203 {

    public static void main(String[] args) {
        LeetCode_1203 leetCode = new LeetCode_1203();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] :" + Arrays.toString(leetCode.sortItems(TestCase.N, TestCase.M, TestCase.GROUP, TestCase.BEFOREITEMS)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] :" + Arrays.toString(leetCode.sortItems(TestCase.N1, TestCase.M1, TestCase.GROUP1, TestCase.BEFOREITEMS1)));
    }

    /**
     * 解法一：
     *
     * @param n
     * @param m
     * @param group
     * @param beforeItems
     * @return
     */
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> groupItem = new ArrayList<List<Integer>>();
        for (int i = 0; i < n + m; ++i) {
            groupItem.add(new ArrayList<Integer>());
        }

        // 组间和组内依赖图
        List<List<Integer>> groupGraph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n + m; ++i) {
            groupGraph.add(new ArrayList<Integer>());
        }
        List<List<Integer>> itemGraph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            itemGraph.add(new ArrayList<Integer>());
        }

        // 组间和组内入度数组
        int[] groupDegree = new int[n + m];
        int[] itemDegree = new int[n];

        List<Integer> id = new ArrayList<Integer>();
        for (int i = 0; i < n + m; ++i) {
            id.add(i);
        }

        int leftId = m;
        // 给未分配的 item 分配一个 groupId
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = leftId;
                leftId += 1;
            }
            groupItem.get(group[i]).add(i);
        }
        // 依赖关系建图
        for (int i = 0; i < n; ++i) {
            int curGroupId = group[i];
            for (int item : beforeItems.get(i)) {
                int beforeGroupId = group[item];
                if (beforeGroupId == curGroupId) {
                    itemDegree[i] += 1;
                    itemGraph.get(item).add(i);
                } else {
                    groupDegree[curGroupId] += 1;
                    groupGraph.get(beforeGroupId).add(curGroupId);
                }
            }
        }

        // 组间拓扑关系排序
        List<Integer> groupTopSort = topSort(groupDegree, groupGraph, id);
        if (groupTopSort.size() == 0) {
            return new int[0];
        }
        int[] ans = new int[n];
        int index = 0;
        // 组内拓扑关系排序
        for (int curGroupId : groupTopSort) {
            int size = groupItem.get(curGroupId).size();
            if (size == 0) {
                continue;
            }
            List<Integer> res = topSort(itemDegree, itemGraph, groupItem.get(curGroupId));
            if (res.size() == 0) {
                return new int[0];
            }
            for (int item : res) {
                ans[index++] = item;
            }
        }
        return ans;
    }

    private List<Integer> topSort(int[] degree, List<List<Integer>> graph, List<Integer> items) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int item : items) {
            if (degree[item] == 0) {
                queue.offer(item);
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            res.add(u);
            for (int v : graph.get(u)) {
                if (--degree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return res.size() == items.size() ? res : new ArrayList<Integer>();
    }

    static class TestCase {
        public static int[] ANS = {6,3,4,1,5,2,0,7};
        public static int N = 8;
        public static int M = 2;
        public static int[] GROUP = {-1,-1,1,0,0,1,0,-1};
        public static List<List<Integer>> BEFOREITEMS = fun("[[],[6],[5],[6],[3,6],[],[],[]]");

        public static int[] ANS1 = {};
        public static int N1 = 8;
        public static int M1 = 2;
        public static int[] GROUP1 = {-1,-1,1,0,0,1,0,-1};
        public static List<List<Integer>> BEFOREITEMS1 = fun("[[],[6],[5],[6],[3],[],[4],[]]");


        private static List<List<Integer>> fun(String str) {
            List<List<Integer>> res = new ArrayList<>();
            String TEMP = str;
            TEMP = TEMP.substring(1, TEMP.length()-1).trim();
            int left = 0, right = 0;
            int len = TEMP.length();
            while(right < len && left <= right) {
                if(TEMP.charAt(left) == '[') {
                    if(TEMP.charAt(right) == ']') {
                        List<Integer> list = new ArrayList<>();
                        if(right - left == 1) {
                            res.add(list);
                            right ++;
                            left = right;
                            continue;
                        }

                        String subStr = TEMP.substring(left+1, right).trim();
                        String[] strs = subStr.split(",");
                        for(String item : strs) {
                            list.add(Integer.valueOf(item.trim()));
                        }
                        res.add(list);
                        right ++;
                        left = right;
                    } else {
                        right ++;
                    }
                } else {
                    left ++;
                    right ++;
                }
            }
            return res;
        }
    }
}
