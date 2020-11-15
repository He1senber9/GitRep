package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.ListNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p>难度：Easy</p>
 * <p>题目：数组的相对排序</p>
 * <p>描述：给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * 通过次数28,756提交次数42,305
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-14 09:32
 **/
public class LeetCode_1122 {
    public static void main(String[] args) {
        LeetCode_1122 leetCode = new LeetCode_1122();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.relativeSortArray1(TestCase.PARAMS[0], TestCase.PARAMS[1])));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.relativeSortArray1(TestCase.PARAMS1[0], TestCase.PARAMS1[1])));
    }

    /**
     * 解法一：
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> numPostions = IntStream.range(0,arr2.length).boxed().collect(Collectors.toMap(i->arr2[i], i->i));
        return  Arrays.stream(arr1).boxed().sorted((o1, o2) -> {
            int a1 = numPostions.getOrDefault(o1, 1001);
            int a2 = numPostions.getOrDefault(o2, 1001);
            if (a1 != 1001 || a2 != 1001) {
                return a1 - a2;
            }

            return o1 - o2;
        }).mapToInt(o->o).toArray();
    }

    /**
     * 解法二：
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len2; i ++) {
            map.put(arr2[i], i);
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len1; i ++) {
            list.add(arr1[i]);
        }

        Collections.sort(list, (x, y) ->{
            if(map.containsKey(x) || map.containsKey(y)) {
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }

            return x - y;
        });

        for(int i = 0; i < len1; i ++) {
            arr1[i] = list.get(i);
        }

        return arr1;
    }

    static class TestCase {
        public static int[] ANS = {2,2,2,1,4,3,3,9,6,7,19};
        public static int[][] PARAMS = {{2,3,1,3,2,4,6,7,9,2,19}, {2,1,4,3,9,6}};

        public static int[] ANS1 = {943,715,427,790,860,722,225,320,846,550};
        public static int[][] PARAMS1 = {{943,790,427,722,860,550,225,846,715,320}, {943,715,427,790,860,722,225,320,846,550}};
    }
}
