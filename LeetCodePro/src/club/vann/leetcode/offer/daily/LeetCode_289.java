package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Midum</p>
 * <p>题目：生命游戏</p>
 * <p>描述：根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * 示例：
 *
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *  
 *
 * 进阶：
 *
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 * 通过次数14,213提交次数20,082
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/2
 * Time: 9:11
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_289 {
    public static void main(String[] args) {
        LeetCode_289 leetCode = new LeetCode_289();

        leetCode.gameOfLife(TestCase.board);
        System.out.println(TestCase.ans_board);
        System.out.println(TestCase.board);

        leetCode.gameOfLife(TestCase.board1);
        System.out.println(TestCase.board1);

        leetCode.gameOfLife(TestCase.board2);
        System.out.println(TestCase.board2);

        leetCode.gameOfLife(TestCase.board3);
        System.out.println(TestCase.board3);
    }

    /**
     * 解法一：
     * 需要构造一个镜像来辅助。
     * @param board
     */
    private void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        int lenY = board.length;
        int lenX = board[0].length;

        // 用于寻找周围八个节点
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        // 镜像
        int[][] minor = new int[lenY][lenX];
        for(int y = 0; y < lenY; y ++) {
            for(int x = 0; x <lenX; x ++) {
                int v = board[y][x];
                minor[y][x] = v;

                if(v == 1) { // 当前位置是活细胞
                    int count = 0; // 周围8个位置的活细胞计数
                    for(int k = 0; k < 8; k ++) {
                        int newY = y+dr[k];
                        int newX = x+dc[k];

                        if(newY>=0 && newY<lenY && newX>=0 && newX<lenX) {
                            if(board[newY][newX] == 1) {
                                count ++;
                            }
                        }
                    }

                    if(count < 2 || count > 3) { // 标记当前细胞为死亡细胞
                        minor[y][x] = 0;
                    }
                } else { // 当前位置是死细胞
                    int count = 0; // 周围8个位置的活细胞计数
                    for(int k = 0; k < 8; k ++) {
                        int newY = y+dr[k];
                        int newX = x+dc[k];

                        if(newY>=0 && newY<lenY && newX>=0 && newX<lenX) {
                            if(board[newY][newX] == 1) {
                                count ++;
                            }
                        }
                    }

                    if(count == 3) {
                        minor[y][x] = 1;
                    }
                }
            }
        }
    }

    /**
     * 解法二：
     * 采用原地解法，减少空间消耗
     * @param board
     */
    private void gameOfLife2(int[][] board) {

    }

    static class TestCase {
        public static int[][] ans_board = {{0,0,0}, {1,0,1}, {0,1,1}, {0,1,0}};
        public static int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};

        public static int[][] ans_board1 = {{0,0,0}, {1,0,1}, {0,1,1}, {0,1,0}};
        public static int[][] board1 = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};

        public static int[][] ans_board2 = {{0,0,0}, {1,0,1}, {0,1,1}, {0,1,0}};
        public static int[][] board2 = {{1,1,1}, {1,1,1}, {1,1,1}, {1,1,1}};
        public static int[][] board3 = {};
        public static int[][] board4 = {};
        public static int[][] board5 = {};
        public static int[][] board6 = {};
    }
}
