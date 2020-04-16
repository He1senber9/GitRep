package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：合并区间</p>
 * <p>描述：给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 通过次数73,582提交次数177,490
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-04-16 09:56
 **/
public class LeetCode_56 {
    public static void main(String[] args) {
        LeetCode_56 leetCode = new LeetCode_56();
    }

    public int[][] merge(int[][] intervals) {
        return null;
    }

    static class TestCase {
        public static int[][] ans = {{1,6},{8,10},{15,18}};
        public static int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        public static int[][] ans1 = {{1,5}};
        public static int[][] intervals1 = {{1,4},{4,5}};
    }
}
