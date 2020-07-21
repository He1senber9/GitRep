package club.vann.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：数组中数字出现的次数 II</p>
 * <p>描述：在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *  
 *
 * 通过次数19,229提交次数24,280
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-20 16:50
 **/
public class LeetCode_56_II {
    public static void main(String[] args) {
        LeetCode_56_II leetCode = new LeetCode_56_II();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.singleNumber1(TestCase.NUMS));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    private int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        int res = 0;
        for(int k : map.keySet()) {
            if(map.get(k) == 1) {
                res = k;
                break;
            }
        }
        return res;
    }

    /**
     * 解法二：
     *
     * @param nums
     * @return
     */
    private int singleNumber1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] base = new int[32];
        int res = 0;
        for(int num : nums) {
            int tag = 1;
            for(int n = 31; n >= 0 ; n --) {
                if((num & tag) == tag) {
                    base[n] ++;
                }
                tag = tag << 1;
            }
        }

        for(int n = 0; n < 32; n ++) {
            res = res << 1;
            res += base[n] % 3;
        }
        return res;
    }

    static class TestCase {
        public static int ANS = 4;
        public static int[] NUMS = {3,4,3,3};
    }
}
