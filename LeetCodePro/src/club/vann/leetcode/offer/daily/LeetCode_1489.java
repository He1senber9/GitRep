package club.vann.leetcode.offer.daily;

import java.util.List;

/**
 * @ClassName LeetCode_1489
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/21 8:25
 */
public class LeetCode_1489 {
    public static void main(String[] args) {
        LeetCode_1489 leetCode = new LeetCode_1489();


    }

    /**
     * 解法一：
     *
     * @param n
     * @param edges
     * @return
     */
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        return null;
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
