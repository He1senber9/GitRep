package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Hard</p>
 * <p>题目：N皇后</p>
 * <p>描述：N皇后问题研究的是如何将 n 个皇后放置在 n * n 的棋盘上，并且是皇后彼此之间不能互相攻击。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-10-17 15:10
 **/
public class LeetCode_51 {

    public static void main(String[] args) {
        LeetCode_51 leetCode = new LeetCode_51();

        List<List<String>> res = null;
        res = leetCode.solveNQueens(TestCase.N);
        System.out.println("Success");
    }

    /**
     * 解法一：
     *
      */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        if(n == 0) {
            return res;
        }

        // 记录每行中皇后的位置
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        Set<Integer> col = new HashSet<>();
        Set<Integer> main = new HashSet<>();
        Set<Integer> sub = new HashSet<>();

        solveNQueens(res, queens, n, 0, col, main, sub);

        return res;
    }

    private void solveNQueens(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if(row == n) {
            generateBoard(solutions, queens);
            return;
        }

        for(int i = 0; i < n; i ++) {
            if(columns.contains(i)) {
                continue;
            }

            int mains = row - i;
            if(diagonals1.contains(mains)) {
                continue;
            }

            int subs = row + i;
            if(diagonals2.contains(subs)) {
                continue;
            }

            queens[row] = i;
            columns.add(i);
            diagonals1.add(mains);
            diagonals2.add(subs);

            solveNQueens(solutions, queens, n, row+1, columns, diagonals1, diagonals2);

            queens[row] = -1;
            columns.remove(i);
            diagonals1.remove(mains);
            diagonals2.remove(subs);
        }
    }

    /**
     * 生成字符序列。
     *
     * @param queens
     * @return
     */
    public void generateBoard(List<List<String>> res, int[] queens) {
        List<String> board = new ArrayList<String>();
        for(int i : queens) {
            char[] chars = new char[queens.length];
            Arrays.fill(chars, '.');
            chars[i] = 'Q';
            board.add(new String(chars));
        }
        res.add(board);
    }
    static class TestCase {
        public static int N = 4;

        public static int N1 = 8;
    }
}
