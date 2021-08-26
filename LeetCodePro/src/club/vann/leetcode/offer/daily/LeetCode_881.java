package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：救生艇</p>
 * <p>描述：第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 *
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 *
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 *
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * 提示：
 *
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 * 通过次数39,723提交次数74,560
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/boats-to-save-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-08-26  21:21:27
 */
public class LeetCode_881 {
    public static void main(String[] args) {
        LeetCode_881 leetCode = new LeetCode_881();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.numRescueBoats(TestCase.PEOPLE, TestCase.LIMIT));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.numRescueBoats(TestCase.PEOPLE1, TestCase.LIMIT1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.numRescueBoats(TestCase.PEOPLE2, TestCase.LIMIT2));
    }

    /**
     * 解法一：
     *
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int n = people.length;
        // 找出恰好2个人乘坐的个数有多少
        int left = 0, right = n - 1;
        int count = 0;
        while(left < right) {
            if(people[left] + people[right] <= limit) {
                count ++;
                left ++;
                right --;
            } else {
                right --;
            }
        }
        return n - count;
    }

    static class TestCase {
        public static int ANS = 1;
        public static int[] PEOPLE = {1,2};
        public static int LIMIT = 3;

        public static int ANS1 = 3;
        public static int[] PEOPLE1 = {3,2,2,1};
        public static int LIMIT1 = 3;

        public static int ANS2 = 4;
        public static int[] PEOPLE2 = {3,5,3,4};
        public static int LIMIT2 = 5;
    }
}
