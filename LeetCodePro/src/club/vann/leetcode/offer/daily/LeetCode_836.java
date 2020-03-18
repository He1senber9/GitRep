package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：矩形重叠</p>
 * <p>描述：矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 *
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 *
 * 给出两个矩形，判断它们是否重叠并返回结果。
 *
 * 示例 1：
 *
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
 * 矩形中的所有坐标都处于 -10^9 和 10^9 之间。
 * 通过次数11,282提交次数23,181
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-overlap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/18
 * Time: 10:57
 * Description:
 */
public class LeetCode_836 {
    public static void main(String[] args) {
        int[] rec1 = {};
        int[] rec2 = {};
        boolean result = false;
        LeetCode_836 leetCode = new LeetCode_836();

//        rec1 = new int[]{0,0,2,2};
//        rec2 = new int[]{1,1,3,3};
//        result = leetCode.isRectangleOverlap(rec1, rec2);
//        System.out.println("Result[true] : " + result);
//
//        rec1 = new int[]{0,0,1,1};
//        rec2 = new int[]{1,0,2,1};
//        result = leetCode.isRectangleOverlap(rec1, rec2);
//        System.out.println("Result[false] : " + result);
//
//        rec1 = new int[]{0,0,2,2};
//        rec2 = new int[]{2,2,3,3};
//        result = leetCode.isRectangleOverlap(rec1, rec2);
//        System.out.println("Result[false] : " + result);
//
//        rec1 = new int[]{0,0,2,2};
//        rec2 = new int[]{2,0,3,3};
//        result = leetCode.isRectangleOverlap(rec1, rec2);
//        System.out.println("Result[false] : " + result);
//
//        rec1 = new int[]{-7,-3,10,5};
//        rec2 = new int[]{-6,-5,5,10};
//        result = leetCode.isRectangleOverlap(rec1, rec2);
//        System.out.println("Result[true] : " + result);

        rec1 = new int[]{-124947857,-551326413,11740453,-466518702};
        rec2 = new int[]{-377755273,135508984,65835564,191597900};
        result = leetCode.isRectangleOverlap(rec1, rec2);
        System.out.println("Result[false] : " + result);
    }

    /**
     * 解法一：
     * 思路：由于确定的是左下角和右上角坐标
     * @param rec1
     * @param rec2
     * @return
     */
    private boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long x1 = rec1[0], y1 = rec1[1];
        long x2 = rec1[2], y2 = rec1[3];
        long x3 = rec2[0], y3 = rec2[1];
        long x4 = rec2[2], y4 = rec2[3];

        if(x1 <= x3 && x3 < x2 && y3 < y2 && y4 > y1) {
            return true;
        }

        if(x1 < x4 && x4 <= x2 && y4 > y1 && y3 < y2) {
            return true;
        }

        if(x3 <= x1 && x1 < x4 && y1 < y4 && y2 > y3) {
            return true;
        }

        if(x3 < x2 && x2 <= x4 && y2 > y3 && y1 < y4) {
            return true;
        }
        return false;
    }
}
