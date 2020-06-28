package club.vann.leetcode.offer;

import club.vann.leetcode.common.TreeNode;

/**
 *
 */
public class LeetCode_26 {

	public static void main(String[] args) {
		LeetCode_26 leetCode = new LeetCode_26();

//		System.out.println("Result["+TestCase.ans+"] : " + leetCode.isSubStructure(TestCase.nodes[0], TestCase.nodes[1]));
//		System.out.println("Result["+TestCase.ans1+"] : " + leetCode.isSubStructure(TestCase.nodes1[0], TestCase.nodes1[1]));
	}

	/**
	 * 解法一：
	 *
	 * @param A
	 * @param B
	 * @return
	 */
	private boolean isSubStructure(TreeNode A, TreeNode B) {
//		if(B == null) {
//			return false;
//		}
//		if(A.val == B.val) {
//			return isSubStructure(A.left, B.left) && isSubStructure(A.right, B.right);
//		}
//
//		return isSubStructure(A.left, B) || isSubStructure(A.right, B);
		return false;
	}

	static class TestCase {
//		public static boolean ans = false;
//		public static TreeNode[] nodes = {TreeNode.deserialize("[1,2,3]"), TreeNode.deserialize("[3,1]")};
//
//		public static boolean ans1 = true;
//		public static TreeNode[] nodes1 = {TreeNode.deserialize("[3,4,5,1,2]"), TreeNode.deserialize("[4,1]")};
	}
}
