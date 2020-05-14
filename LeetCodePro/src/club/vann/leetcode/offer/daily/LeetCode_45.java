package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：跳跃游戏二</p>
 * <p>描述：给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-04-17 11:05
 **/
public class LeetCode_45 {
    public static void main(String[] args) {
        LeetCode_45 leetCode = new LeetCode_45();


    }

    /**
     * 按照题目描述，数组中只可能是最后一个位置为0。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        return -1;
    }

    static class TestCase {
        public static final int ans = 2;
        public static final int[] nums = {2,3,1,1,4};

        public static final int ans1 = 2;
        public static final int[] nums1 = {2,3,1,1,0};

        public static final int ans2 = 3;
        public static final int[] nums2 = {2,1,1,1,4};
    }
}
