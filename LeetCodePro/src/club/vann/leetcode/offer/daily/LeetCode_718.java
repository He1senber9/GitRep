package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：最长重复子数组</p>
 * <p>描述：给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * 通过次数14,454提交次数28,294
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/1
 * Time: 7:06
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_718 {

    public static void main(String[] args) {
        LeetCode_718 leetCode = new LeetCode_718();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.findLength(TestCase.ARRAYS[0], TestCase.ARRAYS[1]));
    }

    private int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;

        int ans = 0;
        for(int n = 0; n < lenA; n ++) {
            for(int m = 0; m < lenB; m ++) {
                int k = 0;
                while ((n+k) < lenA && (m+k) < lenB && A[n+k] == B[m+k]){
                    k += 1;
                }
                ans = Math.max(ans, k);
            }
        }

        return ans;
    }

    /**
     * 判断数组B中索引[begin,end]能否组成A的子数组
     * @param A
     * @param B
     * @param begin
     * @param end
     * @return
     */
    private boolean isSubArray(int[] A, int[] B, int begin, int end) {
        return false;
    }

    static class TestCase {
        public static final int ANS = 3;
        public static final int[][] ARRAYS = {{1,2,3,2,1}, {3,2,1,4,7}};

        public static final int ANS1 = 6;
        public static final int[][] ARRAYS1 = {{1,2,3,4,5,6,1,2,3}, {1,2,3,5,6,1,2,3,4,5,6}};
    }
}
