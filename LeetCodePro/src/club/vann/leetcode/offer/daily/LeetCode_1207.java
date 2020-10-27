package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>难度：Easy</p>
 * <p>题目：独一无二的出现次数</p>
 * <p>描述：给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 * 通过次数17,980提交次数25,395
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/10/28
 * Time: 7:28
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1207 {
    public static void main(String[] args) {
        LeetCode_1207 leetCode = new LeetCode_1207();

        System.out.println("Result[" + TestCase.ANS + "] : " + leetCode.uniqueOccurrences(TestCase.ARR));
        System.out.println("Result[" + TestCase.ANS1 + "] : " + leetCode.uniqueOccurrences(TestCase.ARR1));
        System.out.println("Result[" + TestCase.ANS2 + "] : " + leetCode.uniqueOccurrences(TestCase.ARR2));
    }

    /**
     * 解法一：
     *
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Set<Integer> keySet = map.keySet();
        Set<Integer> set = new HashSet<>();
        for(int key : keySet) {
            set.add(map.get(key));
        }

        return keySet.size() == set.size();
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] ARR = {1,2,2,1,1,3};

        public static boolean ANS1 = false;
        public static int[] ARR1 = {1,2};

        public static boolean ANS2 = true;
        public static int[] ARR2 = {-3,0,1,-3,1,1,1,-3,10,0};
    }
}
