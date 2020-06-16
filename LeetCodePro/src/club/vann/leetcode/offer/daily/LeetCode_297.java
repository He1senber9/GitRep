package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Hard</p>
 * <p>题目：二叉树的序列化与反序列化</p>
 * <p>描述：序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * 通过次数27,791提交次数56,763
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/16
 * Time: 10:19
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_297 {
    public static void main(String[] args) {
        LeetCode_297 leetCode = new LeetCode_297();

        String serializeString = null;
        TreeNode deserializeTreeNode = null;
        Codec codec = leetCode.new Codec();

        serializeString = codec.serialize(TestCase.fun());
        System.out.println("序列化：" + serializeString);
        deserializeTreeNode = codec.deserialize(serializeString);
        System.out.println("反序列化：" + deserializeTreeNode);

    }

    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return null;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return null;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

    static class TestCase {
        public static TreeNode fun() {
            TreeNode root = new TreeNode(1);

            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            root.left = node2;
            root.right = node3;

            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(5);
            node3.left = node4;
            node3.right = node5;

            return root;
        }
    }
}
