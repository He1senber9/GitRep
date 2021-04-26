package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：在 D 天内送达包裹的能力</p>
 * <p>描述：传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 *
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 *  
 *
 * 提示：
 *
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 * 通过次数20,445提交次数35,372
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_1011
 * @Description TODO
 * @User fanyu
 * @Date 2021/4/26 8:29
 */
public class LeetCode_1011 {
    public static void main(String[] args) {
        LeetCode_1011 leetCode = new LeetCode_1011();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.shipWithinDays(TestCase.WEIGHTS, TestCase.D));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.shipWithinDays(TestCase.WEIGHTS1, TestCase.D1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.shipWithinDays(TestCase.WEIGHTS2, TestCase.D2));
    }

    /**
     * 解法一：
     *
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int max = Integer.MAX_VALUE;
        for(int i = 1; i < max; i ++) {
            if(shipWithinDays(weights, i, 0, D)) {
                return i;
            }
        }

        return Integer.MAX_VALUE;
    }

    private boolean shipWithinDays(int[] weights, int capacity, int i, int D) {
        if(D == 0 && i >= weights.length) {
            return true;
        }

        if(D == 0) {
            return false;
        }

        if(i >= weights.length) {
            return true;
        }

        if(weights[i] > capacity) {
            return false;
        }

        int sum = 0;
        int j = i;
        while(j < weights.length && (sum + weights[j]) <= capacity) {
            sum += weights[j];
            j ++;
        }

        if(sum > capacity) {
            return false;
        }

        return shipWithinDays(weights, capacity, j, D-1);
    }

    static class TestCase {
        public static int ANS = 15;
        public static int[] WEIGHTS = {1,2,3,4,5,6,7,8,9,10};
        public static int D = 5;

        public static int ANS1 = 6;
        public static int[] WEIGHTS1 = {3,2,2,4,1,4};
        public static int D1 = 3;

        public static int ANS2 = 3;
        public static int[] WEIGHTS2 = {1,2,3,1,1};
        public static int D2 = 4;
    }
}
