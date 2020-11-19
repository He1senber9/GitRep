package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：移动零</p>
 * <p>描述：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 通过次数239,338提交次数381,069
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-19 09:36
 **/
public class LeetCode_283 {
    public static void main(String[] args) {
        LeetCode_283 leetCode = new LeetCode_283();

        System.out.print("Result["+TestCase.ANS+"] : ");
        leetCode.moveZeroes(TestCase.NUMS);

        System.out.print("Result["+TestCase.ANS1+"] : ");
        leetCode.moveZeroes(TestCase.NUMS1);

        System.out.print("Result["+TestCase.ANS2+"] : ");
        leetCode.moveZeroes(TestCase.NUMS2);

        System.out.print("Result["+TestCase.ANS3+"] : ");
        leetCode.moveZeroes(TestCase.NUMS3);

        System.out.println("Success");
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;

        for(int i = len-1; i >= 0; i --) {
            if(nums[i] != 0) {
                continue;
            }

            for(int j = i + 1; j < len; j ++) {
                if(nums[j] != 0) {
                    nums[j-1] = nums[j] ^ nums[j-1];
                    nums[j] = nums[j] ^ nums[j-1];
                    nums[j-1] = nums[j] ^ nums[j-1];
                } else {
                    break;
                }
            }
        }
    }

    static class TestCase {
        public static int[] ANS = {1,3,12,0,0};
        public static int[] NUMS = {0,1,0,3,12};

        public static int[] ANS1 = {0,0,0,0,0};
        public static int[] NUMS1 = {0,0,0,0,0};

        public static int[] ANS2 = {1,2,3,4,5};
        public static int[] NUMS2 = {1,2,3,4,5};

        public static int[] ANS3 = {1,2,3,0,0};
        public static int[] NUMS3 = {1,2,3,0,0};
    }
}
