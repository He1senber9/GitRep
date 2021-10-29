package club.vann.leetcode.offer.daily;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * <p>难度：Hard</p>
 * <p>题目：路径交叉</p>
 * <p>描述：给你一个整数数组 distance 。
 *
 * 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 *
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：distance = [2,1,1,2]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：distance = [1,2,3,4]
 * 输出：false
 * 示例 3：
 *
 *
 * 输入：distance = [1,1,1,1]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= distance.length <= 105
 * 1 <= distance[i] <= 105
 * 通过次数13,631提交次数32,259
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-crossing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author fanyu
 * @create: 2021/10/29 22:46
 */
public class LeetCode_335 {
    public static void main(String[] args) {
        LeetCode_335 leetCode = new LeetCode_335();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.isSelfCrossing(TestCase.DISTANCE));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.isSelfCrossing(TestCase.DISTANCE1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.isSelfCrossing(TestCase.DISTANCE2));
    }

    /**
     * 解法一：
     * @param distance
     * @return
     */
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        for (int i = 3; i < n; ++i) {
            // 第 1 类路径交叉的情况
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }

            // 第 2 类路径交叉的情况
            if (i == 4 && (distance[3] == distance[1]
                    && distance[4] >= distance[2] - distance[0])) {
                return true;
            }

            // 第 3 类路径交叉的情况
            if (i >= 5 && (distance[i - 3] - distance[i - 5] <= distance[i - 1]
                    && distance[i - 1] <= distance[i - 3]
                    && distance[i] >= distance[i - 2] - distance[i - 4]
                    && distance[i - 2] > distance[i - 4])) {
                return true;
            }
        }
        return false;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] DISTANCE = {2,1,1,2};

        public static boolean ANS1 = false;
        public static int[] DISTANCE1 = {1,2,3,4};

        public static boolean ANS2 = true;
        public static int[] DISTANCE2 = {1,1,1,1};
    }
}
