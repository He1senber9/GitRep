package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Hard</p>
 * <p>题目：计算右侧小于当前元素的个数</p>
 * <p>描述：给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * 通过次数19,194提交次数49,992
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/11
 * Time: 8:34
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_315 {
    public static void main(String[] args) {
        LeetCode_315 leetCode = new LeetCode_315();

        System.out.println("Result["+Arrays.toString(TestCase.ANS)+"] : " + leetCode.countSmaller(TestCase.NUMS));
        System.out.println("Result["+Arrays.toString(TestCase.ANS1)+"] : " + leetCode.countSmaller(TestCase.NUMS1));
    }

    /**
     * 解法一：
     * 暴力破解
     * @param nums
     * @return
     */
    private List<Integer> countSmaller(int[] nums) {
        List<Integer> rest = new ArrayList<>();
        if(nums == null || nums.length < 2) {
            return rest;
        }
        int len = nums.length;
        int[] counts = new int[len];
        counts[len-1] = 0;
        for(int n = len-2; n >= 0; n --) {
            int tag = nums[n];
            int count = 0;
            for(int m = len-1; m > n; m --) {
                if(tag > nums[m]) {
                    count ++;
                }
            }
            counts[n] = count;
        }

        for(int n = 0; n < len; n ++) {
            rest.add(counts[n]);
        }

        return rest;
    }

    private int[] c;
    private int[] a;
    /**
     * 解法二：
     *
     * @param nums
     * @return
     */
    private List<Integer> countSmaller1(int[] nums) {
        List<Integer> resultList = new ArrayList<Integer>();
        discretization(nums);
        init(nums.length + 5);
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            resultList.add(query(id - 1));
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;
    }

    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }

        return ret;
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }

    static class TestCase {
        public static final int[] ANS = {2,1,1,0};
        public static final int[] NUMS = {5,2,6,1};

        public static final int[] ANS1 = {10,9,7,6,4,4,4,3,2,1,0};
        public static final int[] NUMS1 = {10,9,8,7,5,6,8,4,3,2,1};
    }
}
