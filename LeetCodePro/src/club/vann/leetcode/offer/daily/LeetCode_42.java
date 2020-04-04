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

        System.out.println("Result["+TestCase.ANS+"] " + leetCode.trap(TestCase.HEIGHT));
        System.out.println("Result["+TestCase.ANS1+"] " + leetCode.trap(TestCase.HEIGHT1));
        System.out.println("Result["+TestCase.ANS2+"] " + leetCode.trap(TestCase.HEIGHT2));
        System.out.println("Result["+TestCase.ANS3+"] " + leetCode.trap(TestCase.HEIGHT3));
        System.out.println("Result["+TestCase.ANS4+"] " + leetCode.trap(TestCase.HEIGHT4));
        System.out.println("Result["+TestCase.ANS5+"] " + leetCode.trap(TestCase.HEIGHT5));
        System.out.println("Result["+TestCase.ANS6+"] " + leetCode.trap(TestCase.HEIGHT6));
        System.out.println("Result["+TestCase.ANS7+"] " + leetCode.trap(TestCase.HEIGHT7));
        System.out.println("Result["+TestCase.ANS8+"] " + leetCode.trap(TestCase.HEIGHT8));
        System.out.println("Result["+TestCase.ANS9+"] " + leetCode.trap(TestCase.HEIGHT9));
        System.out.println("Result["+TestCase.ANS10+"] " + leetCode.trap(TestCase.HEIGHT10));
        System.out.println("Result["+TestCase.ANS11+"] " + leetCode.trap(TestCase.HEIGHT11));
        System.out.println("Result["+TestCase.ANS12+"] " + leetCode.trap(TestCase.HEIGHT12
        ));
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

        for(int n = 1; n < len; n ++) {
            int cur = height[n];

            // 如果能聚集水，那么在当前节点的两端一定存在比他高的两个节点
            int l = n, r = n;
            for(int left = n-1; left >= 0; left --) {
                if(height[left] > height[l]) {
                    l = left;
                }
            }

            for(int right = n+1; right < len; right ++) {
                if(height[right] > height[r]) {
                    r = right;
                }
            }

            if(l == n && r == n) {
                continue;
            }
        }

        return result;
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
    }
}
