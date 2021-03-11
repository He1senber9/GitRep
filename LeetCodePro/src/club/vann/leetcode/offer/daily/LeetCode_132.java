package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>难度：Hard</p>
 * <p>题目：分割回文串II</p>
 * <p>描述：给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 *
 * 输入：s = "ab"
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * 通过次数21,947提交次数48,368
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-08:08:28:37
 */
public class LeetCode_132 {
    public static void main(String[] args) {
        LeetCode_132 leetCode = new LeetCode_132();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minCut1(TestCase.S));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minCut1(TestCase.S1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.minCut1(TestCase.S2));
    }

    private int ans = 0;

    /**
     * 解法一：
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        int len = s.length();
        ans = len-1;
        List<String> list = new ArrayList<>();
        cut(list, s, 0);
        return ans;
    }

    private void cut(List<String> list, String s, int index) {
        int len = s.length();
        if(index >= len) {
            ans = Math.min(ans, list.size()-1);
            return;
        }

        // list.add(s.substring(index, index+1));
        for(int i = index; i < len; i ++) {
            String sub = s.substring(index, i+1);
            if(!isFormat(s, index, i)) {
                continue;
            }
            list.add(sub);
            cut(list, s, i+1);
            list.remove(list.size()-1);
        }
    }

    private boolean isFormat(String s, int left, int right) {
        char[] ch = s.toCharArray();
        while(left < right) {
            if(ch[left] != ch[right]) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    /**
     * 解法二：
     *
     * @param s
     * @return
     */
    public int minCut1(String s) {
        int len = s.length();
        boolean[][] flags = new boolean[len][len];
        for(int i = 0; i < len; i ++) {
            Arrays.fill(flags[i], true);
        }

        for(int i = len-1; i >= 0; i --) {
            for(int j = i+1; j < len; j ++) {
                flags[i][j] = s.charAt(i) == s.charAt(j) && flags[i+1][j-1];
            }
        }

        int[] f = new int[len];
        Arrays.fill(f, Integer.MAX_VALUE);
        for(int i = 0; i < len; i ++) {
            if(flags[0][i]) {
                f[i] = 0;
            } else {
                for(int j = 0; j < i; j ++) {
                    if(flags[j+1][i]) {
                        f[i] = Math.min(f[i], f[j]+1);
                    }
                }
            }
        }
        return f[len-1];
    }

    static class TestCase {
        public static int ANS = 1;
        public static String S = "aab";

        public static int ANS1 = 0;
        public static String S1 = "a";

        public static int ANS2 = 1;
        public static String S2 = "ab";
    }
}
