package club.vann.leetcode.offer.daily;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/9/15
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_37 {
    public static void main(String[] args) {
        LeetCode_37 leetCode = new LeetCode_37();
        leetCode.solveSudoku(TestCase.BOARD);
        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param board
     */
    private void solveSudoku(char[][] board) {
        for(int y = 0; y < 9; y ++) {
            for(int x = 0; x < 9; x ++) {
                if(board[y][x] == '.') {

                }
            }
        }
    }

    private boolean helper(char[][] board, int y, int x, char tag) {
//        for(int index = 0; index < 9; index ++) {
//            if(board[index][x] == tag) {
//                return false;
//            }
//
//            if(board[y][index] == tag) {
//                return false;
//            }
//        }
//
//        if(0<= y && y <= 2) {
//
//        } else if(3 <= y && y <= 5) {
//
//        } else {
//
//        }
        return false;
    }

    static class TestCase {
        public static char[][] BOARD = {{'5','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','.'},{'.','.','.','.','8','.','.','7','9'}};
    }
}
