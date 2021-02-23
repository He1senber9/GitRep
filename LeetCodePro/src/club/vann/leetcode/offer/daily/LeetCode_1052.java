package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：爱生气的书店老板</p>
 * <p>描述：今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 *
 * 示例：
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *  
 *
 * 提示：
 *
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 * 通过次数11,507提交次数21,131
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-23:08:10:40
 */
public class LeetCode_1052 {
    public static void main(String[] args) {
        LeetCode_1052 leetCode = new LeetCode_1052();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxSatisfied2(TestCase.CUSTOMERS, TestCase.GRUMPY, TestCase.X));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxSatisfied2(TestCase.CUSTOMERS1, TestCase.GRUMPY1, TestCase.X1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxSatisfied2(TestCase.CUSTOMERS2, TestCase.GRUMPY2, TestCase.X2));
    }

    /**
     * 解法一：
     * 暴力破解：时间复杂度O(n^2)
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int res = 0;
        for(int i = 0; i < len; i ++) {
            int sum = 0;
            for(int j = 0; j < len; j ++) {
                if(j >= i && j < i+X) {
                    sum += customers[j];
                } else {
                    if(grumpy[j] == 0) {
                        sum += customers[j];
                    }
                }
            }

            res = Math.max(res, sum);
        }
        return res;
    }

    /**
     * 解法二：
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int res = 0;
        // 记录前缀和
        int[] pre = new int[len+1];
        for(int i = 0; i < len; i ++) {
            if(grumpy[i] == 0) {
                pre[i+1] = pre[i] + customers[i];
            } else {
                pre[i+1] = pre[i];
            }
        }

        for(int i = 0; i < len; i ++) {
            int sum = pre[i];
            for(int j = i; j < len; j ++) {
                if(j < i+X) {
                    sum += customers[j];
                } else {
                    if(grumpy[j] == 0) {
                        sum += customers[j];
                    }
                }
            }

            res = Math.max(res, sum);
        }
        return res;
    }

    /**
     * 解法三：
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int res = 0;
        // 记录前缀和
        int[] pre = new int[len+1];
        for(int i = 0; i < len; i ++) {
            if(grumpy[i] == 0) {
                pre[i+1] = pre[i] + customers[i];
            } else {
                pre[i+1] = pre[i];
            }
        }

        for(int i = 0; i <= len-X; i ++) {
            //区间[0，i-1]
            int sum1 = pre[i];
            //区间[i,i+X-1]
            int sum2 = 0;
            for(int j = i; j <= i+X-1; j ++) {
                sum2 += customers[j];
            }
            //区间[i+X,len-1]
            int sum3 = pre[len] - pre[i+X];

            res = Math.max(res, sum1+sum2+sum3);
        }
        return res;
    }
//
//    /**
//     * 解法四：
//     *
//     * @param customers
//     * @param grumpy
//     * @param X
//     * @return
//     */
//    public int maxSatisfied3(int[] customers, int[] grumpy, int X) {
//        int len = customers.length;
//        int res = 0;
//        // 记录前缀和
//        int[] pre = new int[len+1];
//        for(int i = 0; i < len; i ++) {
//            if(grumpy[i] == 0) {
//                pre[i+1] = pre[i] + customers[i];
//            } else {
//                pre[i+1] = pre[i];
//            }
//        }
//
//        for(int i = 0; i <= len-X; i ++) {
//            //区间[0，i-1]
//            int sum1 = pre[i];
//            //区间[i,i+X-1]
//            int sum2 = 0;
//            for(int j = i; j <= i+X-1; j ++) {
//                sum2 += customers[j];
//            }
//            //区间[i+X,len-1]
//            int sum3 = pre[len] - pre[i+X];
//
//            res = Math.max(res, sum1+sum2+sum3);
//        }
//        return res;
//    }


    static class TestCase {
        public static int ANS = 16;
        public static int[] CUSTOMERS = {1,0,1,2,1,1,7,5};
        public static int[] GRUMPY = {0,1,0,1,0,1,0,1};
        public static int X = 3;

        public static int ANS1 = 24;
        public static int[] CUSTOMERS1 = {4,10,10};
        public static int[] GRUMPY1 = {1,1,0};
        public static int X1 = 2;

        public static int ANS2 = 10;
        public static int[] CUSTOMERS2 = {2,4,1,4,1};
        public static int[] GRUMPY2 = {1,0,1,0,1};
        public static int X2 = 2;
    }
}
