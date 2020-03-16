package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Easy</p>
 * <p>题目：字符串压缩</p>
 * <p>描述：字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 *
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 * 通过次数4,268提交次数8,559
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/16
 * Time: 9:01
 * Description:
 */
public class LeetCode_0106 {

    public static void main(String[] args) {
        String S = "";
        String result = "";
        LeetCode_0106 leetCode = new LeetCode_0106();

        S = "aabcccccaaa";
        result = leetCode.compressString(S);
        System.out.println("Result[a2b1c5a3] : " + result);

        S = "abbccd";
        result = leetCode.compressString(S);
        System.out.println("Result[abbccd] : " + result);

        S = "a";
        result = leetCode.compressString(S);
        System.out.println("Result[a] : " + result);
    }

    private String compressString(String S) {
        if(S == null || S.length() == 0) {
            return S;
        }

        String result = null;
        int len = S.length();

        StringBuilder builder = new StringBuilder();
        char tagChar = S.charAt(0);
        int tagCount = 1;
        for(int n = 1; n < len; n ++) {
            char c = S.charAt(n);
            if(c == tagChar) {
                tagCount ++;
            } else {
                builder.append(tagChar+""+tagCount);
                tagChar = c;
                tagCount = 1;
            }

        }
        builder.append(tagChar+""+tagCount);

        if(builder.length() > len) {
            return S;
        } else {
            return builder.toString();
        }
    }
}
