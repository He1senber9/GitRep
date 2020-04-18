package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：盛水最多的容器</p>
 * <p>描述：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/18
 * Time: 9:42
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_11 {
    public static void main(String[] args) {
        LeetCode_11 leetCode = new LeetCode_11();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.maxArea(TestCase.height));
    }

    /**
     * 解法一：暴力破解
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     * 采用双指针，依次找到每个边界上能盛水的容量，然后找到最大值。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int len = height.length;

        int max = 0;
        int left = 0, right = 1; // 因为 n >= 2;
        for(int n = 0; n < len-1; n ++) {
            left = n;
            for(int m = n+1; m < len; m ++) {
                right = m;
                int h = Math.min(height[left], height[right]);
                max = Math.max(max, (right-left) * h);
            }
        }
        return max;
    }

    static class TestCase {
        public static final int ans = 49;
        public static final int[] height = {1,8,6,2,5,4,8,3,7};
    }
}
