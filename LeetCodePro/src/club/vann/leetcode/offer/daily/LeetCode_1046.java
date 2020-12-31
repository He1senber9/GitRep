package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>难度：Easy</p>
 * <p>题目：最后一块石头的重量</p>
 * <p>描述：有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *  
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * 通过次数27,366提交次数43,891
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-12-30 11:02
 **/
public class LeetCode_1046 {
    public static void main(String[] args) {
        LeetCode_1046 leetCode = new LeetCode_1046();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.lastStoneWeight(TestCase.STONES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.lastStoneWeight(TestCase.STONES1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.lastStoneWeight(TestCase.STONES2));
    }

    /**
     * 解法一：
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((x,y) -> {return y-x;});
        int len = stones.length;
        for(int i = 0; i < len; i ++) {
            queue.offer(stones[i]);
        }

        int x = 0, y = 0;
        while(!queue.isEmpty() && queue.size() >= 2) {
            y = queue.poll();
            x = queue.poll();

            if(x == y) {
                continue;
            } else {
                queue.offer(y-x);
            }
        }
        
        return queue.isEmpty() ? 0 : queue.poll();
    }

    static class TestCase {
        public static int ANS = 1;
        public static int[] STONES = {2,7,4,1,8,1};

        public static int ANS1 = 1;
        public static int[] STONES1 = {1};

        public static int ANS2 = 0;
        public static int[] STONES2 = {1,1};
    }
}
