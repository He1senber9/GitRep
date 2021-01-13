package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Hard</p>
 * <p>题目：冗余连接II</p>
 * <p>描述：在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 *
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
 *
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 *
 * 示例 1:
 *
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的有向图如下:
 *   1
 *  / \
 * v   v
 * 2-->3
 * 示例 2:
 *
 * 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * 输出: [4,1]
 * 解释: 给定的有向图如下:
 * 5 <- 1 -> 2
 *      ^    |
 *      |    v
 *      4 <- 3
 * 注意:
 *
 * 二维数组大小的在3到1000范围内。
 * 二维数组中的每个整数在1到N之间，其中 N 是二维数组的大小。
 * 通过次数16,297提交次数36,595
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_685
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/13 10:34
 */
public class LeetCode_685 {
    public static void main(String[] args) {
        LeetCode_685 leetCode = new LeetCode_685();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + leetCode.findRedundantDirectedConnection(TestCase.EDGES));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + leetCode.findRedundantDirectedConnection(TestCase.EDGES));
    }

    /**
     * 解法一：
     *
     * @param edges
     * @return
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        return null;
    }

    static class TestCase {
        public static int[] ANS = {2,3};
        public static int[][] EDGES = {{1, 2}, {1, 3}, {2, 3}};

        public static int[] ANS1 = {4,1};
        public static int[][] EDGES1 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
    }
}
