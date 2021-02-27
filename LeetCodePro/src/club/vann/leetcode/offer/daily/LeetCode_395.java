package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：最少有K个重复字符的最长子串</p>
 * <p>描述：找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * 通过次数20,365提交次数43,590
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-27:08:59:06
 */
public class LeetCode_395 {
    public static void main(String[] args) {
        LeetCode_395 leetCode = new LeetCode_395();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.longestSubstring(TestCase.S, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.longestSubstring(TestCase.S1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.longestSubstring(TestCase.S2, TestCase.K2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.longestSubstring(TestCase.S3, TestCase.K3));
    }

    /**
     * 解法一：
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        char[] ch = s.toCharArray();
        return longestSubstring(ch, 0, ch.length-1, k);
    }

    private int longestSubstring(char[] ch, int left, int right, int K) {
        if(right-left+1 < K) {
            return 0;
        }
        int[] tags = new int[26];
        for(int i = left; i <= right; i ++) {
            tags[ch[i]-'a'] ++;
        }

        // 标记分段字符
        int split = 0;
        for(int i = 0; i < 26; i ++) {
            if(tags[i] > 0 && tags[i] < K) {
                split = i+'a';
                break;
            }
        }

        if(split == 0) {
            return right-left+1;
        }

        int i = left;
        int res = 0;
        while(i <= right) {
            while(i <= right && ch[i] == split) {
                i ++;
            }

            if(i > right) {
                break;
            }

            int start = i;
            while(i <= right && ch[i] != split) {
                i ++;
            }

            int len = longestSubstring(ch, start, i-1, K);
            res = Math.max(res, len);
        }

        return res;
    }

    static class TestCase {
        public static int ANS = 3;
        public static String S = "aaabb";
        public static int K = 3;

        public static int ANS1 = 5;
        public static String S1 = "ababbc";
        public static int K1 = 2;

        public static int ANS2 = 10;
        public static String S2 = "aaaaaaaaaa";
        public static int K2 = 2;

        public static int ANS3 = 7;
        public static String S3 = "abcdefg";
        public static int K3 = 1;
    }
}
