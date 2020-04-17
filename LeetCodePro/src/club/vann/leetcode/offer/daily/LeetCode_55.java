package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：跳跃游戏</p>
 * <p>描述：给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 通过次数85,747提交次数218,919
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-04-17 10:39
 **/
public class LeetCode_55 {
    public static void main(String[] args) {
        LeetCode_55 leetCode = new LeetCode_55();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.canJump(TestCase.nums));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.canJump(TestCase.nums1));
    }

    public boolean canJump(int[] nums) {
        return false;
    }

    static class TestCase {
        public static final boolean ans = true;
        public static final int[] nums = {2,3,1,1,4};

        public static final boolean ans1 = false;
        public static final int[] nums1 = {3,2,1,0,4};
    }
}
