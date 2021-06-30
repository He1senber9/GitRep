package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>难度：Easy</p>
 * <p>题目：传递信息</p>
 * <p>描述：小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 *
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 *
 * 示例 1：
 *
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 *
 * 输出：3
 *
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 *
 * 示例 2：
 *
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 *
 * 输出：0
 *
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 *
 * 限制：
 *
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 * 通过次数10,153提交次数15,253
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-07-01  07:18:01
 */
public class LeetCode_LCP07 {
    public static void main(String[] args) {
        LeetCode_LCP07 leetCode = new LeetCode_LCP07();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.numWays(TestCase.N, TestCase.RELATION, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.numWays(TestCase.N1, TestCase.RELATION1, TestCase.K1));
    }

    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> path = new HashMap<>();
        for(int[] rela : relation) {
            int cur = rela[0];
            int next = rela[1];
            List<Integer> list = path.getOrDefault(cur, new ArrayList<Integer>());
            list.add(next);
            path.put(cur, list);
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.offer(0);

        List<Integer> list = new ArrayList<>();
        int step = 0;
        while(!linkedList.isEmpty()) {
            step ++;
            int size = linkedList.size();
            int count = 0;
            for(int i = 0; i < size; i ++) {
                int cur = linkedList.pollFirst();

                List<Integer> nexts = path.get(cur);
                if(nexts == null) {
                    continue;
                }
                for(int j = 0; j < nexts.size(); j ++) {
                    linkedList.addLast(nexts.get(j));
                    if(nexts.get(j) == n-1) {
                        count ++;
                    }
                }
            }

            if(step == k) {
                return count;
            }
        }
        return 0;
    }

    static class TestCase {
        public static int ANS = 3;
        public static int N = 5;
        public static int[][] RELATION = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        public static int K = 3;

        public static int ANS1 = 0;
        public static int N1 = 3;
        public static int[][] RELATION1 = {{0, 2}, {2, 1}};
        public static int K1 = 2;
    }
}
