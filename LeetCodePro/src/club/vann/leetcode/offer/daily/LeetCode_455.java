package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p>题目：分发饼干</p>
 * <p>描述：假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 *  
 * 示例 1:
 *
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 *
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 *  
 *
 * 提示：
 *
 * 1 <= g.length <= 3 * 104
 * 0 <= s.length <= 3 * 104
 * 1 <= g[i], s[j] <= 231 - 1
 * 通过次数69,216提交次数122,418
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-12-25 07:55
 **/
public class LeetCode_455 {
    public static void main(String[] args) {
        LeetCode_455 leetCode = new LeetCode_455();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.findContentChildren(TestCase.G, TestCase.S));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.findContentChildren(TestCase.G1, TestCase.S1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.findContentChildren(TestCase.G2, TestCase.S2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.findContentChildren(TestCase.G3, TestCase.S3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.findContentChildren(TestCase.G4, TestCase.S4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.findContentChildren(TestCase.G5, TestCase.S5));
        System.out.println("Result["+TestCase.ANS6+"] : " + leetCode.findContentChildren(TestCase.G6, TestCase.S6));
    }

    /**
     * 解法一：
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int len = s.length;

        if(len == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for(int i = 0, j = 0; i < n && j < len; i ++, j ++) {
            if(g[i] <= s[j]) {
                res ++;
            }  else {
                i --;
            }
        }

        return res;
    }

    static class TestCase {
        public static int ANS = 1;
        public static int[] G = {1,2,3};
        public static int[] S = {1,1};

        public static int ANS1 = 2;
        public static int[] G1 = {1,2,3};
        public static int[] S1 = {1,2};

        public static int ANS2 = 2;
        public static int[] G2 = {1,2,3};
        public static int[] S2 = {2,2};

        public static int ANS3 = 2;
        public static int[] G3 = {1,2};
        public static int[] S3 = {1,2,3};

        public static int ANS4 = 2;
        public static int[] G4 = {10,9,8,7};
        public static int[] S4 = {5,6,7,8};

        public static int ANS5 = 4;
        public static int[] G5 = {1,2,3,4};
        public static int[] S5 = {5,6,7,8};

        public static int ANS6 = 0;
        public static int[] G6 = {5,6,7,8};
        public static int[] S6 = {1,2,3,4};

    }
}
