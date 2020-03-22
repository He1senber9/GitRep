package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Midum</p>
 * <p>题目：使数组唯一的最小增量</p>
 * <p>描述：给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * <p>
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 * <p>
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 提示：
 * <p>
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 * 通过次数5,347提交次数12,084</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/22
 * Time: 8:49
 * Description:
 */
public class LeetCode_945 {
    public static void main(String[] args) {
        int[] A = null;
        int result = 0;

        LeetCode_945 leetCode = new LeetCode_945();

        A = new int[]{1,2,2};
        result = leetCode.minIncrementForUnique2(A);
        System.out.println("Result[1] : " + result);

        A = new int[]{3,2,1,2,1,7};
        result = leetCode.minIncrementForUnique2(A);
        System.out.println("Result[6] : " + result);

        A = new int[]{};
        result = leetCode.minIncrementForUnique2(A);
        System.out.println("Result[] : " + result);

        A = new int[]{1,2,3};
        result = leetCode.minIncrementForUnique2(A);
        System.out.println("Result[0] : " + result);

        A = new int[]{2,2,2,1};
        result = leetCode.minIncrementForUnique2(A);
        System.out.println("Result[3] : " + result);

    }

    /**
     * 解法一：暴力遍历（经测试会时间超时)
     *
     * @param A
     * @return
     */
    private int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        int result = 0;
        int len = A.length;
        for (int n = 0; n < len; n++) {
            int v = A[n];
            while (set.contains(v)) {
                result += 1;
                v = v + 1;
            }
            set.add(v);
        }

        return result;
    }

    /**
     * 解法二：优化暴力遍历
     *
     * @param A
     * @return
     */
    private int minIncrementForUnique2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int result = 0;
        int len = A.length;

//        Set<Integer> set = new HashSet<Integer>();
        // 使用Map集合，K是元素，V是元素对应的count。
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int n = 0; n < len; n++) {
            int k = A[n];
            map.put(k, map.containsKey(k) ? map.get(k) + 1 : 1);
        }

        outer:
        for (int n = 0; n < len; n++) {
            int k = A[n];

            while (map.containsKey(k)) {
                int count = map.get(k);
                if (count >= 2) {
                    result += count - 1;

                    map.put(k, 1);

                    k = k + 1;
                    map.put(k, map.containsKey(k) ? map.get(k) + (count - 1) : (count-1));
                } else {
                    continue outer;
                }
            }
        }

        return result;
    }
}
