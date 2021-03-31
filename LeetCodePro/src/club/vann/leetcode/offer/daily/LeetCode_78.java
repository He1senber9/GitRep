package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：子集</p>
 * <p>描述：给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
 * nums 中的所有元素 互不相同
 * 通过次数218,970提交次数275,143
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2021/3/31
 * Time: 8:16
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_78 {
    public static void main(String[] args) {
        LeetCode_78 leetCode = new LeetCode_78();

        List<List<Integer>> ans = null;
        ans = leetCode.subsets(TestCase.NUMS);

        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < Math.pow(2, n); i ++) {
            List<Integer> list = new ArrayList<>();
            for(int t = 0; t < n; t ++) {
                if((i & (1 << t)) != 0) {
                    list.add(nums[t]);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    static class TestCase {
        public static int[] NUMS = {1,2,3};
    }
}
