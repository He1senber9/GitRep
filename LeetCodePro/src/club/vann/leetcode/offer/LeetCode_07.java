package club.vann.leetcode.offer;

import club.vann.leetcode.common.TreeNode;

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
        int[] preorder = null;
        int[] inorder = null;
        TreeNode result = null;
        LeetCode_07 leetCode = new LeetCode_07();

        preorder = new int[]{3,9,20,15,7};
        inorder = new int[]{9,3,15,20,7};
        result = leetCode.buildTree(preorder, inorder);
        System.out.println("Result[3,9,20,15,7] : " + result.toString());
    }

    /**
     * 思路：
     * 1.前序遍历集合的第一个元素一定是二叉树的根节点。
     * @param preorder 前序遍历集合
     * @param inorder 中序遍历集合
     * @return
     */
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        
        return root;
    }
}
