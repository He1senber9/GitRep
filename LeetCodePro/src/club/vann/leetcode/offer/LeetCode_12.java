package club.vann.leetcode.offer;

/**
 * <p>难度：Medium</p>
 * <p>题目：矩阵中的路径</p>
 * <p>描述：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 *
 * 通过次数33,444提交次数75,143
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/18
 * Time: 11:54
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_12 {
    public static void main(String[] args) {
        LeetCode_12 leetCode = new LeetCode_12();
        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.exist(TestCase.BOARD, "ABCCED"));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.exist(TestCase.BOARD1, "abcd"));
    }

    /**
     * 解法一：
     *
     * @param board
     * @param word
     * @return
     */
    private boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j] != words[k]) {
            return false;
        }
        if(k == words.length-1) {
            return true;
        }

        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, words, i, j-1, k+1) || dfs(board, words, i, j+1, k+1)
                || dfs(board, words, i-1, j, k+1) || dfs(board, words, i+1, j, k+1);
        board[i][j] = tmp;
        return res;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static char[][] BOARD = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};

        public static boolean ANS1 = false;
        public static char[][] BOARD1 = {{'a','b'}, {'c','d'}};
    }
}
