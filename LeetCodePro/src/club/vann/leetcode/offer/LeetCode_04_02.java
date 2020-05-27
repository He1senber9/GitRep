package club.vann.leetcode.offer;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：最小高度树</p>
 * <p>描述：给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 * 通过次数6,856提交次数8,727
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-05-23 09:11
 **/
public class LeetCode_04_02 {

    public static void main(String[] args) {
        LeetCode_04_02 leetCode = new LeetCode_04_02();
        TreeNode result = null;

        result = leetCode.sortedArrayToBST(TestCase.nums);
        result = leetCode.sortedArrayToBST(TestCase.nums1);
        result = leetCode.sortedArrayToBST(TestCase.nums2);
        result = leetCode.sortedArrayToBST(TestCase.nums3);
        result = leetCode.sortedArrayToBST(TestCase.nums4);
        System.out.println("Succ");
    }

    /**
     * 解法一：
     * 线索：二叉搜索树，数组单调递增
     * 因为数组单调递增，那么根节点最可能是数组元素中索引为[middle]或者[middle+]的元素
     * @param nums
     * @return
     */
    private TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        int len = nums.length;
        // direct 用于判断方向
        TreeNode root = sortedArrayToBST(nums, 0, len-1);
        return root;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        // 用于计算中间节点
        int middle = (left + right + 1) / 2;

        if(left <= middle && middle <= right) {
            TreeNode node = new TreeNode(nums[middle]);
            node.left = sortedArrayToBST(nums, left, middle-1);
            node.right = sortedArrayToBST(nums, middle+1, right);
            return node;
        }

        return null;
    }

    static class TestCase {
        public static final int[] nums = {-1,0,1};
        public static final int[] nums1 = {-10,-3,0,5,9};
        public static final int[] nums2 = {-11,-10,-3,0,5,9,10};
        public static final int[] nums3 = {-12,-11,-10,-3,0,5,9,10,11};
        public static final int[] nums4 = {-13,-12,-11,-10,-3,0,5,9,10,11,12};
    }

}
