package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：全排列</p>
 * <p>描述：给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * 通过次数110,794提交次数147,221
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/25
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_46 {
    public static void main(String[] args) {
        LeetCode_46 leetCode = new LeetCode_46();
        List<List<Integer>> result = null;

        result = leetCode.permute(TestCase.nums);

        System.out.println("Success");
    }

    /**
     * 解法一：
     * 解法上转换为索引的全排列。即 0,1,2,3,...n 的全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null) {
            return result;
        }

        int len = nums.length;
        for(int n = 0; n < len; n ++) {

        }
        return result;
    }
    private List<Integer> permute(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < k; i ++) {

        }
        return list;
    }

    static class TestCase {
        public static final int[] nums = {1,2,3};
    }
}
