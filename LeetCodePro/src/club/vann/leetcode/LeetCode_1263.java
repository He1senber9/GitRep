package club.vann.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/29
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1263 {
    public static void main(String[] args) {
        LeetCode_1263 leetCode = new LeetCode_1263();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minPushBox(TestCase.GRID));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minPushBox(TestCase.GRID1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.minPushBox(TestCase.GRID2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.minPushBox(TestCase.GRID3));
    }

    /**
     * 解法一：
     *  1.最小推动次数：B --> T;
     *  2.S能走到B;
     * @param grid
     * @return
     */
    private int minPushBox(char[][] grid) {
        return 0;
    }

    static class TestCase {
        public static int ANS = 3;
        public static char[][] GRID = {{'#','#','#','#','#','#'},
                {'#', 'T', '#', '#', '#', '#'}, {'#', '.', '.', 'B', '.', '#'},
                {'#', '.', '#', '#', '.', '#'},{'#', '.', '.', '.', 'S', '#'},
                {'#', '#', '#', '#', '#', '#'}};

        public static int ANS1 = -1;
        public static char[][] GRID1 = {{'#','#','#','#','#','#'},
                {'#','T','#','#','#','#'}, {'#','.','.','B','.','#'},
                {'#','#','#','#','.','#'},{'#','.','.','.','S','#'},
                {'#','#','#','#','#','#'}};

        public static int ANS2 = 5;
        public static char[][] GRID2 = {{'#','#','#','#','#','#'},
                {'#','T','.','.','#','#'}, {'#','.','#','B','.','#'},
                {'#','.','.','.','.','#'},{'#','.','.','.','S','#'},
                {'#','#','#','#','#','#'}};

        public static int ANS3 = -1;
        public static char[][] GRID3 = {{'#','#','#','#','#','#','#'},
                {'#','S','#','.','B','T','#'}, {'#','#','#','#','#','#','#'}};
    }
}
