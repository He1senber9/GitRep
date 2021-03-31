package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：最长湍流子数组</p>
 * <p>描述：当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 *
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 *
 * 输入：[100]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 * 通过次数15,482提交次数35,456
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-08:08:36:15
 */
public class LeetCode_978 {
    public static void main(String[] args) {
        LeetCode_978 leetCode = new LeetCode_978();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxTurbulenceSize1(TestCase.ARR));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxTurbulenceSize1(TestCase.ARR1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxTurbulenceSize1(TestCase.ARR2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.maxTurbulenceSize1(TestCase.ARR3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.maxTurbulenceSize1(TestCase.ARR4));
    }

    /**
     * 解法一：
     * 双指针
     * @param arr
     * @return
     */
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        int max = 1;
        int left = 0, right = 0;

        while(right < len-1) {
            if(left == right) {
                if(arr[left] == arr[left+1]) {
                    left ++;
                }
                right ++;
//                continue;
            } else {
                if((arr[right-1] < arr[right] && arr[right] > arr[right+1])){
                    right ++;
                } else if((arr[right-1] > arr[right] && arr[right] < arr[right+1])) {
                    right ++;
                } else {
                    left = right;
                }
            }

            max = Math.max(max, right-left+1);
        }
        return max;
    }

    public int maxTurbulenceSize1(int[] arr) {
        int len = arr.length;
        int max = 1;
        int[] incre = new int[len];
        int[] decre = new int[len];
        incre[0] = 1;
        decre[0] = 1;

        for(int i = 1; i < len; i ++) {
            if(arr[i-1] < arr[i]) {
                incre[i] = decre[i-1] + 1;
                decre[i] = 1;
            } else if(arr[i-1] > arr[i]) {
                decre[i] = incre[i-1] + 1;
                incre[i] = 1;
            } else {
                incre[i] = 1;
                decre[i] = 1;
            }
            max = Math.max(max, Math.max(incre[i], decre[i]));
        }
        return max;
    }

    static class TestCase {
        public static int ANS = 5;
        public static int[] ARR = {9,4,2,10,7,8,8,1,9};

        public static int ANS1 = 2;
        public static int[] ARR1 = {4,8,12,16};

        public static int ANS2 = 1;
        public static int[] ARR2 = {100};

        public static int ANS3 = 1;
        public static int[] ARR3 = {9,9};

        public static int ANS4 = 2;
        public static int[] ARR4 = {4,8,12,16};
    }
}
