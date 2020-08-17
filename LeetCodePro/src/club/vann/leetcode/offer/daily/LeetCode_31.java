package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：栈的压入，弹出序列</p>
 * <p>描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *  
 *
 * 提示：
 *
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 * 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/
 *
 * 通过次数30,060提交次数50,676
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-08-17 10:33
 **/
public class LeetCode_31 {

    public static void main(String[] args) {
        LeetCode_31 leetCode = new LeetCode_31();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.validateStackSequences(TestCase.PUSHED, TestCase.POPPED));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.validateStackSequences(TestCase.PUSHED1, TestCase.POPPED1));
    }

    /**
     * 解法一：
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        return false;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] PUSHED = {1,2,3,4,5};
        public static int[] POPPED = {4,5,3,2,1};

        public static boolean ANS1 = false;
        public static int[] PUSHED1 = {1,2,3,4,5};
        public static int[] POPPED1 = {4,3,5,1,2};
    }
}
