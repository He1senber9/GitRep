package club.vann.leetcode.race;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2021/4/5
 * Time: 18:33
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_3 {
    public static void main(String[] args) {
        LeetCode_3 leetCode = new LeetCode_3();
        System.out.println(leetCode.magicTower(TestCase.NUMS));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public int magicTower(int[] nums) {
        int ans = 0;
        long s = 0; // 当前血量
        long w = 0; // 累计扣减血量
        long d = 0;

//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((x,y) -> {
//            return y.compareTo(x);
//        });
        // 存放扣减血量
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int num : nums) {
            if(num > 0) {
                s += num;
            } else {
                // 扣血
                num = -num;
                queue.add(num);
                w += num;

                // 如果当前血量小于累计要扣减的血量
                while(!queue.isEmpty() && s < w) {
                    int v = queue.poll();
                    w -= v;
                    d += v;
                    ans ++;
                }
            }
        }

        return (s >= w + d) ? ans : -1;
    }

    static class TestCase {
        public static int ANS = 1;
        public static int[] NUMS = {100,100,100,-250,-60,-140,-50,-50,100,150};
    }
}
