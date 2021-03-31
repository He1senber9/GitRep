package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：分割回文串</p>
 * <p>描述：给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * 通过次数67,393提交次数95,361
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-07:08:32:04
 */
public class LeetCode_131 {
    public static void main(String[] args) {
        LeetCode_131 leetCode = new LeetCode_131();

        List<List<String>> res = null;
        res = leetCode.partition(TestCase.S);
        res = leetCode.partition(TestCase.S1);
        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return ans;
        }

        List<String> list = new ArrayList<>();
        partition(ans, list, s, 0);
        return ans;
    }

    private void partition(List<List<String>> ans, List<String> list, String s, int index) {
        int len = s.length();
        if(index >= len) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < len; i ++) {
            String sub = s.substring(index, i+1);
            if(!isPartation(s, index, i)) {
                continue;
            }
            list.add(sub);
            partition(ans, list, s, i+1);
            list.remove(list.size()-1);
        }
    }

    private boolean isPartation(String s, int left, int right) {
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

    static class TestCase {
        public static String S = "aab";

        public static String S1 = "aabc";
    }
}
