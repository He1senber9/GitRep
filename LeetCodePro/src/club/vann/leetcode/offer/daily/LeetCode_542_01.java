package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：矩阵</p>
 * <p>描述：给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * 通过次数20,705提交次数49,101
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-04-15 14:45
 **/
public class LeetCode_542_01 {
    public static void main(String[] args) {
        LeetCode_542_01 leetCode = new LeetCode_542_01();

//        int[][] ans = leetCode.updateMatrix(TestCase.matrix);
//        int[][] ans1 = leetCode.updateMatrix(TestCase.matrix1);
        int[][] ans2 = leetCode.updateMatrix(TestCase.matrix2);

        System.out.println("Succ");
    }

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return matrix;
        }

        int lenY = matrix.length;
        int lenX = matrix[0].length;

        int[] dr = {-1, 1, 0, 0, 0, 1, 1, 1};
        int[] dc = {0, 0, -1, 1, 1, -1, 0, 1};

        A: for(int y = 0; y < lenY; y ++) {
            B: for(int x = 0; x <lenX; x ++) {
                int v = matrix[y][x];

                if(v == 0) {
                    continue B;
                }

                while(true) {
                    int ratio = 1;
                    for(int k = 0; k < 8; k ++) {
                        int newY = y+ratio*dr[k];
                        int newX = x+ratio*dc[k];

                        if(newY>=0 && newY<lenY && newX>=0 && newX<lenX) {
                            if(matrix[newY][newX] == 0) {
                                matrix[y][x] = Math.abs(newY-y) + Math.abs(newX-x);
                                continue B;
                            }
                        }
                    }

                    ratio += 1;
                }
            }
        }
        return matrix;
    }

    static class TestCase {
        public static final int[][] ans = {{0,0,0}, {0,1,0}, {0,0,0}};
        public static final int[][] matrix = {{0,0,0}, {0,1,0}, {0,0,0}};

        public static final int[][] ans1 = {{0,0,0}, {0,1,0}, {1,2,1}};
        public static final int[][] matrix1 = {{0,0,0}, {0,1,0}, {1,1,1}};

        public static final int[][] ans2 = {{0,1,0,1,2},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        public static final int[][] matrix2 = {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};

        public static final int[][] ans3 = {{0,1,0,1,2},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        public static final int[][] matrix3 = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
    }
}
