package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：比特位计数</p>
 * <p>描述：给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 通过次数75,383提交次数97,882
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-03:08:33:41
 */
public class LeetCode_338 {
    public static void main(String[] args) {
        LeetCode_338 leetCode = new LeetCode_338();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.countBits(TestCase.NUM)));
        System.out.println("Result["+Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.countBits(TestCase.NUM1)));
    }

    public int[] countBits(int num) {
        int[] ans = new int[num+1];

        ans[0] = 0;
        for(int i = 1; i <= num; i ++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    static class TestCase {
        public static int[] ANS = {0,1,1};
        public static int NUM = 2;

        public static int[] ANS1 = {0,1,1,2,1,2};
        public static int NUM1 = 5;
    }
}
