package club.vann.leetcode.race;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：找出数组游戏的赢家</p>
 * <p>描述：给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 *
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 *
 * 返回赢得比赛的整数。
 *
 * 题目数据 保证 游戏存在赢家。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [2,1,3,5,4,6,7], k = 2
 * 输出：5
 * 解释：一起看一下本场游戏每回合的情况：
 *
 * 因此将进行 4 回合比赛，其中 5 是赢家，因为它连胜 2 回合。
 * 示例 2：
 *
 * 输入：arr = [3,2,1], k = 10
 * 输出：3
 * 解释：3 将会在前 10 个回合中连续获胜。
 * 示例 3：
 *
 * 输入：arr = [1,9,8,2,3,7,6,4,5], k = 7
 * 输出：9
 * 示例 4：
 *
 * 输入：arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
 * 输出：99
 *
 *
 * 提示：
 *
 * 2 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^6
 * arr 所含的整数 各不相同 。
 * 1 <= k <= 10^9</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/8/2
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5476 {
    public static void main(String[] args) {
        LeetCode_5476 leetCode = new LeetCode_5476();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.getWinner(TestCase.ARR, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.getWinner(TestCase.ARR1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.getWinner(TestCase.ARR2, TestCase.K2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.getWinner(TestCase.ARR3, TestCase.K3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.getWinner(TestCase.ARR4, TestCase.K4));
    }

    /**
     * 解法一：
     *
     * @param arr
     * @param k
     * @return
     */
    private int getWinner(int[] arr, int k) {
        int len = arr.length;
        int base = arr[0];
        int count = 0;
        for(int i = 1; i < len; i ++) {
            if(base > arr[i]) {
                count ++;
            } else {
                base = arr[i];
                count = 1;
            }

            if(count == k) {
                return base;
            }
        }
        return base;
    }

    static class TestCase {
        public static int ANS = 5;
        public static int K = 2;
        public static int[] ARR = {2,1,3,5,4,6,7};

        public static int ANS1 = 3;
        public static int K1 = 10;
        public static int[] ARR1 = {3,2,1};

        public static int ANS2 = 9;
        public static int K2 = 7;
        public static int[] ARR2 = {1,9,8,2,3,7,6,4,5};

        public static int ANS3 = 99;
        public static int K3 = 1000000000;
        public static int[] ARR3 = {1,11,22,33,44,55,66,77,88,99};

        public static int ANS4 = 25;
        public static int K4 = 1;
        public static int[] ARR4 = {1,25,35,42,68,70};

    }
}
