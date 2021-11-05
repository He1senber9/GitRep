package club.vann.leetcode.race.race20210410;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>难度：Easy</p>
 * <p>题目：蓄水</p>
 * <p>描述：给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
 *
 * 升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
 * 蓄水：将全部水桶接满水，倒入各自对应的水缸
 * 每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
 *
 * 注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
 *
 * 示例 1：
 *
 * 输入：bucket = [1,3], vat = [6,8]
 *
 * 输出：4
 *
 * 解释：
 * 第 1 次操作升级 bucket[0]；
 * 第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
 * vat1.gif
 *
 * 示例 2：
 *
 * 输入：bucket = [9,0,1], vat = [0,2,2]
 *
 * 输出：3
 *
 * 解释：
 * 第 1 次操作均选择升级 bucket[1]
 * 第 2~3 次操作选择蓄水，即可完成蓄水要求。
 *
 * 提示：
 *
 * 1 <= bucket.length == vat.length <= 100
 * 0 <= bucket[i], vat[i] <= 10^4</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2021/4/10
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1 {
    public static void main(String[] args) {
        LeetCode_1 leetCode = new LeetCode_1();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.storeWater1(TestCase.BUCKET, TestCase.VAT));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.storeWater1(TestCase.BUCKET1, TestCase.VAT1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.storeWater1(TestCase.BUCKET2, TestCase.VAT2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.storeWater1(TestCase.BUCKET3, TestCase.VAT3));
    }

    /**
     * 解法一：
     *
     * @param bucket
     * @param vat
     * @return
     */
    public int storeWater(int[] bucket, int[] vat) {
        //
        int max = Arrays.stream(vat).max().orElse(-1);
        if(max == 0){
            return 0;
        }

        int n = bucket.length;
        int cost = Integer.MAX_VALUE;
        for(int i = 1; i <= 10000; i++){
            int contrib = i;
            for(int j = 0; j < n; j++){
                int atleast = (vat[j] + i - 1) / i;
                contrib += Math.max(0, atleast - bucket[j]);
            }

            cost = Math.min(cost, contrib);
        }
        return cost;
    }

    /**
     * 解法二：
     *
     * @param bucket
     * @param vat
     * @return
     */
    public int storeWater1(int[] bucket, int[] vat) {
        int n = bucket.length;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) ->{
            return b[0]*a[1] - b[1]*a[0];
        });

        int base = 0, cnt = 0;
        for(int i = 0; i < n; i ++) {
            if(bucket[i] == 0 && vat[i] != 0) {
                // 必须升级该桶
                base ++;
                bucket[i] = 1;
            }

            if(vat[i] != 0) {
                cnt ++;
                priorityQueue.add(new int[]{vat[i], bucket[i]});
            }
        }

        if(cnt == 0) {
            return 0;
        }

        int res = cal(priorityQueue.peek());
        int inc = 0;
        while(!priorityQueue.isEmpty() && priorityQueue.peek()[0] >= priorityQueue.peek()[1]) {
            inc ++;
            int[] cur = priorityQueue.poll();
            priorityQueue.offer(new int[]{cur[0], cur[1]+1});
            int val = inc + cal(priorityQueue.peek());
            res = Math.min(res, val);
        }
        return res+base;
    }

    public int cal(int[] curr){
        int res = curr[0] / curr[1];
        if(curr[0] % curr[1] != 0) {
            res++;
        }
        return(res);
    }

    static class TestCase {
        public static int ANS = 4;
        public static int[] BUCKET = {1,3};
        public static int[] VAT = {6,8};

        public static int ANS1 = 3;
        public static int[] BUCKET1 = {9,0,1};
        public static int[] VAT1 = {0,2,2};

        public static int ANS2 = 2;
        public static int[] BUCKET2 = {1,2,3,4};
        public static int[] VAT2 = {1,2,3,5};

        public static int ANS3 = 1;
        public static int[] BUCKET3 = {1,2,3,4};
        public static int[] VAT3 = {1,2,3,4};
    }
}
