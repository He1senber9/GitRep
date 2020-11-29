package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p>题目：三角形的最大周长</p>
 * <p>描述：给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 *
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 *
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 *
 * 输入：[3,6,2,3]
 * 输出：8
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 * 通过次数24,575提交次数43,207
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-29 08:41
 **/
public class LeetCode_976 {
    public static void main(String[] args) {
        LeetCode_976 leetCode = new LeetCode_976();

//        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.largestPerimeter(TestCase.ARR));
//        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.largestPerimeter(TestCase.ARR1));
//        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.largestPerimeter(TestCase.ARR2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.largestPerimeter(TestCase.ARR3));
    }

    /**
     * 解法一：
     *
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        // 组成三角形必要条件：a + b > c
//        Arrays.sort(A);
        int len = A.length;

//        for(int a = len-1; a >= 2; a --) {
//            for(int b = a-1; b >= 1; b --) {
//                for(int c = b-1; c >= 0; c --) {
//                    if((A[a] + A[b] > A[c]) && (A[a] + A[c] > A[b]) && (A[b] + A[c] > A[a])) {
//                        return A[a] + A[b] + A[c];
//                    }
//                }
//            }
//        }

        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }

    static class TestCase {
        public static int ANS = 5;
        public static int[] ARR = {2,1,2};

        public static int ANS1 = 0;
        public static int[] ARR1 = {1,2,1};

        public static int ANS2 = 10;
        public static int[] ARR2 = {3,2,3,4};

        public static int ANS3 = 8;
        public static int[] ARR3 = {3,6,2,3};

    }
}
