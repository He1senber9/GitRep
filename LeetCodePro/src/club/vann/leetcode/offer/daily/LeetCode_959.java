package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：由斜杠划分区域</p>
 * <p>描述：在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 *
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 *
 * 返回区域的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   " /",
 *   "/ "
 * ]
 * 输出：2
 * 解释：2x2 网格如下：
 *
 * 示例 2：
 *
 * 输入：
 * [
 *   " /",
 *   "  "
 * ]
 * 输出：1
 * 解释：2x2 网格如下：
 *
 * 示例 3：
 *
 * 输入：
 * [
 *   "\\/",
 *   "/\\"
 * ]
 * 输出：4
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
 * 2x2 网格如下：
 *
 * 示例 4：
 *
 * 输入：
 * [
 *   "/\\",
 *   "\\/"
 * ]
 * 输出：5
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
 * 2x2 网格如下：
 *
 * 示例 5：
 *
 * 输入：
 * [
 *   "//",
 *   "/ "
 * ]
 * 输出：3
 * 解释：2x2 网格如下：
 *
 *  
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 30
 * grid[i][j] 是 '/'、'\'、或 ' '。
 * 通过次数5,320提交次数7,555
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_959
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/25 8:54
 */
public class LeetCode_959 {
    public static void main(String[] args) {
        LeetCode_959 leetCode = new LeetCode_959();

//        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.regionsBySlashes(TestCase.GRID));
//        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.regionsBySlashes(TestCase.GRID1));
//        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.regionsBySlashes(TestCase.GRID2));
//        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.regionsBySlashes(TestCase.GRID3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.regionsBySlashes(TestCase.GRID4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.regionsBySlashes(TestCase.GRID5));
    }

    /**
     * 解法一：
     *
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionUtils unionUtils = new UnionUtils(n*n*4);
        for(int i = 0; i < n; i ++) {
            String str = grid[i];

            char[] ch = str.toCharArray();
            for(int j = 0; j < n; j ++) {
                char c = ch[j];
                int begin = j * 4 + (i * n * 4);

                if (i < n - 1) {
                    int bottom = begin+1+n*4+2;
                    unionUtils.uinon(begin+1, bottom);
                }
                if (j < n - 1) {
                    int right = begin+2+4-2;
                    unionUtils.uinon( begin+2, right);
                }

                if(c == ' ') {
                    unionUtils.uinon(begin, begin+1);
                    unionUtils.uinon(begin+1, begin+2);
                    unionUtils.uinon(begin+2, begin+3);
                } else if(c == '/') {
                    unionUtils.uinon(begin, begin+3);
                    unionUtils.uinon(begin+1, begin+2);
                } else {
                    unionUtils.uinon(begin, begin+1);
                    unionUtils.uinon(begin+2, begin+3);
                }

            }
        }
        return unionUtils.count;
    }

    private class UnionUtils {
        int[] parent;
        int count;
        public UnionUtils(int n) {
            parent = new int[n];
            count = n;

            for(int i = 0; i < n; i ++) {
                parent[i] = i;
            }
        }

        public void uinon(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return;
            }

            parent[rootY] = rootX;
            count --;
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }
    }

    static class TestCase {
        public static int ANS = 2;
        public static String[] GRID = {" /", "/ "};

        public static int ANS1 = 1;
        public static String[] GRID1 = {" /", "  "};

        public static int ANS2 = 4;
        public static String[] GRID2 = {"\\/", "/\\"};

        public static int ANS3 = 5;
        public static String[] GRID3 = {"/\\", "\\/"};

        public static int ANS4 = 3;
        public static String[] GRID4 = {"//", "/ "};

        public static int ANS5 = 4;
        public static String[] GRID5 = {"//", "\\\\"};
    }
}
