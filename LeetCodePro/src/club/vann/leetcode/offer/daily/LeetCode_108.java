package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：将有序数组转换为二叉搜索树</p>
 * <p>描述：将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * 通过次数77,458提交次数108,096
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/3
 * Time: 7:03
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_108 {
    public static void main(String[] args) {
        LeetCode_108 leetCode = new LeetCode_108();

        System.out.println(leetCode.sortedArrayToBST(TestCase.NUMS));
        System.out.println(leetCode.sortedArrayToBST(TestCase.NUMS1));
        System.out.println(leetCode.sortedArrayToBST(TestCase.NUMS2));
        System.out.println(leetCode.sortedArrayToBST(TestCase.NUMS3));
        System.out.println(leetCode.sortedArrayToBST(TestCase.NUMS4));
    }

    /**
     * 解法一：
     * @param nums
     * @return
     */
    private TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;

        TreeNode res = sortedArrayToBST(nums, 0, len-1);
        return res;
    }

    private TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if(begin > end) {
            return null;
        }

        int mid = (begin+end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if(begin == end) {
            return node;
        }
        if(mid > 0) {
            node.left = sortedArrayToBST(nums, begin, mid-1);
        }
        if(mid < nums.length-1) {
            node.right = sortedArrayToBST(nums, mid+1, end);
        }
        return node;
    }

    static class TestCase {
        public static final int[] NUMS = {-10,-3,0,5,9};

        public static final int[] NUMS1 = {1,2,3,4,5};

        public static final int[] NUMS2 = {1,2,3,4,5,6};

        public static final int[] NUMS3 = {1,2};

        public static final int[] NUMS4 = {1,2,3};
    }
}
