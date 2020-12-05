package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <p>难度：Meidum</p>
 * <p>题目：分割数组为连续子序列</p>
 * <p>描述：给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 *
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *  
 *
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *  
 *
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *  
 *
 * 提示：
 *
 * 输入的数组长度范围为 [1, 10000]
 *  
 *
 * 通过次数6,513提交次数14,291
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-12-04 17:54
 **/
public class LeetCode_659 {
    public static void main(String[] args) {
        LeetCode_659 leetCode = new LeetCode_659();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.isPossible(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.isPossible(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.isPossible(TestCase.NUMS2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.isPossible(TestCase.NUMS3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.isPossible(TestCase.NUMS4));
    }

    /**
     *  解法一：
     *  哈希表+最小堆
     *  时间复杂度：O(nlogn)，空间复杂度：O(n)
     *
     *  哈希表的键为子序列的最后一个数字，值为最小堆，用于存储所有的子序列长度，最小堆满足堆顶的元素是最小的，因此堆顶的元素即为最小的子序列长度。
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int n : nums) {
            if(!map.containsKey(n)) {
                map.put(n, new PriorityQueue<>());
            }

            if(map.containsKey(n-1)) {
                int prevLength = map.get(n - 1).poll();
                if (map.get(n - 1).isEmpty()) {
                    map.remove(n - 1);
                }
                map.get(n).offer(prevLength + 1);
            } else {
                map.get(n).offer(1);
            }
        }

        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }

    /**
     * 解法二：
     *  贪心算法
     *  使用两个哈希表，第一个哈希表存储数组中的每个数字的剩余次数，第二个哈希表存储数组中的每个数字作为结尾的子序列的数量。
     *
     * 初始时，每个数字的剩余次数即为每个数字在数组中出现的次数，因此遍历数组，初始化第一个哈希表。
     *
     * 在初始化第一个哈希表之后，遍历数组，更新两个哈希表。只有当一个数字的剩余次数大于 00 时，才需要考虑这个数字是否属于某个子序列。假设当前元素是 xx，进行如下操作。
     *
     * 首先判断是否存在以 x-1x−1 结尾的子序列，即根据第二个哈希表判断 x-1x−1 作为结尾的子序列的数量是否大于 00，如果大于 00，则将元素 xx 加入该子序列中。由于 xx 被使用了一次，因此需要在第一个哈希表中将 xx 的剩余次数减 11。又由于该子序列的最后一个数字从 x-1x−1 变成了 xx，因此需要在第二个哈希表中将 x-1x−1 作为结尾的子序列的数量减 11，以及将 xx 作为结尾的子序列的数量加 11。
     *
     * 否则，xx 为一个子序列的第一个数，为了得到长度至少为 33 的子序列，x+1x+1 和 x+2x+2 必须在子序列中，因此需要判断在第一个哈希表中 x+1x+1 和 x+2x+2 的剩余次数是否都大于 00。
     *
     * 当 x+1x+1 和 x+2x+2 的剩余次数都大于 00 时，可以新建一个长度为 33 的子序列 [x,x+1,x+2][x,x+1,x+2]。由于这三个数都被使用了一次，因此需要在第一个哈希表中将这三个数的剩余次数分别减 11。又由于该子序列的最后一个数字是 x+2x+2，因此需要在第二个哈希表中将 x+2x+2 作为结尾的子序列的数量加 11。
     *
     * 否则，无法得到长度为 33 的子序列 [x,x+1,x+2][x,x+1,x+2]，因此无法完成分割，返回 \text{false}false。
     *
     * 如果整个数组遍历结束时，没有遇到无法完成分割的情况，则可以完成分割，返回 \text{true}true。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/solution/fen-ge-shu-zu-wei-lian-xu-zi-xu-lie-by-l-lbs5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public boolean isPossible1(int[] nums) {
        return false;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] NUMS = {1,2,3,3,4,5};

        public static boolean ANS1 = true;
        public static int[] NUMS1 = {1,2,3,3,4,4,5,5};

        public static boolean ANS2 = false;
        public static int[] NUMS2 = {1,2,3,4,4,5};

        public static boolean ANS3 = true;
        public static int[] NUMS3 = {1,2,3,6,7,8};

        public static boolean ANS4 = false;
        public static int[] NUMS4 = {1,2,3,6,7};

        public static boolean ANS5 = true;
        public static int[] NUMS5 = {1,1,2,2,3,3};

        public static boolean ANS6 = true;
        public static int[] NUMS6 = {1,1,2,2,3,3,4};
    }
}
