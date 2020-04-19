package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：统计重复个数</p>
 * <p>描述：由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。
 *
 * 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
 *
 * 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。
 *
 * 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * s1 ="acb",n1 = 4
 * s2 ="ab",n2 = 2
 *
 * 返回：
 * 2
 * 通过次数1,498提交次数4,804
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-the-repetitions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/19
 * Time: 9:11
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_466 {
    public static void main(String[] args) {
        LeetCode_466 leetCode = new LeetCode_466();
        System.out.println("Result["+TestCase.ans+"]" + leetCode.getMaxRepetitions(TestCase.strParams[0], TestCase.intParams[0], TestCase.strParams[1],TestCase.intParams[1]));
        System.out.println("Result["+TestCase.ans1+"]" + leetCode.getMaxRepetitions(TestCase.strParams1[0], TestCase.intParams1[0], TestCase.strParams1[1],TestCase.intParams1[1]));
        System.out.println("Result["+TestCase.ans2+"]" + leetCode.getMaxRepetitions(TestCase.strParams2[0], TestCase.intParams2[0], TestCase.strParams2[1],TestCase.intParams2[1]));
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        return -1;
    }

    static class TestCase {

        public static final int ans = 2;
        public static final String[] strParams = {"acb", "ab"};
        public static final int[] intParams = {4, 2};

        public static final int ans1 = 3;
        public static final String[] strParams1 = {"aaa", "aa"};
        public static final int[] intParams1 = {4, 2};

        public static final int ans2 = 1;
        public static final String[] strParams2 = {"acbbe", "abc"};
        public static final int[] intParams2 = {4, 2};
    }
}
