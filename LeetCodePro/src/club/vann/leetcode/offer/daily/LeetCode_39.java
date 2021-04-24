package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：组合总和</p>
 * <p>描述：给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * 通过次数245,411提交次数339,343
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_39
 * @Description TODO
 * @User fanyu
 * @Date 2021/4/24 9:35
 */
public class LeetCode_39 {
    public static void main(String[] args) {
        LeetCode_39 leetCode = new LeetCode_39();

        List<List<Integer>> ans = null;
        ans = leetCode.combinationSum(TestCase.CANDIDATES, TestCase.TARGET);
        ans = leetCode.combinationSum(TestCase.CANDIDATES1, TestCase.TARGET1);
        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        helper(ans, path, candidates, 0, target);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> path, int[] candidates, int index, int target) {
        if(target == 0 || index >= candidates.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i = index; i < candidates.length; i ++) {
            if(candidates[i] > target) {
                continue;
            }

            int pow = target/candidates[i];
            for(int j = pow; j > 0; j --) {
                for(int t = 1; t <= j; t ++) {
                    path.add(candidates[i]);
                }
                helper(ans, path, candidates, i+1, target-candidates[i]*j);
                for(int t = 1; t <= j; t ++) {
                    path.remove(path.size()-1);
                }
            }
        }
    }

    static class TestCase {
        public static int[] CANDIDATES = {2,3,6,7};
        public static int TARGET = 7;

        public static int[] CANDIDATES1 = {2,3,5};
        public static int TARGET1 = 8;
    }
}
