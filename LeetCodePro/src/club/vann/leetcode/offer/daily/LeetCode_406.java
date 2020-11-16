package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：根据身高重建队列</p>
 * <p>描述：假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 通过次数48,896提交次数71,710
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-16 09:19
 **/
public class LeetCode_406 {
    public static void main(String[] args) {
        LeetCode_406 leetCode = new LeetCode_406();

        System.out.println("Result["+TestCase.ANS+"]" + leetCode.reconstructQueue(TestCase.PEOPLE));
        System.out.println("Result["+TestCase.ANS1+"]" + leetCode.reconstructQueue(TestCase.PEOPLE1));
    }

    /**
     * 解法一：
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        return null;
    }

    static class TestCase {
        public static int[][] ANS = {{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}};
        public static int[][] PEOPLE = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        public static int[][] ANS1 = {};
        public static int[][] PEOPLE1 = {};
    }
}
