package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：分发糖果</p>
 * <p>描述：老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * 通过次数37,073提交次数81,222
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/12/24
 * Time: 8:03
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_135 {
    public static void main(String[] args) {
        LeetCode_135 leetCode = new LeetCode_135();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.candy(TestCase.RATINGS));
        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.candy(TestCase.RATINGS));
    }

    /**
     * 解法一：
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        return 0;
    }

    static class TestCase {
        public static int ANS = 5;
        public static int[] RATINGS = {1,0,2};

        public static int ANS1 = 4;
        public static int[] RATINGS1 = {1,2,2};
    }
}
