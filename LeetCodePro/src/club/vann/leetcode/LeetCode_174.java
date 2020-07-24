package club.vann.leetcode;

/**
 * <p>难度：Hard</p>
 * <p>题目：地下城游戏</p>
 * <p>描述：一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 *
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 *
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 *
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 *
 *  
 *
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 *
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 *
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *  
 *
 * 说明:
 *
 * 骑士的健康点数没有上限。
 *
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * 通过次数24,186提交次数50,441
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dungeon-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-23 14:07
 **/
public class LeetCode_174 {
    public static void main(String[] args) {
        LeetCode_174 leetCode = new LeetCode_174();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.calculateMinimumHP1(TestCase.DUNGEON));
    }

    /**
     * 解法一：
     *
     * @param dungeon
     * @return
     */
    private int calculateMinimumHP(int[][] dungeon) {
        int lenY = dungeon.length;
        int lenX = dungeon[0].length;
        return calculateMinimumHP(dungeon, lenY, lenX, 0, 0);
    }

    private int calculateMinimumHP(int[][] dungeon, int lenY, int lenX, int y, int x) {
        // 到达终点
        if(y==lenY-1 && x==lenX-1) {
            return Math.max(1-dungeon[y][x], 1);
        }

        // 边界
        if(y==lenY-1) {
            return Math.max(calculateMinimumHP(dungeon, lenY, lenX, y, x+1)-dungeon[y][x], 1);
        }

        // 边界
        if(x==lenX-1) {
            return Math.max(calculateMinimumHP(dungeon, lenY, lenX, y+1, x)-dungeon[y][x], 1);
        }

        int val = Math.min(calculateMinimumHP(dungeon, lenY, lenX, y+1, x), calculateMinimumHP(dungeon, lenY, lenX, y, x+1));
        return Math.max(val-dungeon[y][x], 1);
    }

    /**
     * 解法二
     *
     * @param dungeon
     * @return
     */
    private int calculateMinimumHP1(int[][] dungeon) {
        int lenY = dungeon.length;
        int lenX = dungeon[0].length;
        int[][] dp = new int[lenY][lenX];

        return calculateMinimumHP1(dungeon, dp, lenY, lenX, 0, 0);
    }

    private int calculateMinimumHP1(int[][] dungeon, int[][] dp, int lenY, int lenX, int y, int x) {
        // 到达终点
        if(y==lenY-1 && x==lenX-1) {
            return Math.max(1-dungeon[y][x], 1);
        }

        if(dp[y][x] > 0) {
            return dp[y][x];
        }

        int res = 0;
        // 边界
        if(y==lenY-1) {
            res = Math.max(calculateMinimumHP(dungeon, lenY, lenX, y, x+1)-dungeon[y][x], 1);
        } else if(x==lenX-1) {
            res = Math.max(calculateMinimumHP(dungeon, lenY, lenX, y+1, x)-dungeon[y][x], 1);
        } else {
            int val1 = calculateMinimumHP(dungeon, lenY, lenX, y+1, x);
            int val2 = calculateMinimumHP(dungeon, lenY, lenX, y, x+1);
            int val = Math.min(val1, val2);
            res = Math.max(val-dungeon[y][x], 1);
        }

        return dp[y][x] = res;
    }

    static class TestCase {
        public static int ANS = 7;
        public static int[][] DUNGEON = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
    }
}
