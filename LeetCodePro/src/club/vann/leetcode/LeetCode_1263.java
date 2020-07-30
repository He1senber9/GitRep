package club.vann.leetcode;

import java.util.LinkedList;

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
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.minPushBox(TestCase.GRID4));
    }

    /**
     * 解法一：
     *  1.最小推动次数：B --> T;
     *  2.S能走到B;
     * @param grid
     * @return
     */
    private int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int target_y = 0, target_x = 0; // 标记目标位置

        Node node;
        // 先找到 箱子，人
        for(int y = 0; y < m; y ++) {
            for(int x = 0; x < n; x ++) {
                if(grid[y][x] == 'B') {
                    
                }

                if(grid[y][x] == 'S') {

                }

                if(grid[y][x] == 'T') {
                    target_y = y;
                    target_x = x;
                }
            }
        }

        LinkedList<Node> queue = new LinkedList<>();

        return 0;
    }

    class Node{
        int b_y;
        int b_x;
        int p_y;
        int p_x;
        int step;
        Node(int b_y, int b_x, int p_y, int p_x, int step) {
            this.b_y = b_y;
            this.b_x = b_x;
            this.p_y = p_y;
            this.p_x = p_x;
            this.step = step;
        }
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

        public static int ANS4 = -1;
        public static char[][] GRID4 = {{'#','#','#','#','#','#'},
                {'#', 'T', '#', '#', '#', '#'}, {'#', '.', '.', 'B', 'S', '#'},
                {'#', '.', '#', '#', '.', '#'}, {'#', '#', '#', '#', '#', '#'}};

        public static int ANS5 = -1;
        public static char[][] GRID5 = {{'#','#','#','#','#','#'},
                {'#','T','#','#','#','#'}, {'#','.','.','B','.','#'},
                {'#','#','#','#','#','#'},{'#','.','.','.','S','#'},
                {'#','#','#','#','#','#'}};
    }
}
