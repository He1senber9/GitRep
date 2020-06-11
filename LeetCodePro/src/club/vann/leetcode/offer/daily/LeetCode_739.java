package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：每日温度</p>
 * <p>描述：根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 通过次数57,006提交次数92,112
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-11 08:33
 **/
public class LeetCode_739 {
    public static void main(String[] args) {
        LeetCode_739 leetCode = new LeetCode_739();

        System.out.println("Result["+ Arrays.toString(TestCase.ans)+"]: " + Arrays.toString(leetCode.dailyTemperatures(TestCase.arrays)));
    }

    /**
     * 解法一：
     * 暴力遍历
     * @param T
     * @return
     */
    private int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) {
            return new int[0];
        }

        int len = T.length;

        A:for(int i = 0; i < len; i ++) {
            int cur = T[i];
            int count = 0;
            B:for(int n = i+1; n < len; n ++) {
                count ++;
                if(T[n] > cur) {
                    T[i] = T[n];
                    break B;
                }
            }
            if(T[i] != cur) {
                T[i] = count;
            } else {
                T[i] = 0;
            }

        }

        return T;
    }

    static class TestCase {
        public static final int[] ans = {1, 1, 4, 2, 1, 1, 0, 0};
        public static final int[] arrays = {73, 74, 75, 71, 69, 72, 76, 73};
    }
}
