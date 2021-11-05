package club.vann.leetcode.race.race20210704;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-07-04  11:48:53
 */
public class LeetCode_5801 {
    public static void main(String[] args) {
        LeetCode_5801 leetCode = new LeetCode_5801();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.eliminateMaximum(TestCase.DIST, TestCase.SPEED));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.eliminateMaximum(TestCase.DIST1, TestCase.SPEED1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.eliminateMaximum(TestCase.DIST2, TestCase.SPEED2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.eliminateMaximum(TestCase.DIST3, TestCase.SPEED3));
    }

    /**
     * 解法一：
     *
     * @param dist
     * @param speed
     * @return
     */
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        // 优先消灭距离最近的怪物
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.dis - o2.dis;
            }
        });

        PriorityQueue<Pair> tmp = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.dis - o2.dis;
            }
        });

        for(int i = 0; i < n; i ++) {
            queue.add(new Pair(i, dist[i]));
        }

        int res = 0;
        while(!queue.isEmpty()) {

            Pair pair = queue.poll();
            int i = pair.index;
            int dis = pair.dis;

            if(dis <= 0) {
                return res;
            }

            while(!queue.isEmpty()) {
                Pair next = queue.poll();
                int nextI = next.index;
                int nextDis = next.dis;

                if(nextDis <= 0) {
                    return res;
                }

                tmp.add(new Pair(nextI, nextDis-speed[nextI]));
            }

            while(!tmp.isEmpty()) {
                queue.add(tmp.poll());
            }

            res ++;
        }

        return n;
    }

    class Pair {
        int index;
        int dis;

        public Pair(int index, int dis) {
            this.index = index;
            this.dis = dis;
        }
    }

    static class TestCase {
        public static int ANS = 3;
        public static int[] DIST = {1,3,4};
        public static int[] SPEED = {1,1,1};

        public static int ANS1 = 1;
        public static int[] DIST1 = {1,1,2,3};
        public static int[] SPEED1 = {1,1,1,1};

        public static int ANS2 = 1;
        public static int[] DIST2 = {3,2,4};
        public static int[] SPEED2 = {5,3,2};

        public static int ANS3 = 3;
        public static int[] DIST3 = {4,2,3};
        public static int[] SPEED3 = {2,1,1};
    }
}
