package club.vann.leetcode.offer;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p>题目：个骰子的点数</p>
 * <p>描述：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *  
 *
 * 限制：
 *
 * 1 <= n <= 11
 *
 * 通过次数12,000提交次数22,434
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-30 16:35
 **/
public class LeetCode_60 {
    public static void main(String[] args) {
        LeetCode_60 leetCode = new LeetCode_60();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.twoSum(TestCase.N)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.twoSum(TestCase.N1)));
    }

    /**
     * 解法一：
     *
     * @param n
     * @return
     */
    private double[] twoSum(int n) {
        int size = 6*n - 1*n + 1;
        double[] res = new double[size];
        int left = (size+1) / 2;
        int right = (size%2 == 0) ? left + 1 : left;
        while(left >= 0 && right < size) {
            res[left] = Math.pow(1.0/6*left, n);
            res[right] = Math.pow(1.0/6*left, n);
            left --;
            right ++;
        }
        return res;
    }

    static class TestCase {
        public static final double[] ANS = {0.16667,0.16667,0.16667,0.16667,0.16667,0.16667};
        public static final int N = 1;

        public static final double[] ANS1 = {0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778};
        public static final int N1 = 2;
    }
}
