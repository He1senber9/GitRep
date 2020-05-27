package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * <p>难度：Easy</p>
 * <p>题目：对称二叉树</p>
 * <p>描述：给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/5/27
 * Time: 6:59
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_101 {
    public static void main(String[] args) {
        LeetCode_101 leetCode = new LeetCode_101();
        System.out.println("Result[true] : " + leetCode.isSymmetric(TestCase.func1()));
        System.out.println("Result[true] : " + leetCode.isSymmetric(TestCase.func1()));
    }

    /**
     * 解法一：
     * 采用递归方式
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        return isSymmetric(root.left) && isSymmetric(root.right);
    }

    /**
     * 解法二：
     * 采用迭代方式
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {

        return isSymmetric(root.left) && isSymmetric(root.right);
    }

    static class TestCase {
        public static TreeNode func1() {
            TreeNode node1 = new TreeNode(1);
            TreeNode nodel2 = new TreeNode(2);
            TreeNode noder2 = new TreeNode(2);
            node1.left = nodel2;
            node1.right = noder2;

            TreeNode nodel3 = new TreeNode(3);
            TreeNode noder4 = new TreeNode(4);
            nodel2.left = nodel3;
            nodel2.right = noder4;

            TreeNode nodel4 = new TreeNode(4);
            TreeNode noder3 = new TreeNode(3);
            noder2.left = nodel4;
            noder2.right = noder3;

            return node1;
        }
    }
}
