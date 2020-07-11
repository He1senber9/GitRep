package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：恢复空格</p>
 * <p>描述：哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 *
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 *
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 * 通过次数9,106提交次数16,645
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/re-space-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-09 15:08
 **/
public class LeetCode_17_13 {
    public static void main(String[] args) {
        LeetCode_17_13 leetCode = new LeetCode_17_13();

//        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.respace(TestCase.PARAMS[0], TestCase.PARAMS[1][0]));
//        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.respace(TestCase.PARAMS1[0], TestCase.PARAMS1[1][0]));
//        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.respace(TestCase.PARAMS2[0], TestCase.PARAMS2[1][0]));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.respace(TestCase.PARAMS3[0], TestCase.PARAMS3[1][0]));
    }

    /**
     * 解法一：字典树
     * 定义 dp[i] 表示考虑前 i 个字符最少的未识别的字符数量，从前往后计算 dp 值。
     * 考虑转移方程，每次转移的时候我们考虑第 j(j <= i)j(j≤i) 个到第 i 个字符组成的子串 sentence[j−1⋯i−1] （注意字符串下标从 0 开始）是否能在词典中找到，
     * 如果能找到的话按照定义转移方程即为:
     *      dp[i]=min(dp[i],dp[j−1])
     *
     * 否则没有找到的话我们可以复用 dp[i−1] 的状态再加上当前未被识别的第 i 个字符，因此此时 dp 值为:
     *      dp[i]=dp[i−1]+1
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/re-space-lcci/solution/hui-fu-kong-ge-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie root = new Trie();
        for (String word: dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }

    class Trie {
        public Trie[] next;
        public boolean isEnd;

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String s) {
            Trie curPos = this;

            for (int i = s.length() - 1; i >= 0; --i) {
                int t = s.charAt(i) - 'a';
                if (curPos.next[t] == null) {
                    curPos.next[t] = new Trie();
                }
                curPos = curPos.next[t];
            }
            curPos.isEnd = true;
        }
    }

    static class TestCase {
        public static int ANS = 7;
        public static String[][] PARAMS = {{"looked","just","like","her","brother"}, {"jesslookedjustliketimherbrother"}};

        public static int ANS1 = 0;
        public static String[][] PARAMS1 = {{"looked","just","like","her","brother"}, {"lookedjustlikeherbrother"}};

        public static int ANS2 = 7;
        public static String[][] PARAMS2 = {{"jxnonurhhuanyuqahjy","phrxu","hjunypnyhajaaqhxduu"}, {"qahurhoharrdjxnonurhhuanyuqahjyppnha"}};

        public static int ANS3 = 0;
        public static String[][] PARAMS3 = {{"ouf","uucuocucoouoffcpuuf","pf","o","fofopupoufuofffffocpocfccuofuupupcouocpocoooupcuu","cf"
                ,"cffooccccuoocpfupuucufoocpocucpuouofffpoupu","opoffuoofpupcpfouoouufpcuocufo","fopuupco","upocfucuucfucofufu"
                ,"ufoccopopuouccupooc","fffu","uuopuccfocopooupooucfoufop","occ","ppfcuu","o","fpp","o","oououpuccuppuococcpoucccffcpcucoffupcoppoc"
                ,"ufc","coupo","ufuoufofopcpfoufoouppffofffuupfco","focfcfcfcfpuouoccupfccfpcooup","ffupfffccpffufuuo","cufoupupppocou"
                ,"upopupopccffuofpcopouofpoffopcfcuooocppofofuuc","oo","pccc","oupupcccppuuucuuouocu","fuop","ppuocfuppff","focofooffpfcpcupupuuooufu"
                ,"uofupoocpf","opufcuffopcpcfcufpcpufuupffpp","f","opffp","fpccopc"}, {"fofopupoufuofffffocpocfccuofuupupcouocpocoooupcuufffufffufpccopc"}};

    }
}
