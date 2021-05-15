package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>难度：Easy</p>
 * <p>题目：罗马数字转整数</p>
 * <p>描述：罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 * 通过次数372,951提交次数596,469
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_13II
 * @Description TODO
 * @User fanyu
 * @Date 2021/5/15 7:50
 */
public class LeetCode_13II {
    public static void main(String[] args) {
        LeetCode_13II leetCode = new LeetCode_13II();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.romanToInt(TestCase.S));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.romanToInt(TestCase.S1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.romanToInt(TestCase.S2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.romanToInt(TestCase.S3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.romanToInt(TestCase.S4));
    }

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        char[] ch = s.toCharArray();

        int result = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < ch.length; i ++) {
            if(!stack.isEmpty()) {
                int v1 = map.get(stack.peek()+"");
                int v2 = map.get(ch[i]+"");
                if(v1 < v2) {
                    stack.pop();
                    result += v2-v1;
                    continue;
                } else {
                    result += map.get(stack.pop()+"");
                }

            }
            stack.push(ch[i]);
        }

        while(!stack.isEmpty()) {
            result += map.get(stack.pop()+"");
        }

        return result;
    }

    static class TestCase {
        public static int ANS = 3;
        public static String S = "III";

        public static int ANS1 = 4;
        public static String S1 = "IV";

        public static int ANS2 = 9;
        public static String S2 = "IX";

        public static int ANS3 = 58;
        public static String S3 = "LVIII";

        public static int ANS4 = 1994;
        public static String S4 = "MCMXCIV";
    }
}
