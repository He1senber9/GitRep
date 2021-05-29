package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：和为K的子数组</p>
 * <p>描述：给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * 通过次数112,314提交次数252,602
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-05-29  09:09:54
 */
public class LeetCode_560 {
    public static void main(String[] args) {
        LeetCode_560 leetCode = new LeetCode_560();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.subarraySum(TestCase.NUMS, TestCase.K));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int ans = 0;
        for(int left = 0; left < n; left ++) {
            int sum = 0;
            for(int right = left; right < n; right ++) {
                sum += nums[right];
                if(sum == k) {
                    ans ++;
                }
            }
        }
        return ans;
    }

    /**
     * 解法二：
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int n = nums.length;

        // 前缀和
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i = 1; i < n; i ++) {
            pre[i] = pre[i-1] + nums[i];
        }

        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // 区间[i, j] 的和 sum[i,j] = pre[j] (i==0) or sum[i,j] = pre[j]-pre[i-1](i>0)
        for(int i = 0; i < n; i ++) {
            sum = pre[i];
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0, pre = 0;
        for(int i = 0; i < n; i ++) {
            pre += nums[i];
            if(map.containsKey(pre-k)) {
                count += map.get(pre-k);
            }

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[] NUMS = {1,1,1};
        public static int K = 2;
    }
}
