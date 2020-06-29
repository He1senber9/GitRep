package club.vann.leetcode.offer;

/**
 * <p>难度：Medium</p>
 * <p>题目：剪绳子 II</p>
 * <p>描述：给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *  
 *
 * 提示：
 *
 * 2 <= n <= 1000
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 *
 * 通过次数14,328提交次数47,258
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/27
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_14II {
    public static void main(String[] args) {
        LeetCode_14II leetCode = new LeetCode_14II();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.cuttingRope(TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.cuttingRope(TestCase.N1));
    }

    /**
     * 解法一：
     * 绳子最终拆分成 2，3才有意义.
     * 尽可能将绳子以长度 3 等分为多段时，乘积最大。
     * 切分规则：
     * 最优： 33 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,20,1,2 三种情况。
     * 次优： 22 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+11+1 。
     * 最差： 11 。若最后一段绳子长度为 1 ；则应把一份 3 + 1 替换为 2 + 2，因为 2 \times 2 > 3 \times 12×2>3×1。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    private int cuttingRope(int n) {
        if(n <= 3) {
            return n - 1;
        }

        long res=1L;
        int p=(int)1e9+7;
        //贪心算法，优先切三，其次切二
        while(n>4){
            res=res*3%p;
            n-=3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int)(res*n%p);
    }

    static class TestCase {
        public static final int ANS = 1;
        public static final int N = 2;

        public static final int ANS1 = 36;
        public static final int N1 = 10;
    }
}
