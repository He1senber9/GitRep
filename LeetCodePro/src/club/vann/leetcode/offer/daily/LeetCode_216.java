package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：组合总和III</p>
 * <p>描述：找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 通过次数42,778提交次数58,199
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-09-11 15:32
 **/
public class LeetCode_216 {
    public static void main(String[] args) {
        LeetCode_216 leetCode = new LeetCode_216();

        List<List<Integer>> res = null;
        res = leetCode.combinationSum3(TestCase.K, TestCase.N);

        res = leetCode.combinationSum3(TestCase.K1, TestCase.N1);
        System.out.println("Success");
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n == 0 || k == 0) {
            return res;
        }

        LinkedList<Integer> list = new LinkedList<>();
        helper(res, list, k, n, 1);

        return res;
    }

    private void helper(List<List<Integer>> res, LinkedList<Integer> list, int k, int n, int begin) {
        if(n == 0 && k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if(n == 0 || k == 0) {
            return;
        }

        for(int i = begin; i <= 9; i ++) {
            list.addLast(i);
            helper(res, list, k - 1, n - i, ++begin);
            list.removeLast();
        }

    }

    static class TestCase {
        public static int K = 3;
        public static int N = 7;

        public static int K1 = 3;
        public static int N1 = 9;
    }
}
