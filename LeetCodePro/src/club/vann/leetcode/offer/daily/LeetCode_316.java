package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>难度：Medium</p>
 * <p>题目：去除重复字母</p>
 * <p>描述：给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 通过次数28,884提交次数65,667
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/12/20
 * Time: 8:43
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_316 {
    public static void main(String[] args) {
        LeetCode_316 leetCode = new LeetCode_316();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.removeDuplicateLetters(TestCase.STR));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.removeDuplicateLetters(TestCase.STR1));
//        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.removeDuplicateLetters(TestCase.STR2));
    }

    /**
     * 解法一：
     * 需要注意：
     * 1.删除重复字符。
     * 2.源字符串字符相对位置不变。
     * 3.返回结果的字典序最小。
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
//        char[] ch = s.toCharArray();
//        int len = ch.length;
//
//        // 统计字符数量
//        int[] nums = new int[26];
//        for(char c : ch) {
//            nums[c-'a'] ++;
//        }
//
//        boolean[] visable = new boolean[26];
//
//
//        // 单调栈，若满足 s[i] > s[i+1]，则应该删除 s[i]
//        Stack<Character> stack = new Stack<>();
//        A:for(int i = 0; i < len; i ++) {
//            char c = ch[i];
//            while(!stack.isEmpty()) {
//                if(visable[c-'a']) {
//                    // 还需要判断栈里知否已经有当前元素了
//                    nums[c-'a'] --;
//                    continue A;
//                }
//
//                char tag = stack.peek();
//                if(tag > c) {
//                    // 删除字符，条件是当前字符在后面还出现了
//                    if(nums[tag-'a'] > 0) {
//                        visable[tag-'a'] = false;
//                        stack.pop();
//                    } else {
//                        break;
//                    }
//                } else {
//                    break;
//                }
//            }
//
//            stack.push(c);
//            nums[c-'a'] --;
//            visable[c-'a'] = true;
//        }
//
//        int newSize = stack.size();
//        char[] newCh = new char[newSize];
//        for(int i = newSize-1; i >= 0; i --) {
//            newCh[i] = stack.pop();
//        }
//        return new String(newCh);

        if(s == null || s.length() == 0) {
            return s;
        }

        char[] ch = s.toCharArray();
        int len = ch.length;

        // 统计元素出现个数
        int[] counts = new int[26];
        for(char c : ch) {
            counts[c-'a'] ++;
        }

        // 标记元素是否已经被占用
        boolean[] flags = new boolean[26];

        List<Character> list = new ArrayList<>();
        A:for(int i = 0; i < len; i ++) {
            char c = ch[i];

            if(!list.isEmpty() && list.contains(c)) {
                counts[c-'a'] --;
                continue ;
            }

            while(!list.isEmpty()) {
                char tag = list.get(list.size()-1);
                if(tag > c  && counts[tag-'a'] > 0) {
                    list.remove(list.size()-1);
                } else {
                    break ;
                }
            }

            list.add(c);
            counts[c-'a'] --;
        }

        char[] newCh = new char[list.size()];
        for(int i = 0; i < newCh.length; i ++) {
            newCh[i] = list.get(i);
        }
        return new String(newCh);
    }

    static class TestCase {
        public static String ANS = "abc";
        public static String STR = "bcabc";

        public static String ANS1 = "acdb";
        public static String STR1 = "cbacdcbc";

        public static String ANS2 = "";
        public static String STR2 = "";
    }
}
