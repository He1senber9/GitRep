package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>难度：Hard</p>
 * <p>题目：俄罗斯套娃信封问题</p>
 * <p>描述：给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 通过次数26,598提交次数67,344
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-04:08:23:51
 */
public class LeetCode_354 {
    public static void main(String[] args) {
        LeetCode_354 leetCode = new LeetCode_354();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxEnvelopes(TestCase.ENVELOPES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxEnvelopes(TestCase.ENVELOPES1));
    }

    /**
     * 解法一：
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }

        int ans = 0;
        int len = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int[] f = new int[len];
        Arrays.fill(f, 1);
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    static class TestCase {
        public static int ANS = 3;
        public static int[][] ENVELOPES = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};

        public static int ANS1 = 0;
        public static int[][] ENVELOPES1 = {{1,1}};
    }
}
