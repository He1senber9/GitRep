package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：你能在你最喜欢的那天吃到你最喜欢的糖果吗？</p>
 * <p>描述：给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 *
 * 你按照如下规则进行一场游戏：
 *
 * 你从第 0 天开始吃糖果。
 * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 *
 * 请你返回得到的数组 answer 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * 输出：[true,false,true]
 * 提示：
 * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 * 示例 2：
 *
 * 输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
 * 输出：[false,true,true,false,false]
 *  
 *
 * 提示：
 *
 * 1 <= candiesCount.length <= 105
 * 1 <= candiesCount[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 3
 * 0 <= favoriteTypei < candiesCount.length
 * 0 <= favoriteDayi <= 109
 * 1 <= dailyCapi <= 109
 * 通过次数4,136提交次数13,728
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-01  08:09:43
 */
public class LeetCode_1744 {
    public static void main(String[] args) {
        LeetCode_1744 leetCode = new LeetCode_1744();

        System.out.println("Result : ");
        System.out.println(Arrays.toString(TestCase.ANS));
        System.out.println(Arrays.toString(leetCode.canEat(TestCase.CANDIE_SCOUNT, TestCase.QUERIES)));
        System.out.println("Result : ");
        System.out.println(Arrays.toString(TestCase.ANS1));
        System.out.println(Arrays.toString(leetCode.canEat(TestCase.CANDIE_SCOUNT1, TestCase.QUERIES1)));
        System.out.println("Result : ");
        System.out.println(Arrays.toString(TestCase.ANS2));
        System.out.println(Arrays.toString(leetCode.canEat(TestCase.CANDIE_SCOUNT2, TestCase.QUERIES2)));
    }

    /**
     * 解法一：
     *
     * @param candiesCount
     * @param queries
     * @return
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = queries.length;
        boolean[] ans = new boolean[n];

//        int[] pre = new int[candiesCount.length];
        long[] pre = new long[candiesCount.length];
        pre[0] = candiesCount[0];
        for(int i = 1; i < candiesCount.length; i ++) {
            pre[i] = pre[i-1] + candiesCount[i];
        }

        for(int i = 0; i < n; i ++) {
            int[] query = queries[i];
            int favoriteTypei = query[0];
            int favoriteDayi = query[1];
            int dailyCapi = query[2];

            // 糖果每天最少吃1个，最多吃dailyCapi个时，第favoriteDayi天吃到糖果区间为[x1,y1]:
            long x1 = (favoriteDayi+1) * 1;
            long y1 = (long) (favoriteDayi+1) * dailyCapi;

            // 第favoriteTypei类型的糖果区间[x2,y2]:
            long x2 = favoriteTypei == 0 ? 1 : pre[favoriteTypei-1]+1;
            long y2 = pre[favoriteTypei];


            ans[i] = !(x1 > y2 || y1 < x2);
        }


        return ans;
    }

    static class TestCase {
        public static boolean[] ANS = {true,false,true};
        public static int[] CANDIE_SCOUNT = {7,4,5,3,8};
        public static int[][] QUERIES = {{0,2,2},{4,2,4},{2,13,1000000000}};

        public static boolean[] ANS1 = {false,true,true,false,false};
        public static int[] CANDIE_SCOUNT1 = {5,2,6,4,1};
        public static int[][] QUERIES1 = {{3,1,2},{4,10,3},{3,10,100},{4,100,30},{1,3,1}};

        public static boolean[] ANS2 = {false,true,true,false,true,false,false,false,false,false,true,false,true,true,true,false,false,false,false,true,false,false,true,true,false,false,true,false,false,false,false,false,false,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,false,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,false,true,true,true,true,true,true,false,true,true,false,true,true,true,true,true,true,true,false,true,true,true,true,true,true,true,true,false,true,false};
        public static int[] CANDIE_SCOUNT2 = {5215,14414,67303,93431,44959,34974,22935,64205,28863,3436,45640,34940,38519,5705,14594,30510,4418,87954,8423,65872,79062,83736,47851,64523,15639,19173,88996,97578,1106,17767,63298,8620,67281,76666,50386,97303,26476,95239,21967,31606,3943,33752,29634,35981,42216,88584,2774,3839,81067,59193,225,8289,9295,9268,4762,2276,7641,3542,3415,1372,5538,878,5051,7631,1394,5372,2384,2050,6766,3616,7181,7605,3718,8498,7065,1369,1967,2781,7598,6562,7150,8132,1276,6656,1868,8584,9442,8762,6210,6963,4068,1605,2780,556,6825,4961,4041,4923,8660,4114};
        public static int[][] QUERIES2 = {{46,4191056,444472063},{75,865431,146060662},{91,244597,840227137},{89,2601754,901415801},{69,1777314,444098682},{78,2957259,231019870},{19,4350225,516815116},{42,4081198,594990005},{59,3176552,508520222},{77,4577766,38900694},{92,320256,1362},{44,3992014,7209},{55,1950613,1370},{97,734069,3066},{39,1188632,661},{58,4526426,6202},{51,3083812,1767},{46,2563654,9680},{21,4012578,7014},{66,2185952,7039},{67,3712445,1239},{0,1840130,185},{35,605159,7105},{94,2269908,416},{68,4117247,2076},{0,4540381,2412},{20,579583,8917},{62,4407388,7127},{17,4468545,6287},{50,3462654,1410},{7,1883037,77},{4,4089924,5849},{5,4340465,3843},{68,596099,5796},{29,542371,5952},{91,441898,2227},{35,912775,6110},{12,267236,3248},{27,990261,771},{76,320119,5220},{23,738123,2504},{66,439801,4436},{18,372357,1654},{51,846227,5325},{80,502088,3751},{49,117408,102},{75,837527,8747},{46,984134,7924},{42,463312,7558},{50,214995,1043},{94,981465,6758},{79,892988,1063},{17,985872,2314},{71,870151,2004},{63,793308,7608},{49,873121,2846},{32,453564,3739},{42,890492,6026},{19,278107,2649},{64,792101,2208},{98,577463,526},{41,572006,748},{99,478120,895},{52,224338,423},{83,532978,600},{67,92281,486},{28,829955,925},{22,171381,749},{82,986821,603},{57,294692,194},{9,730892,973},{69,241093,931},{70,646855,27},{45,233480,669},{60,369922,965},{27,935011,659},{96,667580,837},{7,919344,188},{99,584762,131},{5,93173,898},{16,736395,184},{57,893061,196},{28,352640,924},{87,980414,80},{88,432895,129},{23,461032,85},{73,645991,268},{5,241036,458},{9,422324,785},{28,124913,224},{51,815633,765},{59,894120,559},{70,459876,192},{80,423125,584},{85,824496,142},{18,578975,104},{56,477816,303},{6,702127,400},{43,35371,850},{3,226423,10}};
    }
}
