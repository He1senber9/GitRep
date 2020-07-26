package club.vann.leetcode.race;

import club.vann.leetcode.common.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/26
 * Time: 11:12
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5474 {
    public static void main(String[] args) {
        LeetCode_5474 leetCode = new LeetCode_5474();

    }

    public int countPairs(TreeNode root, int distance) {
        return 0;
    }

    static class TestCase {
        public static int ANS = 1;
        public static int DISTANCE = 3;
        public static TreeNode NODE = TreeNode.deserialize("[1,2,3,null,4]");

        public static int ANS1 = 2;
        public static int DISTANCE1 = 3;
        public static TreeNode NODE1 = TreeNode.deserialize("[1,2,3,4,5,6,7]");

        public static int ANS2 = 1;
        public static int DISTANCE2 = 3;
        public static TreeNode NODE2 = TreeNode.deserialize("[7,1,4,6,null,5,3,null,null,null,null,null,2]");

        public static int ANS3 = 0;
        public static int DISTANCE3 = 1;
        public static TreeNode NODE3 = TreeNode.deserialize("[100]");

        public static int ANS4 = 1;
        public static int DISTANCE4 = 2;
        public static TreeNode NODE4 = TreeNode.deserialize("[1,1,1]");
    }
}
