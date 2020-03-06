/**
 * 
 */
package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Easy 腐烂的橘子
 * 
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 
 * 值 0 代表空单元格； 值 1 代表新鲜橘子； 值 2 代表腐烂的橘子。
 * 
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * 
 * 示例 1：
 * 
 * 输入：[[2,1,1],[1,1,0],[0,1,1]] 输出：4
 * 
 * 示例 2：
 * 
 * 输入：[[2,1,1],[0,1,1],[1,0,1]] 输出：-1 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4
 * 个正向上。
 * 
 * 示例 3：
 * 
 * 输入：[[0,2]] 输出：0 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。  
 * 
 * 提示：
 * 
 * 1 <= grid.length <= 10 1 <= grid[0].length <= 10 grid[i][j] 仅为 0、1 或 2
 * 通过次数8,299提交次数17,563
 * 
 * @author vann
 * @date Mar 4, 2020
 */
public class LeetCode_994 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LeetCode_994 leetCode = new LeetCode_994();

		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int result = leetCode.orangesRotting(grid);
		System.out.println("Result=4, action=" + result);
//		
		int[][] grid1 = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
		int result1 = leetCode.orangesRotting(grid1);
		System.out.println("Result=-1, action=" + result1);

		int[][] grid2 = { { 0, 2 } };
		int result2 = leetCode.orangesRotting(grid2);
		System.out.println("Result=0, action=" + result2);

		int[][] grid3 = { { 1, 1, 2 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int result3 = leetCode.orangesRotting(grid3);
		System.out.println("Result=4, action=" + result3);
	}

	/**
	 * 分析思路： 1.如果有一个新鲜的橘子，其四个正方向上都是空格子，则返回 -1；（即永远不可能腐坏） 2.假设最开始的腐坏节点坐标为
	 * x,y。整个过程完成后需要的分钟数为 max(x'-x) + max(y'-y)。 3.
	 * 
	 * @param grid
	 * @return
	 */
	private int orangesRotting(int[][] grid) {
		int result = actionBFS(grid);

		return result;
	}

	/**
	 * 广度优先搜索 BFS。
	 * 
	 * 如果只有一个腐烂的橘子，记录每个新鲜橘子被腐烂的时间。如果最后单元格中没有新鲜橘子了，那么腐烂所有橘子的最短时间是新鲜橘子被腐烂的最大值。
	 * 
	 * @param grid
	 * @param x
	 * @param y
	 * @param xSize
	 * @param ySize
	 * @return
	 */
	private int actionBFS(int[][] grid) {
		int ySize = grid.length;
		int xSize = grid[0].length;

		List<Integer> list = new ArrayList<Integer>();
		// 先找到所有的腐烂节点
		for (int y = 0; y < ySize; y++) {
			for (int x = 0; x < xSize; x++) {
				if (grid[y][x] == 2) {
					int code = y * xSize + x; // 构造唯一索引
					list.add(code);
				}
			}
		}

		if (list.size() == 0) { // 当前无腐烂节点
			return 0;
		}

		// 配合得到 grid[y][x]上下左右的元素
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };

		int res = 0;
		int n = 0;
		while (!list.isEmpty()) {
			int code = list.remove(n);
			n ++;
			int y = code / xSize;
			int x = code % xSize;

			// 感染上下左右节点
			for (int k = 0; k < 4; k++) {
				x = x + dx[k];
				y = y + dy[k];
				if (x >= 0 && x <= xSize && y >= 0 && y <= ySize && grid[y][x] == 1) {
					grid[y][x] = 2;
					list.add(y * xSize + x);
				}
			}

			if (!list.isEmpty()) {
				res++;
			}

		}

		for (int y = 0; y < ySize; y++) {
			for (int x = 0; x < xSize; x++) {
				if (grid[y][x] == 1) {
					return -1;
				}
			}
		}

		return res;
	}

	/**
	 * 观察到对于所有的腐烂橘子，其实它们在广度优先搜索上是等价于同一层的节点的。
	 * 
	 * 假设这些腐烂橘子刚开始是新鲜的，而有一个腐烂橘子(我们令其为超级源点)会在下一秒把这些橘子都变腐烂， 而这个腐烂橘子刚开始在的时间是
	 * -1，那么按照广度优先搜索的算法，下一分钟也就是第 0 分钟的时候，
	 * 这个腐烂橘子会把它们都变成腐烂橘子，然后继续向外拓展，所以其实这些腐烂橘子是同一层的节点。
	 * 那么在广度优先搜索的时候，我们将这些腐烂橘子都放进队列里进行广度优先搜索即可，最后每个新鲜橘子被腐烂的最短时间 dis[x][y]
	 * 其实是以这个超级源点的腐烂橘子为起点的广度优先搜索得到的结果。
	 * 
	 * 为了确认是否所有新鲜橘子都被腐烂，可以记录一个变量 cnt 表示当前网格中的新鲜橘子数，广度优先搜索的时候如果有新鲜橘子被腐烂，则 cnt-=1
	 * ，最后搜索结束时如果 cnt 大于 0 ，说明有新鲜橘子没被腐烂，返回 −1
	 * ，否则返回所有新鲜橘子被腐烂的时间的最大值即可，也可以在广度优先搜索的过程中把已腐烂的新鲜橘子的值由 1 改为 2，最后看网格中是否由值为 1
	 * 即新鲜的橘子即可。
	 * 
	 * @param grid
	 * @return
	 */
	private int actionBrowBFS(int[][] grid) {
		int ySize = grid.length, xSize = grid[0].length;

		Queue<Integer> queue = new ArrayDeque();
		Map<Integer, Integer> depth = new HashMap<Integer, Integer>();

		for (int y = 0; y < ySize; ++y) {
			for (int x = 0; x < xSize; ++x) {
				if (grid[y][x] == 2) {
					int code = y * xSize + x; // 转化为索引唯一的一维数组
					queue.add(code); // 存储腐烂橘子
					depth.put(code, 0); // 存储腐烂橘子变为腐烂的时间，key 为橘子的一维数组下标,value为橘子变为腐烂的时间
				}
			}
		}

		int ans = 0;
		// 配合得到 grid[y][x]上下左右的元素
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };

		while (!queue.isEmpty()) {
			int code = queue.remove();
			int y = code / xSize;
			int x = code % xSize;

			for (int k = 0; k < 4; ++k) {
				int ny = y + dy[k];
				int nx = x + dx[k];

				if (0 <= ny && ny < ySize && 0 <= nx && nx < xSize && grid[ny][nx] == 1) {
					grid[ny][nx] = 2;
					int ncode = ny * xSize + nx;
					queue.add(ncode);
					// 记次数的关键。元素grid[y][x]的上下左右元素腐烂时间应该一致
					depth.put(ncode, depth.get(code) + 1);
					ans = depth.get(ncode);
				}
			}
		}

		for (int[] row : grid) {
			for (int v : row) {
				if (v == 1) {
					return -1;
				}
			}
		}

		return ans;
	}

}
