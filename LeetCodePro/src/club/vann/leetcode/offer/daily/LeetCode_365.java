package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Midum</p>
 * <p>题目：水壶问题</p>
 * <p>描述：有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 * 通过次数6,415提交次数20,636</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/21
 * Time: 9:51
 * Description:
 */
public class LeetCode_365 {
    public static void main(String[] args) {
        int x = 0, y = 0, z = 0;
        boolean result = false;
        LeetCode_365 leetCode = new LeetCode_365();

        x = 3;
        y = 5;
        z = 4;
        result = leetCode.canMeasureWater(x, y, z);
        System.out.println("Result[True] : " + result);

        x = 5;
        y = 3;
        z = 4;
        result = leetCode.canMeasureWater(x, y, z);
        System.out.println("Result[True] : " + result);

        x = 2;
        y = 6;
        z = 5;
        result = leetCode.canMeasureWater(x, y, z);
        System.out.println("Result[False] : " + result);

        x = 0;
        y = 0;
        z = 2;
        result = leetCode.canMeasureWater(x, y, z);
        System.out.println("Result[False] : " + result);

        x = 0;
        y = 2;
        z = 0;
        result = leetCode.canMeasureWater(x, y, z);
        System.out.println("Result[True] : " + result);

        x = 0;
        y = 0;
        z = 0;
        result = leetCode.canMeasureWater(x, y, z);
        System.out.println("Result[True] : " + result);

        x = 4;
        y = 6;
        z = 8;
        result = leetCode.canMeasureWater(x, y, z);
        System.out.println("Result[true] : " + result);

        z = 1;
        x = 13;
        y = 11;
        z = 1;
        result = leetCode.canMeasureWater(x, y, z);
        System.out.println("Result[true] : " + result);

        x = 0;
        y = 0;
        z = 1;
        result = leetCode.canMeasureWater(x, y, z);
        System.out.println("Result[False] : " + result);

        x = 6;
        y = 9;
        z = 1;
        result = leetCode.canMeasureWater(x, y, z);
        System.out.println("Result[False] : " + result);

        x = 1;
        y = 1;
        z = 12;
        result = leetCode.canMeasureWater(x, y, z);
        System.out.println("Result[False] : " + result);
    }

    /**
     * 解法一：
     * 1.如果能满足：则最后一定有 x,y中一个是满的，一个是不满的。
     *   假设最后是 x 满了，y 不满，y 中的水现有 t。则 z = t 或者 z = x + t。
     * 2.t =
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    private boolean canMeasureWater(int x, int y, int z) {
        if(z == 0) {
            return true;
        }

        if(x == 0 || y == 0) {
            return (z == 0 || (x+y) == z);
        }

        int min = Math.min(x, y);
        int max = Math.max(x, y);
        int v = max;

        while(min != 0) {
            v = max%min;
            max = min;
            min = v;
        }

        return (z%max == 0);
    }
}
