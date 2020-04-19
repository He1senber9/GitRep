package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：接雨水</p>
 * <p>描述：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 通过次数70,450提交次数141,687
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/4
 * Time: 8:55
 * Description:
 */
public class LeetCode_42 {
    public static void main(String[] args) {
        LeetCode_42 leetCode = new LeetCode_42();

        System.out.println("Result["+TestCase.ANS+"] " + leetCode.trap3(TestCase.HEIGHT));
        System.out.println("Result["+TestCase.ANS1+"] " + leetCode.trap3(TestCase.HEIGHT1));
        System.out.println("Result["+TestCase.ANS2+"] " + leetCode.trap3(TestCase.HEIGHT2));
        System.out.println("Result["+TestCase.ANS3+"] " + leetCode.trap3(TestCase.HEIGHT3));
        System.out.println("Result["+TestCase.ANS4+"] " + leetCode.trap3(TestCase.HEIGHT4));
        System.out.println("Result["+TestCase.ANS5+"] " + leetCode.trap3(TestCase.HEIGHT5));
        System.out.println("Result["+TestCase.ANS6+"] " + leetCode.trap3(TestCase.HEIGHT6));
        System.out.println("Result["+TestCase.ANS7+"] " + leetCode.trap3(TestCase.HEIGHT7));
        System.out.println("Result["+TestCase.ANS8+"] " + leetCode.trap3(TestCase.HEIGHT8));
        System.out.println("Result["+TestCase.ANS9+"] " + leetCode.trap3(TestCase.HEIGHT9));
        System.out.println("Result["+TestCase.ANS10+"] " + leetCode.trap3(TestCase.HEIGHT10));
        System.out.println("Result["+TestCase.ANS11+"] " + leetCode.trap3(TestCase.HEIGHT11));
        System.out.println("Result["+TestCase.ANS12+"] " + leetCode.trap3(TestCase.HEIGHT12));
        System.out.println("Result["+TestCase.ANS13+"] " + leetCode.trap3(TestCase.HEIGHT13));
    }

    /**
     * 解法一：
     * 采用双指针标记
     * @param height
     * @return
     */
    private int trap(int[] height) {
        if(height == null || height.length <= 2) {
            return 0;
        }

        int result = 0;
        int len = height.length;
        int tag = 1;

        // 因为数组长度大于2才有意义
        outer:for(int n = 1; n < len-1; n ++) {
            int left = n-1;
            int cur = n;
            int right = n+1;

            if(height[cur] < height[right]) {
                for(int m = n; m >= 0; m --) {
                    if(height[m] > height[cur]) {
                        int width = (cur-m);
                        int k = Math.min(height[m], height[right]);
                        result += (k-height[cur]) * width;
                        height[cur] = k;
//                        continue outer;
                    }
                }
            }

        }

        return result;
    }

    /**
     * 解法二：采用暴力解法
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     * @param height
     * @return
     */
    private int trap2(int[] height) {
        int len = height.length;

        int res = 0;

        for(int n = 0; n < len; n ++) {
            int maxLeft = 0, maxRight = 0;
            for(int l = n; l >= 0; l --) { // 找到左边最大值
                maxLeft = Math.max(maxLeft, height[l]);
            }

            for(int r = n; r < len; r ++) { // 找到右边最大值
                maxRight = Math.max(maxRight, height[r]);
            }
            res += Math.min(maxLeft, maxRight) - height[n];
        }
        return res;
    }

    /**
     * 解法三：
     * 采用数组存储最大值
     * @param height
     * @return
     */
    private int trap3(int[] height) {
        if(height == null) {
            return 0;
        }

        int res = 0;
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];

        max_left[0] = height[0];
        for(int n = 1; n < len; n ++) {
            max_left[n] = Math.max(max_left[n-1], height[n]);
        }

        max_right[len-1] = height[len-1];
        for(int n = len-2; n >= 0; n --) {
            max_right[n] = Math.max(max_right[n+1], height[n]);
        }

        for(int n = 1; n < len-1; n ++) {
            res += (Math.min(max_left[n], max_right[n]) - height[n]);
        }
        return res;
    }

    /**
     * 解法四：
     * 采用栈辅助
     * @param height
     * @return
     */
    private int trap4(int[] height) {
        return -1;
    }

    /**
     * 计算容积
     * @param min
     * @param max
     * @return
     */
    private int sum(int min, int max, int left, int right) {
        int sum = 0;
        return 0;
    }

    static class TestCase {
        public static final int ANS = 6;
        public static final int[] HEIGHT = {0,1,0,2,1,0,1,3,2,1,2,1};

        public static final int ANS1 = 0;
        public static final int[] HEIGHT1 = {0,0,0,0,0,0,0,0,0,0,0,0};

        public static final int ANS2 = 0;
        public static final int[] HEIGHT2 = {2,0,0,0,0,0,0,0,0,0,0,0};

        public static final int ANS3 = 0;
        public static final int[] HEIGHT3 = {0,2,0,0,0,0,0,0,0,0,0,0};

        public static final int ANS4 = 0;
        public static final int[] HEIGHT4 = {0,2,2,0,0,0,0,0,0,0,0,0};

        public static final int ANS5 = 0;
        public static final int[] HEIGHT5 = {0,2,2,2,0,0,0,0,0,0,0,0};

        public static final int ANS6 = 0;
        public static final int[] HEIGHT6 = {0,1,2,3,4,5,5,4,3,2,1,0};

        public static final int ANS7 = 30;
        public static final int[] HEIGHT7 = {5,4,3,2,1,0,0,1,2,3,4,5};

        public static final int ANS8 = 0;
        public static final int[] HEIGHT8 = {5,4};

        public static final int ANS9 = 1;
        public static final int[] HEIGHT9 = {5,4,5};

        public static final int ANS10 = 0;
        public static final int[] HEIGHT10 = {4,5,4};

        public static final int ANS11 = 41;
        public static final int[] HEIGHT11 = {5,4,3,2,1,0,1,2,1,0,1,2,3,4,5};

        public static final int ANS12 = 96;
        public static final int[] HEIGHT12 = {8,7,6,5,4,3,4,5,4,3,2,1,0,1,2,3,4,5,4,3,4,5,6,7,8};

        public static final int ANS13 = 3;
        public static final int[] HEIGHT13 = {2,1,0,2};
    }
}
