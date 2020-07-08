package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <p>难度：Easy</p>
 * <p>题目：跳水板</p>
 * <p>描述：你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * 通过次数10,028提交次数23,177
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-08 09:11
 **/
public class LeetCode_16_11 {
    public static void main(String[] args) {
        LeetCode_16_11 leetCode = new LeetCode_16_11();

        System.out.println("Result["+Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.divingBoard(TestCase.PARAMS[0], TestCase.PARAMS[1], TestCase.PARAMS[2])));
        System.out.println("Result["+Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.divingBoard(TestCase.PARAMS1[0], TestCase.PARAMS1[1], TestCase.PARAMS1[2])));
        System.out.println("Result["+Arrays.toString(TestCase.ANS2)+"] : " + Arrays.toString(leetCode.divingBoard(TestCase.PARAMS2[0], TestCase.PARAMS2[1], TestCase.PARAMS2[2])));
        System.out.println("Result["+Arrays.toString(TestCase.ANS3)+"] : " + Arrays.toString(leetCode.divingBoard(TestCase.PARAMS3[0], TestCase.PARAMS3[1], TestCase.PARAMS3[2])));
        System.out.println("Result["+Arrays.toString(TestCase.ANS4)+"] : " + Arrays.toString(leetCode.divingBoard(TestCase.PARAMS4[0], TestCase.PARAMS4[1], TestCase.PARAMS4[2])));
        System.out.println("Result["+Arrays.toString(TestCase.ANS5)+"] : " + Arrays.toString(leetCode.divingBoard(TestCase.PARAMS5[0], TestCase.PARAMS5[1], TestCase.PARAMS5[2])));
        System.out.println("Result["+Arrays.toString(TestCase.ANS6)+"] : " + Arrays.toString(leetCode.divingBoard(TestCase.PARAMS6[0], TestCase.PARAMS6[1], TestCase.PARAMS6[2])));

    }

    /**
     * 解法一：
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    private int[] divingBoard(int shorter, int longer, int k) {
        long begin = System.currentTimeMillis();
        if(k == 0) {
            return new int[0];
        }

        if(shorter == longer) {
            return new int[] {shorter * k};
        }

        int[] res = new int[k+1];
        res[0] = shorter * k;
        for(int n = 1; n < k+1; n ++) {
            res[n] = res[n-1] - shorter + longer;
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end-begin));
        return res;
    }

    static class TestCase {
        public static final int[] ANS = {1,2};
        public static final int[] PARAMS = {1,2,1};

        public static final int[] ANS1 = {2,3,4};
        public static final int[] PARAMS1 = {1,2,2};

        public static final int[] ANS2 = {3,4,5,6};
        public static final int[] PARAMS2 = {1,2,3};

        public static final int[] ANS3 = {1,1};
        public static final int[] PARAMS3 = {1,1,1};

        public static final int[] ANS4 = {2,2};
        public static final int[] PARAMS4 = {1,1,2};

        public static final int[] ANS5 = {100000};
        public static final int[] PARAMS5 = {1,1,100000};

        public static final int[] ANS6 = {100000};
        public static final int[] PARAMS6 = {7,415,37956};

    }
}
