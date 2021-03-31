package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：情侣牵手</p>
 * <p>描述：N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 *
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 *
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 *
 * 示例 1:
 *
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * 示例 2:
 *
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 * 说明:
 *
 * len(row) 是偶数且数值在 [4, 60]范围内。
 * 可以保证row 是序列 0...len(row)-1 的一个全排列。
 * 通过次数11,047提交次数18,023
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/couples-holding-hands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-14:08:56:58
 */
public class LeetCode_765 {
    public static void main(String[] args) {
        LeetCode_765 leetCode = new LeetCode_765();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minSwapsCouples(TestCase.ROWS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minSwapsCouples(TestCase.ROWS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.minSwapsCouples(TestCase.ROWS2));
    }

    /**
     * 解法一：
     * 并查集
     * @param row
     * @return
     */
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len/2;
        UnionUtil unionUtil = new UnionUtil(len);
        for(int i = 0; i < len; i += 2) {
            int x = row[i];
            int y = row[i+1];

            unionUtil.union(x, y);
        }

        return N - unionUtil.getCount();
    }

    class UnionUtil {
        private int[] parent;
        private int count;

        public UnionUtil(int n) {
            parent = new int[n];
            count = n/2;
            for(int i = 0; i < n; i += 2) {
                parent[i] = parent[i+1] = i;
            }
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if(parentX == parentY) {
                return;
            }

            count --;
            parent[parentX] = parentY;
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int getCount() {
            return this.count;
        }
    }

    static class TestCase {
        public static int ANS = 1;
        public static int[] ROWS = {0, 2, 1, 3};

        public static int ANS1 = 0;
        public static int[] ROWS1 = {3, 2, 0, 1};

        public static int ANS2 = 2;
        public static int[] ROWS2 = {0, 2, 3, 4, 5, 1};
    }
}