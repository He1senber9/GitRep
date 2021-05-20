package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：不相交的线</p>
 * <p>描述：在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 *
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 *
 *  nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 *
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线，如上图所示。
 * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
 * 示例 2：
 *
 * 输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * 输出：3
 * 示例 3：
 *
 * 输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length <= 500
 * 1 <= nums2.length <= 500
 * 1 <= nums1[i], nums2[i] <= 2000
 *  
 *
 * 通过次数9,343提交次数16,033
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uncrossed-lines
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-05-21  07:46:18
 */
public class LeetCode_1035 {
    public static void main(String[] args) {
        LeetCode_1035 leetCode = new LeetCode_1035();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxUncrossedLines(TestCase.NUMS[0], TestCase.NUMS[1]));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxUncrossedLines(TestCase.NUMS1[0], TestCase.NUMS1[1]));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxUncrossedLines(TestCase.NUMS2[0], TestCase.NUMS2[1]));
    }

    /**
     * 解法一：
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return 0;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[][] NUMS = {{1, 4, 2}, {1,2,4}};

        public static int ANS1 = 3;
        public static int[][] NUMS1 = {{2,5,1,2,5}, {10,5,2,1,5,2}};

        public static int ANS2 = 2;
        public static int[][] NUMS2 = {{1,3,7,1,7,5}, {1,9,2,5,1}};

    }
}
