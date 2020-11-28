package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>难度：Hard</p>
 * <p>题目：翻转对</p>
 * <p>描述：给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 * 通过次数8,995提交次数29,761
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-28 08:14
 **/
public class LeetCode_493 {
    public static void main(String[] args) {
        LeetCode_493 leetCode = new LeetCode_493();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.reversePairs1(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.reversePairs1(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.reversePairs1(TestCase.NUMS2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.reversePairs1(TestCase.NUMS3));
    }

    /**
     * 解法一：
     * 暴力破解
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int ans = 0;
        int len = nums.length;

        for(int i = 0; i < len-1; i ++) {
            for(int j = i+1; j < len; j ++) {
                if((nums[i] - nums[j]) <= nums[j]) {
                    continue;
                }
                ans ++;
            }
        }
        return ans;
    }

    /**
     * 解法二：
     * 暴力破解
     * @param nums
     * @return
     */
        public int reversePairs1(int[] nums) {
            Set<Long> allNumbers = new TreeSet<Long>();
            for (int x : nums) {
                allNumbers.add((long) x);
                allNumbers.add((long) x * 2);
            }
            // 利用哈希表进行离散化
            Map<Long, Integer> values = new HashMap<Long, Integer>();
            int idx = 0;
            for (long x : allNumbers) {
                values.put(x, idx);
                idx++;
            }

            int ret = 0;
            BIT bit = new BIT(values.size());
            for (int i = 0; i < nums.length; i++) {
                int left = values.get((long) nums[i] * 2), right = values.size() - 1;
                ret += bit.query(right + 1) - bit.query(left + 1);
                bit.update(values.get((long) nums[i]) + 1, 1);
            }
            return ret;
        }

    static class TestCase {
        public static int ANS = 2;
        public static int[] NUMS = {1,3,2,3,1};

        public static int ANS1 = 3;
        public static int[] NUMS1 = {2,4,3,5,1};

        public static int ANS2 = 0;
        public static int[] NUMS2 = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};

        public static int ANS3 = 1;
        public static int[] NUMS3 = {-5, -5};

        public static int ANS4 = 1;
        }
    }

class BIT {
    int[] tree;
    int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

    public void update(int x, int d) {
        while (x <= n) {
            tree[x] += d;
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int ans = 0;
        while (x != 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }
}
