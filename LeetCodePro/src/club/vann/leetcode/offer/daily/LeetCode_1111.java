package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * <p>难度：Midum</p>
 * <p>题目：有效括号的嵌套深度</p>
 * <p>描述：有效括号字符串 仅由 "(" 和 ")" 构成，并符合下述几个条件之一：
 *
 * 空字符串
 * 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 * 嵌套，可以记作 (A)，其中 A 是有效括号字符串
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 *
 * s 为空时，depth("") = 0
 * s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 * s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
 *
 * 给你一个有效括号字符串 seq，将其分成两个不相交的子序列 A 和 B，且 A 和 B 满足有效括号字符串的定义（注意：A.length + B.length = seq.length）。
 *
 * 现在，你需要从中选出 任意 一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小。
 *
 * 返回长度为 seq.length 答案数组 answer ，选择 A 还是 B 的编码规则是：如果 seq[i] 是 A 的一部分，那么 answer[i] = 0。否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回 一个。
 *

 * 示例 1：
 *
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * 示例 2：
 *
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 *  
 *
 * 提示：
 *
 * 1 <= text.size <= 10000
 * 通过次数2,263提交次数3,186
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/1
 * Time: 8:28
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1111 {
    public static void main(String[] args) {
        int[] ans = null;
        int[] result = null;
        LeetCode_1111 leetCode = new LeetCode_1111();
        TestCase testCase = leetCode.new TestCase();

        result = leetCode.maxDepthAfterSplit(testCase.seq);
        System.out.println("Result :" + Arrays.toString(result));

        ans = new int[]{0,0};
        leetCode.printSeq(ans, testCase.seq1);
        result = leetCode.maxDepthAfterSplit(testCase.seq1);
        System.out.println("Result :" + Arrays.toString(result));

        ans = new int[]{0,0,0,0};
        leetCode.printSeq(ans, testCase.seq2);
        result = leetCode.maxDepthAfterSplit(testCase.seq2);
        System.out.println("Result :" + Arrays.toString(result));

        ans = new int[]{0,0,0,0,0,0};
        leetCode.printSeq(ans, testCase.seq3);
        result = leetCode.maxDepthAfterSplit(testCase.seq3);
        System.out.println("Result :" + Arrays.toString(result));

        ans = new int[]{0,0,0,0,0,0,0,0};
        leetCode.printSeq(ans, testCase.seq4);
        result = leetCode.maxDepthAfterSplit(testCase.seq4);
        System.out.println("Result :" + Arrays.toString(result));

        ans = new int[]{0,1,0,1};
        leetCode.printSeq(ans, testCase.seq5);
        result = leetCode.maxDepthAfterSplit(testCase.seq5);
        System.out.println("Result :" + Arrays.toString(result));

        ans = new int[]{0,0,1,0,0,1};
        leetCode.printSeq(ans, testCase.seq6);
        result = leetCode.maxDepthAfterSplit(testCase.seq6);
        System.out.println("Result :" + Arrays.toString(result));

        ans = new int[]{0,0,1,1,0,0,1,1};
        leetCode.printSeq(ans, testCase.seq7);
        result = leetCode.maxDepthAfterSplit(testCase.seq7);
        System.out.println("Result :" + Arrays.toString(result));

        ans = new int[]{0,1,0,1,0,0};
        leetCode.printSeq(ans, testCase.seq8);
        result = leetCode.maxDepthAfterSplit(testCase.seq8);
        System.out.println("Result :" + Arrays.toString(result));

        ans = new int[]{0,1,0,1,0,0,0,0};
        leetCode.printSeq(ans, testCase.seq9);
        result = leetCode.maxDepthAfterSplit(testCase.seq9);
        System.out.println("Result :" + Arrays.toString(result));

        ans = new int[]{0,1,0,1,0,1,0,1};
        leetCode.printSeq(ans, testCase.seq10);
        result = leetCode.maxDepthAfterSplit(testCase.seq10);
        System.out.println("Result :" + Arrays.toString(result));

        ans = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1};
        leetCode.printSeq(ans, testCase.seq11);
        result = leetCode.maxDepthAfterSplit(testCase.seq11);
        System.out.println("Result :" + Arrays.toString(result));

        ans = new int[]{0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,1,1,1};
        leetCode.printSeq(ans, testCase.seq12);
        result = leetCode.maxDepthAfterSplit(testCase.seq12);
        System.out.println("Result :" + Arrays.toString(result));
    }

    /**
     * 解法一：
     * 采用栈辅助
     * @param seq
     * @return
     */
    private int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] result = new int[len];

        if(seq == null || len == 0) {
            return new int[]{};
        }

        char prev = seq.charAt(0);
        result[0] = 0;
        for(int n = 1; n < len; n ++) {
            char cur = seq.charAt(n);
            if(prev == cur) {
                result[n] = result[n-1]==0 ? 1 : 0;
            } else {
                result[n] = result[n];
            }
            prev = cur;
        }

        printSeq(result, seq);
        return result;
    }

    private void printSeq(int[] result, String seq) {
        StringBuilder aBuilder = new StringBuilder();
        StringBuilder bBuilder = new StringBuilder();
        for(int n = 0; n < result.length; n ++) {
            if(result[n] == 0) {
                aBuilder.append(seq.charAt(n));
            } else {
                bBuilder.append(seq.charAt(n));
            }
        }

        System.out.println("A:" + aBuilder.toString() + " , B:" + bBuilder.toString());
    }

    class TestCase {
        public final String seq = "";
        public final String seq1 = "()";
        public final String seq2 = "()()";
        public final String seq3 = "()()()";
        public final String seq4 = "()()()()";

        public final String seq5 = "(())";
        public final String seq6 = "((()))";
        public final String seq7 = "(((())))";

        public final String seq8 = "(())()";
        public final String seq9 = "(())()()";
        public final String seq10 = "(())(())";

        public final String seq11 = "((()(()((()()))((()()((()(()(()())(()(()))))))))))";
        public final String seq12 = "((()(()((()())))))";

        public final String seq13 = "()()()()";
        public final String seq14 = "()(())((()))(((())))";
        public final String seq15 = "((()))";
        public final String seq16 = "(((())))";
        public final String seq17 = "(())(())";
    }
}
