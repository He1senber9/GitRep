package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：划分字母区间</p>
 * <p>描述：字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * 通过次数23,607提交次数32,264
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/10/22
 * Time: 8:43
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_763 {
    public static void main(String[] args) {
        LeetCode_763 leetCode = new LeetCode_763();

        List<Integer> result = null;
        result = leetCode.partitionLabels(TestCase.STR);
        result = leetCode.partitionLabels(TestCase.STR1);
        result = leetCode.partitionLabels(TestCase.STR2);
        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S == null || S.length() == 0) {
            return result;
        }

        partitionLabels(result, S, 0);
        return result;
    }

    public void partitionLabels(List<Integer> result, String S, int index) {
        if(index > S.length() - 1) {
            return;
        }

        // 此时是index<S.length()-1的情况
        int begin = S.lastIndexOf(S.charAt(index));
        int max = begin - index + 1;
        for(int i = index+1; i < begin; i ++) {
            int len = S.lastIndexOf(S.charAt(i))  - index + 1;
            if(len < max) {
                continue;
            } else {
                max = len;
                begin = index + max - 1;
            }
        }
        result.add(max);

        partitionLabels(result, S, index+max);
    }

    static class TestCase {
        public static String STR = "ababcbacadefegdehijhklij";
        public static String STR1 = "abcabcdefdef";
        public static String STR2 = "qiejxqfnqceocmy";

    }
}
