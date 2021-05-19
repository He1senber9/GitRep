package club.vann.leetcode.offer.daily;


import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode_1738 {
    public static void main(String[] args) {
        LeetCode_1738 leetCode = new LeetCode_1738();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.kthLargestValue(TestCase.MATRIX, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.kthLargestValue(TestCase.MATRIX1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.kthLargestValue(TestCase.MATRIX2, TestCase.K2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.kthLargestValue(TestCase.MATRIX3, TestCase.K3));
    }

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });
        // queue.add(matrix[0][0]);
        int[][] sums = new int[m+1][n+1];
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                sums[i][j] = sums[i-1][j] ^ sums[i][j-1] ^ sums[i-1][j-1] ^ matrix[i-1][j-1];
                queue.add(sums[i][j]);
            }
        }

        while(!queue.isEmpty() && k > 1) {
            queue.poll();
            k --;
        }

        return queue.poll();
    }

    static class TestCase {
        public static int ANS = 7;
        public static int[][] MATRIX = {{5, 2}, {1, 6}};
        public static int K = 1;

        public static int ANS1 = 5;
        public static int[][] MATRIX1 = {{5, 2}, {1, 6}};
        public static int K1 = 2;

        public static int ANS2 = 4;
        public static int[][] MATRIX2 = {{5, 2}, {1, 6}};
        public static int K2 = 3;

        public static int ANS3 = 0;
        public static int[][] MATRIX3 = {{5, 2}, {1, 6}};
        public static int K3 = 4;
    }
}
