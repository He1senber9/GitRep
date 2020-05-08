package club.vann.leetcode.offer;

/**
 * <p>难度：Medium</p>
 * <p>题目：二叉搜索树的后序遍历序列</p>
 * <p>描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *  
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *  
 *
 * 提示：
 *
 * 数组长度 <= 1000
 * 通过次数10,767提交次数21,296
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/5/8
 * Time: 20:43
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_33 {
    public static void main(String[] args) {
        LeetCode_33 leetCode = new LeetCode_33();
    }

    /**
     * 解法一：
     * 思路：二叉搜索树，左子节点 < 根节点 < 右子节点
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return false;
    }

    static class TestCase {

    }
}
