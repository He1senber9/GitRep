package club.vann.leetcode.offer.daily;

import com.sun.xml.internal.messaging.saaj.util.TeeInputStream;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * <p>难度：Medium</p>
 * <p>题目：旋转数组</p>
 * <p>描述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 通过次数192,795提交次数436,817
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_189
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/8 9:38
 */
public class LeetCode_189 {
    public static void main(String[] args) {
        LeetCode_189 leetCode = new LeetCode_189();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.rotate(TestCase.NUMS, TestCase.K)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.rotate(TestCase.NUMS1, TestCase.K1)));
    }

    /**
     * 解法一：
     * 采用辅助数组
     * @param nums
     * @param k
     */
    public int[] rotate(int[] nums, int k) {
        int n = nums.length;
        int[] help = new int[n];
        System.arraycopy(nums, 0, help, 0, n);

        for(int i = 0; i < n; i ++) {
            nums[(i+k)%n] = help[i];
        }
        return nums;
    }

    /**
     * 解法二：
     * 采用翻转数组方式（原地解法）
     * @param nums
     * @param k
     */
    public int[] rotate1(int[] nums, int k) {
        int n = nums.length;

        return nums;
    }

    /**
     * 解法三：
     * 采用公式推算方式。
     * @param nums
     * @param k
     */
    public int[] rotate2(int[] nums, int k) {
        int n = nums.length;

        return nums;
    }

    static class TestCase {
        public static int[] ANS = {5,6,7,1,2,3,4};
        public static int[] NUMS = {1,2,3,4,5,6,7};
        public static int K = 3;

        public static int[] ANS1 = {3,99,-1,-100};
        public static int[] NUMS1 = {-1,-100,3,99};
        public static int K1 = 2;
    }
}
