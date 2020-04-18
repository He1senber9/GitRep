package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：编辑距离</p>
 * <p>描述：给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * 通过次数39,233提交次数68,786
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/6
 * Time: 9:13
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_72 {
    public static void main(String[] args) {
        LeetCode_72 leetCode = new LeetCode_72();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.minDistance(TestCase.words[0], TestCase.words[1]));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.minDistance(TestCase.words1[0], TestCase.words1[1]));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.minDistance(TestCase.words2[0], TestCase.words2[1]));
        System.out.println("Result["+TestCase.ans3+"] : " + leetCode.minDistance(TestCase.words3[0], TestCase.words3[1]));
        System.out.println("Result["+TestCase.ans4+"] : " + leetCode.minDistance(TestCase.words4[0], TestCase.words4[1]));
        System.out.println("Result["+TestCase.ans5+"] : " + leetCode.minDistance(TestCase.words5[0], TestCase.words5[1]));
        System.out.println("Result["+TestCase.ans6+"] : " + leetCode.minDistance(TestCase.words6[0], TestCase.words6[1]));
        System.out.println("Result["+TestCase.ans7+"] : " + leetCode.minDistance(TestCase.words7[0], TestCase.words7[1]));
        System.out.println("Result["+TestCase.ans8+"] : " + leetCode.minDistance(TestCase.words8[0], TestCase.words8[1]));
        System.out.println("Result["+TestCase.ans9+"] : " + leetCode.minDistance(TestCase.words9[0], TestCase.words9[1]));
        System.out.println("Result["+TestCase.ans10+"] : " + leetCode.minDistance(TestCase.words10[0], TestCase.words10[1]));
        System.out.println("Result["+TestCase.ans11+"] : " + leetCode.minDistance(TestCase.words11[0], TestCase.words11[1]));
        System.out.println("Result["+TestCase.ans12+"] : " + leetCode.minDistance(TestCase.words12[0], TestCase.words12[1]));
        System.out.println("Result["+TestCase.ans13+"] : " + leetCode.minDistance(TestCase.words13[0], TestCase.words13[1]));
        System.out.println("Result["+TestCase.ans14+"] : " + leetCode.minDistance(TestCase.words14[0], TestCase.words14[1]));
    }

    /**
     * 解法一：
     * 借助DP表：dp[str]标志转换成str需要的最少操作数。
     * dp[str] =
     *     dp[str-1]:
     *     dp[str-1]-1：后一个字符不为空且 后一个字符相等/后一个字符不等
     *     dp[str-1]+1：后一个字符为空
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null) {
            return 0;
        }

        if(word1 == null || word1 == "") {
            return word2.length();
        }

        if(word2 == null || word2 == "") {
            return word1.length();
        }



        return minDistance(word1.toCharArray(), word2.toCharArray());
    }

    private int minDistance(char[] words1, char[] words2) {
        int lenWord1 = words1.length;
        int lenWord2 = words2.length;

        int[] dp = new int[lenWord2];
        for(int n = 0; n < lenWord2; n ++) {
            char c = words2[n];

            for(int m = 0; m < lenWord1; m ++) {
                if(words1[m] == words2[n]) {
                    dp[n] = m;
                }
            }
        }

        int result = 0;

        // 先去除需要删除的元素
        for(int n = 0; n < lenWord1; n ++) {
            
        }
        return 0;
    }

    static class TestCase {
        public static final int ans = 3;
        public static final String[] words = {"horse", "ros"};

        public static final int ans1 = 5;
        public static final String[] words1 = {"intention", "execution"};

        public static final int ans2 = 0;
        public static final String[] words2 = {"word", "word"};

        public static final int ans3 = 0;
        public static final String[] words3 = {"word", "word"};

        public static final int ans4 = 3;
        public static final String[] words4 = {"word", "abcd"};

        public static final int ans5 = 4;
        public static final String[] words5 = {"word", "dabc"};

        public static final int ans6 = 6;
        public static final String[] words6 = {"word", "tentis"};

        public static final int ans7 = 6;
        public static final String[] words7 = {"word", "tentis"};

        public static final int ans8 = 11;
        public static final String[] words8 = {"tenordabcsdword", "word"};

        public static final int ans9 = 11;
        public static final String[] words9 = {"abottrefwhijk", "word"};

        public static final int ans10 = 10;
        public static final String[] words10 = {"abdttofwhrjk", "word"};

        public static final int ans11 = 4;
        public static final String[] words11 = {"word", "drow"};

        public static final int ans12 = 4;
        public static final String[] words12 = {"oword", "drow"};

        public static final int ans13 = 4;
        public static final String[] words13 = {"roword", "drow"};

        public static final int ans14 = 3;
        public static final String[] words14 = {"dowor", "drow"};
    }
}
