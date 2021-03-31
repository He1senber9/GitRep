package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：替换后的最长重复字符</p>
 * <p>描述：给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * 通过次数19,809提交次数39,120
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-02:10:58:03
 */
public class LeetCode_424 {
    public static void main(String[] args) {
        LeetCode_424 leetCode = new LeetCode_424();

//        System.out.println("Success");
//        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.characterReplacement(TestCase.STR, TestCase.K));
//        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.characterReplacement(TestCase.STR1, TestCase.K1));
//        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.characterReplacement(TestCase.STR2, TestCase.K2));
//        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.characterReplacement(TestCase.STR3, TestCase.K3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.characterReplacement(TestCase.STR4, TestCase.K4));
    }

    /**
     * 解法一：
     * 双指针
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
//        int[] counts = new int[26];
//        int len = s.length();
//        int max = 0;
//        int left = 0, right = 0;
//
//        while(right < len) {
//            counts[s.charAt(right)-'A'] ++;
//
//            max = Math.max(max, counts[s.charAt(right)-'A']);
//
//            if(right - left + 1 - max > k) {
//                counts[s.charAt(left)-'A'] --;
//                left ++;
//            }
//            right ++;
//        }
//
//        return right - left;
        char[] ch = s.toCharArray();
        int len = ch.length;

        int[] counts = new int[26];
        int left = 0, right = 0;
        int max = 0;

        while(right < len) {
            counts[ch[right]-'A'] ++;

            // 计算当前数量最多的字符数量
            max = Math.max(max, counts[ch[right]-'A']);

            if(right-left+1-max > k) {
                // 如果当前需要替换的字符已经超过K个
                counts[ch[left]-'A'] --;
                left ++;
            }

            right ++;
        }

        return right - left;
    }

    static class TestCase {
        public static int ANS = 4;
        public static String STR = "ABAB";
        public static int K = 2;

        public static int ANS1 = 4;
        public static String STR1 = "AABABBA";
        public static int K1 = 1;

        public static int ANS2 = 8;
        public static String STR2 = "AAAAAAAB";
        public static int K2 = 1;

        public static int ANS3 = 4;
        public static String STR3 = "ABBB";
        public static int K3 = 2;

        public static int ANS4 = 2;
        public static String STR4 = "ABAA";
        public static int K4 = 0;
    }
}
