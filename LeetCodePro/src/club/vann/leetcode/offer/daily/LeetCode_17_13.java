package club.vann.leetcode.offer.daily;

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
     * 解法一：
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    private int respace(String[] dictionary, String sentence) {
        if(sentence == null || sentence.length() == 0) {
            return 0;
        }

        return respaceStrs(dictionary, sentence, 0);
    }

    /**
     * 从字符串 sentence 的索引 begin 开始，找到第一个符合字典 dictionary 里单词时已经查找过的字符数量。
     * @param dictionary
     * @param sentence
     * @param begin
     * @return
     */
    private int respaceStrs(String[] dictionary, String sentence, int begin) {
        int len = sentence.length();
        if(begin > len-1) {
            return 0;
        }

        int newBegin = begin;
        for(int n = 0; n < dictionary.length; n ++) {
            String tmp = dictionary[n];
            if(begin+tmp.length() > len) {
                continue;
            }

            if(tmp.equals(sentence.substring(begin, begin+tmp.length()))) {
                return respaceStrs(dictionary, sentence, begin+tmp.length());
            }
        }

        return  1 + respaceStrs(dictionary, sentence, begin+1);
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
