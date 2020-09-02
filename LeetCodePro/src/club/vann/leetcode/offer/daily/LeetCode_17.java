package club.vann.leetcode.offer.daily;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：电话号码的字母组合</p>
 * <p>描述：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 通过次数154,698提交次数282,204
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-08-26 10:53
 **/
public class LeetCode_17 {
    public static void main(String[] args) {
        LeetCode_17 leetCode = new LeetCode_17();

        List<String> res = null;
        res = leetCode.letterCombinations(TestCase.DIGITS);
        leetCode.toInfo(res);
    }

    /**
     * 解法一：
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        return null;
    }

    static class TestCase {
        public static String DIGITS = "23";
    }

    private void toInfo(List<String> list) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if(list == null || list.size() == 0) {
            System.out.println("[]");
            return;
        }
        for(int i = 0; i < list.size(); i ++) {
            builder.append(", " + list.get(i));
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}
