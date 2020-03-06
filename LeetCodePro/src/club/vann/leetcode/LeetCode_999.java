package leetcode;

/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符
 * “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 * 返回车能够在一次移动中捕获到的卒的数量。
 * 
 * @author vann
 *
 */
public class LeetCode_999 {

	

	public static void main(String[] args) {
		char[][] arrays = { { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' },
				{ '.', '.', '.', 'R', '.', '.', '.', 'p' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' } };
		char[][] arrays1 = { { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', 'p', 'p', 'p', 'p', 'p', '.', '.' },
				{ '.', 'p', 'p', 'B', 'p', 'p', '.', '.' }, { '.', 'p', 'B', 'R', 'B', 'p', '.', '.' },
				{ '.', 'p', 'p', 'B', 'p', 'p', '.', '.' }, { '.', 'p', 'p', 'p', 'p', 'p', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' } };
		char[][] arrays2 = { { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' },
				{ '.', '.', '.', 'p', '.', '.', '.', '.' }, { 'p', 'p', '.', 'R', '.', 'p', 'B', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'B', '.', '.', '.', '.' },
				{ '.', '.', '.', 'p', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' } };
		
		LeetCode_999 leetCode = new LeetCode_999();
		int code = leetCode.numRookCaptures(arrays2);
		System.out.println(code);
	}
	
	public int numRookCaptures(char[][] board) {
        int len = board.length;
        
        int point_x = 0, point_y = 0;
        out:for(int y = 0; y < len; y ++) {
            for(int x = 0; x < len; x ++) {
                char ch = board[y][x];
                
                if(ch == 'R') {
                    point_x = x;
                    point_y = y;
                    break out;
                }
            }
        }
        
        System.out.println(point_x + " *** " + point_y);
        
        return findCount(board, len, point_y, point_x, 0, 1) + findCount(board, len, point_y, point_x, 0, -1) + findCount(board, len, point_y, point_x, 1, 0) + findCount(board, len, point_y, point_x, -1, 0);
    }
    
    private int findCount(char[][] board, int len, int point_y, int point_x, int dx, int dy) {
        int count = 0;
        while(point_y>=0 && point_y < len && point_x >= 0 && point_x < len && board[point_y][point_x] != 'B') {
            if(board[point_y][point_x] == 'p') {
                count ++;
            }
            
            point_y += dy;
            point_x += dx;
        }
        return count;
    }
}
