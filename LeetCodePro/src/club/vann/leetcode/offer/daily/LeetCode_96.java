package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：不同的二叉搜索树</p>
 * <p>描述：给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 通过次数63,748提交次数93,693
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-15 15:01
 **/
public class LeetCode_96 {
    public static void main(String[] args) {
        LeetCode_96 leetCode = new LeetCode_96();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.numTrees2(TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.numTrees2(TestCase.N1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.numTrees2(TestCase.N2));
    }

    /**
     * 解法一：
     *
     * @param n
     * @return
     */
    private int numTrees(int n) {
        if(n<=2) {
            return n;
        }
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for(int i = 2; i <= n; i ++) {
            for(int j = 1; j <= i; j ++) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }

    private int numTrees1(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    private int numTrees2(int n) {

        return numTrees2(1, n);
    }

    private int numTrees2(int begin, int end) {
        if(begin >= end) {
            return 1;
        }

        int res = 0;
        for(int n = begin; n <= end; n ++) {
            if(n==begin) {
                res += numTrees2(n+1, end);
            } else if(n == end) {
                res += numTrees2(begin, n-1);
            } else {
                res += numTrees2(begin, n-1) * numTrees2(n+1, end);
            }
        }
        return res;
    }

    static class TestCase {
        public static final int ANS = 5;
        public static final int N = 3;

        public static final int ANS1 = 1;
        public static final int N1 = 1;

        public static final int ANS2 = 2;
        public static final int N2 = 2;
    }
}
