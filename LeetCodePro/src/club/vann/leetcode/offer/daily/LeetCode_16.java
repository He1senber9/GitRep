package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：最接近的三数之和</p>
 * <p>描述：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * 通过次数111,691提交次数250,939
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/24
 * Time: 7:33
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_16 {
    public static void main(String[] args) {
        LeetCode_16 leetCode = new LeetCode_16();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.threeSumClosest(TestCase.nums, 1));
    }

    /**
     * 解法一：
     * 暴力破解
     * @param nums
     * @param target
     * @return
     */
    private int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return 0;
        }

        int ans = 0;
        int offset = Integer.MAX_VALUE;
        int len = nums.length;
        for(int x = 0; x < len-2; x ++) {
            for(int y = x+1; y < len-1; y ++) {
                for(int z = y+1; z < len; z ++) {
                    int t = Math.abs((nums[x] + nums[y] + nums[z]) - target);
                    if(t < offset) {
                        ans = (nums[x] + nums[y] + nums[z]);
                        offset = t;
                    }
                }
            }
        }
        return ans;
    }

    static class TestCase {
        public static final int ans = 2;
        public static final int[] nums = {-1,2,1,-4};
    }
}
