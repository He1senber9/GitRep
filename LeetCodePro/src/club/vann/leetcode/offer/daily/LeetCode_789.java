package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：逃脱阻碍者</p>
 * <p>描述：你在进行一个简化版的吃豆人游戏。你从 [0, 0] 点开始出发，你的目的地是 target = [xtarget, ytarget] 。地图上有一些阻碍者，以数组 ghosts 给出，第 i 个阻碍者从 ghosts[i] = [xi, yi] 出发。所有输入均为 整数坐标 。
 *
 * 每一回合，你和阻碍者们可以同时向东，西，南，北四个方向移动，每次可以移动到距离原位置 1 个单位 的新位置。当然，也可以选择 不动 。所有动作 同时 发生。
 *
 * 如果你可以在任何阻碍者抓住你 之前 到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。
 *
 * 只有在你有可能成功逃脱时，输出 true ；否则，输出 false 。
 *
 *  
 * 示例 1：
 *
 * 输入：ghosts = [[1,0],[0,3]], target = [0,1]
 * 输出：true
 * 解释：你可以直接一步到达目的地 (0,1) ，在 (1, 0) 或者 (0, 3) 位置的阻碍者都不可能抓住你。
 * 示例 2：
 *
 * 输入：ghosts = [[1,0]], target = [2,0]
 * 输出：false
 * 解释：你需要走到位于 (2, 0) 的目的地，但是在 (1, 0) 的阻碍者位于你和目的地之间。
 * 示例 3：
 *
 * 输入：ghosts = [[2,0]], target = [1,0]
 * 输出：false
 * 解释：阻碍者可以和你同时达到目的地。
 * 示例 4：
 *
 * 输入：ghosts = [[5,0],[-10,-2],[0,-5],[-2,-2],[-7,1]], target = [7,7]
 * 输出：false
 * 示例 5：
 *
 * 输入：ghosts = [[-1,0],[0,1],[-1,0],[0,1],[-1,0]], target = [0,0]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= ghosts.length <= 100
 * ghosts[i].length == 2
 * -104 <= xi, yi <= 104
 * 同一位置可能有 多个阻碍者 。
 * target.length == 2
 * -104 <= xtarget, ytarget <= 104
 * 通过次数6,371提交次数9,649
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/escape-the-ghosts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-08-22  10:27:17
 */
public class LeetCode_789 {
    public static void main(String[] args) {
        LeetCode_789 leetCode = new LeetCode_789();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.escapeGhosts(TestCase.GHOSTS, TestCase.TARGET));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.escapeGhosts(TestCase.GHOSTS1, TestCase.TARGET1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.escapeGhosts(TestCase.GHOSTS2, TestCase.TARGET2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.escapeGhosts(TestCase.GHOSTS3, TestCase.TARGET3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.escapeGhosts(TestCase.GHOSTS4, TestCase.TARGET4));
    }

    /**
     * 解法一：
     *
     * @param ghosts
     * @param target
     * @return
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = {0, 0};
        int distance = manhattanDistance(source, target);
        for (int[] ghost : ghosts) {
            int ghostDistance = manhattanDistance(ghost, target);
            if (ghostDistance <= distance) {
                return false;
            }
        }
        return true;
    }

    public int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[][] GHOSTS = {{1, 0}, {0, 3}};
        public static int[] TARGET = {0,1};

        public static boolean ANS1 = false;
        public static int[][] GHOSTS1 = {{1, 0}};
        public static int[] TARGET1 = {2,0};

        public static boolean ANS2 = false;
        public static int[][] GHOSTS2 = {{2,0}};
        public static int[] TARGET2 = {1,0};

        public static boolean ANS3 = false;
        public static int[][] GHOSTS3 = {{5, 0}, {-10, -2}, {0, -5}, {-2, -2}, {-7, 1}};
        public static int[] TARGET3 = {7,7};

        public static boolean ANS4 = true;
        public static int[][] GHOSTS4 = {{-1, 0}, {0, 1}, {-1, 0}, {0, 1}, {-1, 0}};
        public static int[] TARGET4 = {0,0};
    }
}
