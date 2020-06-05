package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p>题目：顺时针打印矩阵</p>
 * <p>描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 * 通过次数21,874提交次数48,538
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-05 10:34
 **/
public class LeetCode_29 {
    public static void main(String[] args) {
        LeetCode_29 leetCode = new LeetCode_29();

        System.out.println("Result["+ Arrays.toString(TestCase.ans)+"] : " + Arrays.toString(leetCode.spiralOrder(TestCase.matrix)));
        System.out.println("Result["+Arrays.toString(TestCase.ans1)+"] : " + Arrays.toString(leetCode.spiralOrder(TestCase.matrix1)));
    }

    /**
     * 解法一：
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;

        // 采用一个辅助矩阵，用于判断当前元素是否被访问过
        int[][] visited = new int[rows][columns];

        // 用于控制顺时针方向
        int[][] dr = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        // 结果数组
        int[] res = new int[rows*columns];

        int y = 0, x = -1;
        int t = 0;
        for(int n = 0; n < rows*columns; n ++) {
            int tmpY = y+dr[t][0];
            int tmpX = x+dr[t][1];

            if(tmpY>=0 && tmpY<rows && tmpX>=0 && tmpX<columns && visited[tmpY][tmpX] == 0) {
                y = tmpY;
                x = tmpX;
                visited[y][x] = 1;
                res[n] = matrix[y][x];
            } else {
                t ++;
                t = t % 4;
                n--;
            }

        }

        return res;
    }

    static class TestCase {
        public static final int[] ans = {1,2,3,6,9,8,7,4,5};
        public static final int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

        public static final int[] ans1 = {1,2,3,4,8,12,11,10,9,5,6,7};
        public static final int[][] matrix1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};

        public static final int[] ans2 = {1,2,3,4,8,12,11,10,9,5,6,7};
        public static final int[][] matrix2 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

        public static final int[] ans3 = {1,2,3,6,9,12,11,10,7,4,5,8};
        public static final int[][] matrix3 = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
    }
}
