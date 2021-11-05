package club.vann.leetcode.race.race20210410;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Medium</p>
 * <p>题目：二叉树染色</p>
 * <p>描述：小扣有一个根结点为 root 的二叉树模型，初始所有结点均为白色，可以用蓝色染料给模型结点染色，模型的每个结点有一个 val 价值。小扣出于美观考虑，希望最后二叉树上每个蓝色相连部分的结点个数不能超过 k 个，求所有染成蓝色的结点价值总和最大是多少？
 *
 * 示例 1：
 *
 * 输入：root = [5,2,3,4], k = 2
 *
 * 输出：12
 *
 * 解释：结点 5、3、4 染成蓝色，获得最大的价值 5+3+4=12
 * image.png
 *
 * 示例 2：
 *
 * 输入：root = [4,1,3,9,null,null,2], k = 2
 *
 * 输出：16
 *
 * 解释：结点 4、3、9 染成蓝色，获得最大的价值 4+3+9=16
 * image.png
 *
 * 提示：
 *
 * 1 <= k <= 10
 * 1 <= val <= 10000
 * 1 <= 结点数量 <= 10000</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2021/4/10
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_2 {
    public static void main(String[] args) {
        LeetCode_2 leetCode = new LeetCode_2();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxValue(TestCase.NODE,TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxValue(TestCase.NODE1,TestCase.K1));
    }

    /**
     * 解法一：
     *
     * @param root
     * @param k
     * @return
     */
    public int maxValue(TreeNode root, int k) {
        if(root == null || k == 0) {
            return 0;
        }



        return 0;
    }

    static class TestCase {
        public static int ANS = 12;
        public static int K = 2;
        public static TreeNode NODE = TreeNode.deserialize("[5,2,3,4]");

        public static int ANS1 = 16;
        public static int K1 = 2;
        public static TreeNode NODE1 = TreeNode.deserialize("[4,1,3,9,null,null,2]");
    }
}
