package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Midum</p>
 * <p>题目：使数组唯一的最小增量</p>
 * <p>描述：给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 提示：
 *
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 * 通过次数5,347提交次数12,084</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/22
 * Time: 8:49
 * Description:
 */
public class LeetCode_945 {
    public static void main(String[] args) {
        int[] A = null;
        int result = 0;

        LeetCode_945 leetCode = new LeetCode_945();

        A = new int[]{1,2,2};
        result = leetCode.minIncrementForUnique(A);
        System.out.println("Result[1] : " + result);

        A = new int[]{3,2,1,2,1,7};
        result = leetCode.minIncrementForUnique(A);
        System.out.println("Result[6] : " + result);
    }

    /**
     * 解法一：
     * @param A
     * @return
     */
    private int minIncrementForUnique(int[] A) {
        return 0;
    }
}
