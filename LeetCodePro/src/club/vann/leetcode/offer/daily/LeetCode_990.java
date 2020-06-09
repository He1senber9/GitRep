package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：等式方程的可满足性</p>
 * <p>描述：给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 *
 * 输出：["b==a","a==b"]
 * 输入：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 *
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 *
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 *
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 * 通过次数4,469提交次数10,094
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-08 08:31
 **/
public class LeetCode_990 {
    public static void main(String[] args) {
        LeetCode_990 leetCode = new LeetCode_990();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.equationsPossible(TestCase.equations));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.equationsPossible(TestCase.equations1));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.equationsPossible(TestCase.equations2));
        System.out.println("Result["+TestCase.ans3+"] : " + leetCode.equationsPossible(TestCase.equations3));
        System.out.println("Result["+TestCase.ans4+"] : " + leetCode.equationsPossible(TestCase.equations4));
    }

    private static int code = 0;
    Map<String, Integer> dataMap = new HashMap<String, Integer>();

    /**
     * 解法一：
     * @param equations
     * @return
     */
    private boolean equationsPossible(String[] equations) {
        int len = equations.length;

        int[] base = new int[26];

        for(String str : equations) {

        }
        return true;
    }


    /**
     * 如果方程成立，返回true;
     * @param str
     * @return
     */
    private boolean equationsPossible(String str) {
        String[] strs = new String[2];
        String x1 = null, x2 = null;

        if(str.contains("==")) {
            strs = str.split("==");
        } else {
            strs = str.split("!=");
        }

        x1 = strs[0];
        x2 = strs[1];

        if(dataMap.containsKey(x1) && dataMap.containsKey(x2)) {
            if(str.contains("==")) {
                return dataMap.get(x1) == dataMap.get(x2);
            } else {
                return dataMap.get(x1) != dataMap.get(x2);
            }

        } else if(dataMap.containsKey(x1)) {
            if(str.contains("==")) {
                dataMap.put(x2, dataMap.get(x1));
            } else {
                dataMap.put(x2, code++);
            }
            return true;
        } else if(dataMap.containsKey(x2)){
            if(str.contains("==")) {
                dataMap.put(x1, dataMap.get(x2));
            } else {
                dataMap.put(x1, code++);
            }
            return true;
        } else {
            if(str.contains("==")) {
                dataMap.put(x1, code);
                dataMap.put(x2, code);
                code ++;
            } else {
                dataMap.put(x1, code++);
                dataMap.put(x2, code++);
            }

            return true;
        }
    }

    static class TestCase {
        public static final boolean ans = false;
        public static final String[] equations = {"a==b", "b!=a"};

        public static final boolean ans1 = true;
        public static final String[] equations1 = {"a==b", "b==a"};

        public static final boolean ans2 = true;
        public static final String[] equations2 = {"a==b", "b==c", "c==a"};

        public static final boolean ans3 = false;
        public static final String[] equations3 = {"a==b", "b!=c", "c==a"};

        public static final boolean ans4 = true;
        public static final String[] equations4 = {"c==c", "b==d", "x!=z"};

        public static final boolean ans5 = false;
        public static final String[] equations5 = {"a!=a"};
    }
}
