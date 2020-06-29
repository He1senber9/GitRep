package club.vann.leetcode.offer;

import club.vann.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Midum</p>
 * <p>题目：重建二叉树</p>
 * <p>描述：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 *        3
 *      / \
 *     9  20
 *      /  \
 *     15   7
 *  
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 5000
 *  
 * <p>
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 * 通过次数8,237提交次数12,061
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/15
 * Time: 11:39
 * Description:
 */
public class LeetCode_07 {
    public static void main(String[] args) {
        LeetCode_07 leetCode = new LeetCode_07();

        System.out.println(TreeNode.serialize(leetCode.buildTree1(TestCase.preorder, TestCase.inorder)));
        System.out.println(TreeNode.serialize(leetCode.buildTree1(TestCase.preorder1, TestCase.inorder1)));
        System.out.println(TreeNode.serialize(leetCode.buildTree1(TestCase.preorder2, TestCase.inorder2)));
    }

    /**
     * 思路：
     * 1.前序遍历集合的第一个元素一定是二叉树的根节点。
     * @param preorder 前序遍历集合
     * @param inorder 中序遍历集合
     * @return
     */
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }

    private TreeNode buildTree1(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int n = 0; n < preorder.length; n ++) {
            map.put(inorder[n], n);
        }
        TreeNode root = buildTree1(preorder, inorder, map, 0, preorder.length-1);
        return root;
    }

    /**
     *
     * @param preorder
     * @param inorder
     * @param map
     * @param begin
     * @param end
     * @return
     */
    private TreeNode buildTree1(int[] preorder, int[] inorder, Map<Integer, Integer> map, int begin, int end) {
        if(begin > end) {
            return null;
        }

        // 根节点坐标是中序遍历中 （begin+end)/2
        int mid = (begin+end) / 2;
        TreeNode root = new TreeNode(inorder[mid]);
        root.left = buildTree1(preorder, inorder, map, begin, mid-1);
        root.right = buildTree1(preorder, inorder, map, mid+1, end);

        return root;
    }

    static class TestCase {
        public static final int[] preorder = {3,9,20,15,7};
        public static final int[] inorder = {9,3,15,20,7};

        public static final int[] preorder1 = {0,1,3,7,4,2,5,6};
        public static final int[] inorder1 = {7,3,1,4,0,5,2,6};

        public static final int[] preorder2 = {1,2,3};
        public static final int[] inorder2 = {3,2,1};
    }
}
