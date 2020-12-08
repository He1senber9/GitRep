package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：数组拆分成斐波那契序列</p>
 * <p>描述：给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 *
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 *
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 *
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 *
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字。
 * 通过次数7,464提交次数18,359
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-12-08 08:00
 **/
public class LeetCode_842 {
    public static void main(String[] args) {
        LeetCode_842 leetCode = new LeetCode_842();

        System.out.println(leetCode.splitIntoFibonacci(TestCase.STR));
        System.out.println(leetCode.splitIntoFibonacci(TestCase.STR1));
        System.out.println(leetCode.splitIntoFibonacci(TestCase.STR2));
        System.out.println(leetCode.splitIntoFibonacci(TestCase.STR3));
        System.out.println(leetCode.splitIntoFibonacci(TestCase.STR4));
        System.out.println(leetCode.splitIntoFibonacci(TestCase.STR5));
    }

    /**
     * 解法一：
     * 回溯算法统计
     * @param S
     * @return
     */
    public List<Integer> splitIntoFibonacci(String S) {
        char[] ch = S.toCharArray();
        List<Integer> result = new ArrayList<>();
        help(result, 0, 0, ch, 0);
        return result;
    }

    private boolean help(List<Integer> result, int pre1, int pre2, char[] ch, int index) {
        if(ch.length == index) {
            return result.size() >= 3;
        }

        long val = 0L;
        for(int i = index; i < ch.length; i ++) {
            if(i > index && ch[index] == '0') {
                break;
            }
            val = val * 10;
            val += (ch[i] - '0');

            if(val > Integer.MAX_VALUE) {
                break;
            }

            int curVal = (int) val;
            if(result.size() >= 2) {
                if(pre1 + pre2 > curVal) {
                    continue;
                } else if(pre1 + pre2 < curVal){
                    break;
                }
            }

            result.add(curVal);
            if(help(result, pre2, curVal, ch, i + 1)) {
                return true;
            } else {
                result.remove(result.size()-1);
            }
        }

        return false;
    }

    static class TestCase {
        public static String STR = "123456579";
        public static String STR1 = "11235813";
        public static String STR2 = "112358130";
        public static String STR3 = "0123";
        public static String STR4 = "1101111";
        public static String STR5 = "0123";
    }
}
