package club.vann.leetcode.offer.daily;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>难度：Medium</p>
 * <p>题目：有序矩阵中第K小的元素</p>
 * <p>描述：给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *  
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 * 通过次数33,597提交次数54,497
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-02 15:15
 **/
public class LeetCode_378 {
    public static void main(String[] args) {
        LeetCode_378 leetCode = new LeetCode_378();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.kthSmallest(TestCase.matrix, 8));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.kthSmallest(TestCase.matrix1, 3));
    }

    /**
     * 解法一：
     * 归并排序，使用小根堆实现
     * 求第K个元素，
     * @param matrix
     * @param k
     * @return
     */
    private int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }

    /**
     * 解法二：
     * 二分查找
     * @param matrix
     * @param k
     * @return
     */
    private int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    static class TestCase {
        public static int ans = 13;
        public static int[][] matrix = {{ 1,  5,  9}, {10, 11, 13}, {12, 13, 15}};

        public static int ans1 = 2;
        public static int[][] matrix1 = {{ 1,  2}, {1, 3}};
    }
}
