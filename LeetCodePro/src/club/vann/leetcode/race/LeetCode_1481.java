package club.vann.leetcode.race;

import java.util.*;

/**
 * <p>难度：Medium</p>
 * <p>题目：不同整数的最少数目</p>
 * <p>描述：给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [5,5,4], k = 1
 * 输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 * 示例 2：
 *
 * 输入：arr = [4,3,1,1,3,3,2], k = 3
 * 输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/21
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1481 {
    public static void main(String[] args) {
        LeetCode_1481 leetCode = new LeetCode_1481();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.findLeastNumOfUniqueInts(TestCase.arr, TestCase.k));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.findLeastNumOfUniqueInts(TestCase.arr1, TestCase.k1));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.findLeastNumOfUniqueInts(TestCase.arr2, TestCase.k2));
    }

    /**
     * 解法一：
     * 总是先删除数目最少的元素
     * @param arr
     * @param k
     * @return
     */
    private int findLeastNumOfUniqueInts(int[] arr, int k) {
        if(arr == null || arr.length <= k) {
            return 0;
        }

        int len = arr.length;

        // 用于存储数值与其次数
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i ++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int size = map.size();
        int[] cnt = new int[size];
        int m = 0;
        // 用keySet把每一个key取出来，然后用map.get(key)来取值
        // 之前用Map.Entry方法，感觉更繁琐
        for(int key : map.keySet()){
            cnt[m++] = map.get(key);
        }
        Arrays.sort(cnt);
        // 排序之后，从小到大，如果k大于这个数字次数，那么这个数字就可以移除
        // 否则就break
        for(int c : cnt){
            if(k >= c){
                k -= c;
                size--;
            }else{
                break;
            }
        }
        return size;
    }

    static class TestCase {
        public static final int ans = 1;
        public static final int k = 1;
        public static final int[] arr = {5,5,4};

        public static final int ans1 = 2;
        public static final int k1 = 3;
        public static final int[] arr1 = {4,3,1,1,3,3,2};

        public static final int ans2 = 3;
        public static final int k2 = 3;
        public static final int[] arr2 = {2,4,1,8,3,5,1,3};
    }
}
