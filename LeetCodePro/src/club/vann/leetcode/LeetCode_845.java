package club.vann.leetcode;

/**
 * <p>难度：Medium</p>
 * <p>题目：数组中的最长山脉</p>
 * <p>描述：我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 通过次数28,078提交次数67,981
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-10-26 12:51
 **/
public class LeetCode_845 {
    public static void main(String[] args) {
        LeetCode_845 leetCode = new LeetCode_845();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.longestMountain(TestCase.A));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.longestMountain(TestCase.A1));
    }

    /**
     * 解法一：
     *
     * @param A
     * @return
     */
    public int longestMountain(int[] A) {
        return 0;
    }

    static class TestCase {
        public static int ANS = 5;
        public static int[] A = {2,1,4,7,3,2,5};

        public static int ANS1 = 0;
        public static int[] A1 = {2,2,2};
    }
}
