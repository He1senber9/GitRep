package club.vann.leetcode.offer.daily;

import java.math.BigDecimal;

/**
 * <p>难度：Easy</p>
 * <p>题目：缀点成线</p>
 * <p>描述：在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 *
 *
 *
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 * 通过次数12,414提交次数26,120
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_1232
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/17 8:42
 */
public class LeetCode_1232 {
    public static void main(String[] args) {
        LeetCode_1232 leetCode = new LeetCode_1232();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.checkStraightLine(TestCase.COORDINATES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.checkStraightLine(TestCase.COORDINATES1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.checkStraightLine(TestCase.COORDINATES2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.checkStraightLine(TestCase.COORDINATES3));
    }

    /**
     * 解法一：
     *
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        if(len <=2) {
            return true;
        }

        for(int i = 1; i < len-1; i ++) {
            if((coordinates[i][0]-coordinates[0][0]) * (coordinates[len-1][1]-coordinates[i][1]) != (coordinates[len-1][0]-coordinates[i][0]) * (coordinates[i][1]-coordinates[0][1])) {
                return false;
            }
        }
        return true;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[][] COORDINATES = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};

        public static boolean ANS1 = false;
        public static int[][] COORDINATES1 = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};

        public static boolean ANS2 = true;
        public static int[][] COORDINATES2 = {{1,2},{1,3},{1,-1}};

        public static boolean ANS3 = true;
        public static int[][] COORDINATES3 = {{2, 1}, {4, 2}, {6, 3}};
    }
}
