package club.vann.leetcode.offer.daily;

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

//        System.out.println("Result["+TestCase.ans+"] : " + leetCode.kthSmallest(TestCase.matrix, 8));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.kthSmallest(TestCase.matrix1, 3));
    }

    /**
     * 解法一：
     * 对于元素 matrix[x][y] 其最小 min = (x-0)+(y-0)+1， 最大 max = (x+1)*(y+1)。
     * 求第K个元素，
     * @param matrix
     * @param k
     * @return
     */
    private int kthSmallest(int[][] matrix, int k) {
        int min = Integer.MAX_VALUE;

        int[] array = new int[k];

        int n = matrix.length;
        for(int y = 0; y < n; y ++) {
            for(int x = 0; x < n; x ++) {
                if(x < y && (y*n+x+1) < k) {
                    continue;
                } else if(y < x && (x*n+y+1) < k) {
                    continue;
                } else if(x == y && (y*n+x+1) < k) {
                    continue;
                }

                min = Math.min(min, matrix[y][x]);
            }
        }
        return min;
    }

    static class TestCase {
        public static int ans = 13;
        public static int[][] matrix = {{ 1,  5,  9}, {10, 11, 13}, {12, 13, 15}};

        public static int ans1 = 2;
        public static int[][] matrix1 = {{ 1,  2}, {1, 3}};
    }
}
