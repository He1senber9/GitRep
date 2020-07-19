package club.vann.leetcode.race;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/19
 * Time: 10:30
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5464 {
    public static void main(String[] args) {
        LeetCode_5464 leetCode = new LeetCode_5464();

        System.out.println(leetCode.numWaterBottles(9,3));
        System.out.println(leetCode.numWaterBottles(15,4));
        System.out.println(leetCode.numWaterBottles(5,5));
        System.out.println(leetCode.numWaterBottles(2,3));
    }

    /**
     * 解法一：
     *
     * @param numBottles
     * @param numExchange
     * @return
     */
    private int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles; // 已经喝的酒
        int pow = numBottles/numExchange; // 可以换的酒
        int v = numBottles%numExchange;
        while(pow > 0) {
            res += pow;
            int avl = pow+v;
            pow = avl/numExchange;
            v = avl%numExchange;
        }
        return res;
    }
}
