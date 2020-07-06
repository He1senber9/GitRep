package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：不同路径II</p>
 * <p>描述:一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 通过次数66,770提交次数196,866
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/6
 * Time: 6:55
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_63 {
    public static void main(String[] args) {
        LeetCode_63 leetCode = new LeetCode_63();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.uniquePathsWithObstacles(TestCase.matrix));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.uniquePathsWithObstacles(TestCase.matrix1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.uniquePathsWithObstacles(TestCase.matrix2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.uniquePathsWithObstacles(TestCase.matrix3));
    }

    /**
     * 解法一：
     *
     * @param obstacleGrid
     * @return
     */
    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int lenY = obstacleGrid.length;
        int lenX = obstacleGrid[0].length;
        int[][] dp = new int[lenY][lenX];
        dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;

        for(int y = 1; y < lenY; y ++) {
            if(obstacleGrid[y][0] == 1) {
                dp[y][0] = 0;
            } else {
                dp[y][0] = (dp[y-1][0])==0 ? 0 : 1;
            }
        }

        for(int x = 1; x < lenX; x ++) {
            if(obstacleGrid[0][x] == 1) {
                dp[0][x] = 0;
            } else {
                dp[0][x] = (dp[0][x-1])==0 ? 0 : 1;
            }
        }

        for(int y = 1; y < lenY; y ++) {
            for(int x = 1; x < lenX; x ++) {
                if(obstacleGrid[y][x] == 1) {
                    dp[y][x] = 0;
                } else {
                    int count1 = (dp[y-1][x] == 0) ? 0 : dp[y-1][x];
                    int count2 = (dp[y][x-1] == 0) ? 0 : dp[y][x-1];
                    dp[y][x] = count1 + count2;
                }
            }
        }
        return dp[lenY-1][lenX-1];
    }

    static class TestCase {
        public static final int ANS = 2;
        public static int[][] matrix = {{0,0,0}, {0,1,0}, {0,0,0}};

        public static final int ANS1 = 0;
        public static int[][] matrix1 = {{0,1,0}, {1,0,0}, {0,0,0}};

        public static final int ANS2 = 1;
        public static int[][] matrix2 = {{0}};

        public static final int ANS3 = 0;
        public static int[][] matrix3 = {{1}};
    }
}
