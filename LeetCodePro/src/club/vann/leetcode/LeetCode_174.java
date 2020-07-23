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

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.calculateMinimumHP(TestCase.DUNGEON));
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

        // dp[y][x][0] 所需最小初始值，dp[y][x][1] 生命值
        int[][][] dp = new int[lenY][lenX][2];
        for(int y = 0; y < lenY; y ++) {
            for(int x = 0; x < lenX; x ++) {
                if(x==0 && y==0) {
                    dp[y][x][0] = dungeon[y][x] < 0 ? 1-dungeon[y][x] : 1;
                } else if(x == 0) {
                    dp[y][x][0] = dungeon[y][x] < 0 ? Math.max(dp[y-1][x][0] - dungeon[y][x], dp[y-1][x][0]) : dp[y-1][x][0];
                } else if(y == 0) {
                    dp[y][x][0] = dungeon[y][x] < 0 ? Math.max(dp[y][x-1][0] - dungeon[y][x], dp[y][x-1][0]) : dp[y][x-1][0];
                } else {
                    int v1 = dungeon[y][x] < 0 ? Math.max(dp[y-1][x][0] - dungeon[y][x], dp[y-1][x][0])  : dp[y-1][x][0];
                    int v2 = dungeon[y][x] < 0 ? Math.max(dp[y][x-1][0] - dungeon[y][x], dp[y][x-1][0]) : dp[y][x-1][0];
                    dp[y][x][0] = Math.min(v1,v2);
                }
                dp[y][x][1] = dp[y][x][0] + dungeon[y][x];
            }
        }
        return dp[lenY-1][lenX-1][0];
    }
    
    static class TestCase {
        public static int ANS = 7;
        public static int[][] DUNGEON = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
    }
}
