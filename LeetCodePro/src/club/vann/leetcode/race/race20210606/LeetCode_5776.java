package club.vann.leetcode.race.race20210606;

import java.util.Collection;
import java.util.Collections;

/**
 * <p>难度：Easy</p>
 * <p>题目：判断矩阵经轮转后是否一致</p>
 * <p>描述：给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出：true
 * 解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
 * 示例 2：
 *
 *
 * 输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出：false
 * 解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
 * 示例 3：
 *
 *
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出：true
 * 解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
 *
 *
 * 提示：
 *
 * n == mat.length == target.length
 * n == mat[i].length == target[i].length
 * 1 <= n <= 10
 * mat[i][j] 和 target[i][j] 不是 0 就是 1</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-06  10:48:48
 */
public class LeetCode_5776 {
    public static void main(String[] args) {
        LeetCode_5776 leetCode = new LeetCode_5776();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.findRotation(TestCase.MAT, TestCase.TARGET));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.findRotation(TestCase.MAT1, TestCase.TARGET1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.findRotation(TestCase.MAT2, TestCase.TARGET2));
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int[] source = print(mat);
        int[] tag = print(target);

        // 未旋转或者选装360°
        if(isFormat(source, tag, 0)) {
            return true;
        }

        // 旋转90°
        if(isFormat(source, tag, n-1)) {
            return true;
        }

        if(isFormat(source, tag, 2*n-1)) {
            return true;
        }

        if(isFormat(source, tag, 3*n-1)) {
            return true;
        }

        return false;
    }

    private int[] print(int[][] matrix) {
        int n = matrix.length;
        int[] tag = new int[n*n];

        int left = 0, right = n-1, top = 0, bottom = n-1;
        int index = 0;
        while(index < n*n) {
            for(int i = left; i <= right; i ++) {
                tag[index] = matrix[top][i];
                index ++;
            }
            top ++;

            for(int i = top; i <= bottom; i ++) {
                tag[index] = matrix[i][right];
                index ++;
            }
            right --;

            for(int i = right; i >= left; i --) {
                tag[index] = matrix[bottom][i];
                index ++;
            }
            bottom --;

            for(int i = bottom; i >= top; i --) {
                tag[index] = matrix[i][left];
                index ++;
            }
            left ++;
        }

        return tag;
    }

    private boolean isFormat(int[] source, int[] tag, int k) {
        int len = source.length;

        if(k > 0) {
            // 逆向
            for(int i = 0; i < len/2; i ++) {
                int tmp = source[i];
                source[i] = source[len-1-i];
                source[len-1-i] = tmp;
            }

            // 旋转
            for(int i = 0; i < k/2; i ++) {
                int tmp = source[i];
                source[i] = source[k-i];
                source[k-i] = tmp;
            }

            for(int i = k; i < (len-k)/2; i ++) {
                int tmp = source[i];
                source[i] = source[len-i];
                source[len-i] = tmp;
            }
        }

        for(int i = 0; i < len; i ++) {
            if(source[i] != tag[i]) {
                return false;
            }
        }
        return true;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[][] MAT = {{0, 1}, {1, 0}};
        public static int[][] TARGET = {{1, 0}, {0, 1}};

        public static boolean ANS1 = true;
        public static int[][] MAT1 = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        public static int[][] TARGET1 = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};

        public static boolean ANS2 = false;
        public static int[][] MAT2 = {{0, 1}, {1, 1}};
        public static int[][] TARGET2 = {{1, 0}, {0, 1}};
    }
}
