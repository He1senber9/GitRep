package club.vann.leetcode;

import java.util.*;

/**
 * <p>难度：Medium</p>
 * <p>题目：全排列II</p>
 * <p>描述：给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * 通过次数85,428提交次数142,912
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-09-04 11:31
 **/
public class LeetCode_47 {
    public static void main(String[] args) {
        LeetCode_47 leetCode = new LeetCode_47();

        List<List<Integer>> res = null;
        res = leetCode.permuteUnique(TestCase.NUMS);
        for(List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        for(int num : nums) {
            list.add(num);
        }

        int n = nums.length;
        helper(n, res, list, 0);
        return res;
    }

    private void helper(int n, List<List<Integer>> res, List<Integer> list, int index) {
        if(index == n-1) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = index; i < n; i ++) {
            // 如果遇到与上一次重复元素，跳过
            if(i > 0 && list.get(i-1) == list.get(i)) {
                continue;
            }

            Collections.swap(list, index, i);
            helper(n, res, list, index+1);
            Collections.swap(list, index, i);
        }

    }

    static class TestCase {
        public static int[] NUMS = {1,1,2};
    }
}
