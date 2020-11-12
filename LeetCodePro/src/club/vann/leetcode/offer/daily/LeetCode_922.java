package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p>题目：按奇偶排列数组II</p>
 * <p>描述：给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *  
 *
 * 通过次数43,215提交次数62,673
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-12 09:10
 **/
public class LeetCode_922 {
    public static void main(String[] args) {
        LeetCode_922 leetCode = new LeetCode_922();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.sortArrayByParityII(TestCase.A)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.sortArrayByParityII(TestCase.A1)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS2)+"] : " + Arrays.toString(leetCode.sortArrayByParityII(TestCase.A2)));
    }

    /**
     * 解法一：
     * 
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;

        int[] result = new int[len];

        // 偶数位标志
        int tag_1 = 0;
        for(int i = 0; i < len && tag_1 < len; i ++) {
            if(A[i] % 2 == 0) {
                result[tag_1] = A[i];
                tag_1 += 2;
                continue;
            }
        }

        int tag_2 = 1;
        for(int i = 0; i < len && tag_2 < len; i ++) {
            if(A[i] % 2 != 0) {
                result[tag_2] = A[i];
                tag_2 += 2;
                continue;
            }
        }
        return result;
    }

    static class TestCase {
        public static int[] ANS = {4,5,2,7};
        public static int[] A = {4,2,5,7};

        public static int[] ANS1 = {2,1,4,3,6,5};
        public static int[] A1 = {1,2,3,4,5,6};

        public static int[] ANS2 = {0,3,4,3,2,1,0,1,4,3};
        public static int[] A2 = {3,0,4,0,2,1,3,1,3,4};
    }
}
