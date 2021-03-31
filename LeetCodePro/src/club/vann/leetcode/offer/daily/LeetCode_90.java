package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：子集II</p>
 * <p>描述：给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * 通过次数74,716提交次数120,125
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2021/3/31
 * Time: 8:31
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_90 {
    public static void main(String[] args) {
        LeetCode_90 leetCode = new LeetCode_90();

        List<List<Integer>> ans = null;
        ans = leetCode.subsetsWithDup(TestCase.NUMS);
        ans = leetCode.subsetsWithDup(TestCase.NUMS1);
        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int tag = (int) Math.pow(2, n);
        for(int mask = 0; mask < tag; mask ++) {
            List<Integer> list = new ArrayList<>();
            boolean flag = true;
            for(int i = 0; i < n; i ++) {
                if((mask & (1 << i)) != 0) {
                    if(i > 0 && (mask >> (i-1) & 1) == 0 && nums[i] == nums[i-1]) {
                        flag = false;
                        break;
                    }
                    list.add(nums[i]);
                }
            }

            if(flag) {
                ans.add(list);
            }
        }
        return ans;
    }

    static class TestCase {
        public static int[] NUMS = {1,2,3};
        public static int[] NUMS1 = {1,2,2};
    }
}
