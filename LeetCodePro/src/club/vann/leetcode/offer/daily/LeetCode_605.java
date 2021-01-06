package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：种花问题</p>
 * <p>描述：假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 *
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * 通过次数47,802提交次数147,558
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2021-01-01 08:20
 **/
public class LeetCode_605 {
    public static void main(String[] args) {
        LeetCode_605 leetCode = new LeetCode_605();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.canPlaceFlowers(TestCase.FLOWERBED, TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.canPlaceFlowers(TestCase.FLOWERBED1, TestCase.N1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.canPlaceFlowers(TestCase.FLOWERBED2, TestCase.N2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.canPlaceFlowers(TestCase.FLOWERBED3, TestCase.N3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.canPlaceFlowers(TestCase.FLOWERBED4, TestCase.N4));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0) {
            return false;
        }

        if(n == 0) {
            return true;
        }

        int len = flowerbed.length;
        int[] tag = new int[len+2];
        tag[0] = 0;
        tag[1] = 0;
        for(int i = 0; i < len; i ++) {
            tag[i+1] = flowerbed[i];
        }

        int sum = 0;
        for(int i = 1; i < len+1; i ++) {
            if(tag[i] == 0 && tag[i-1] == 0 && tag[i+1] == 0) {
                tag[i] = 1;
                sum ++;
            } else if(tag[i] == 0 && (tag[i-1] == 1 || tag[i+1] == 1)) {
                continue;
            } else {
                continue;
            }

            if(sum == n) {
                break;
            }
        }

        return sum == n;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] FLOWERBED = {1,0,0,0,1};
        public static int N = 1;

        public static boolean ANS1 = false;
        public static int[] FLOWERBED1 = {1,0,0,0,1};
        public static int N1 = 2;

        public static boolean ANS2 = false;
        public static int[] FLOWERBED2 = {1,0,0,0,0,1};
        public static int N2 = 2;

        public static boolean ANS3 = true;
        public static int[] FLOWERBED3 = {0,0,1,0,0};
        public static int N3 = 1;

        public static boolean ANS4 = true;
        public static int[] FLOWERBED4 = {0,0,0,0,0,1,0,0};
        public static int N4 = 0;

    }
}
