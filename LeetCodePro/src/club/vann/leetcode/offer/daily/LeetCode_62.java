package club.vann.leetcode.offer.daily;

import java.util.LinkedList;

/**
 * <p>难度：Easy</p>
 * <p>题目：圆圈中最后剩下的数字</p>
 * <p>描述：0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * 通过次数8,156提交次数13,938
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-03-30 11:01
 **/
public class LeetCode_62 {
    public static void main(String[] args) {
        int result = 0;
        LeetCode_62 leetCode = new LeetCode_62();
        TestCase testCase = leetCode.new TestCase();

        result = leetCode.lastRemaining(testCase.case1[0], testCase.case1[1]);
        System.out.println("Result[3] : " + result);

        result = leetCode.lastRemaining(testCase.case2[0], testCase.case2[1]);
        System.out.println("Result[2] : " + result);

        result = leetCode.lastRemaining(testCase.case3[0], testCase.case3[1]);
        System.out.println("Result[] : " + result);

        result = leetCode.lastRemaining(testCase.case4[0], testCase.case4[1]);
        System.out.println("Result[] : " + result);

        result = leetCode.lastRemaining(testCase.case5[0], testCase.case5[1]);
        System.out.println("Result[] : " + result);
    }

    /**
     * 解法一：
     * 采用链表的形式删除。
     * @param n
     * @param m
     * @return
     */
    private int lastRemaining(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < n; i ++) {
            list.add(i);
        }

        while(!list.isEmpty() && list.size() > 1) {
            int index = 1;
            while(index < m) {
                int v = list.pollFirst();
                list.offerLast(v);
                index ++;
            }

            list.pollFirst();
        }



        return list.pop();
    }

    class TestCase {
        public final int[] case1 = {5, 3};
        public final int[] case2 = {10, 17};
        public final int[] case3 = {6, 3};
        public final int[] case4 = {7, 3};
        public final int[] case5 = {70866, 116922};
    }
}
