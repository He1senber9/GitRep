package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-07-25  09:46:59
 */
public class LeetCode_1743 {
    public static void main(String[] args) {
        LeetCode_1743 leetCode = new LeetCode_1743();

        System.out.println("Result:" + Arrays.toString(TestCase.ANS) + " " + Arrays.toString(leetCode.restoreArray(TestCase.ADJACENPAIRS)));
        System.out.println("Result:" + Arrays.toString(TestCase.ANS1) + " " + Arrays.toString(leetCode.restoreArray(TestCase.ADJACENPAIRS1)));
        System.out.println("Result:" + Arrays.toString(TestCase.ANS2) + " " + Arrays.toString(leetCode.restoreArray(TestCase.ADJACENPAIRS2)));
    }

    /**
     * 解法一：
     *
     * @param adjacentPairs
     * @return
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int[] adjacenpair : adjacentPairs) {
            int v1 = adjacenpair[0];
            int v2 = adjacenpair[1];

            Set<Integer> set1 = map.getOrDefault(v1, new HashSet<Integer>());
            set1.add(v2);
            map.put(v1, set1);
            Set<Integer> set2 = map.getOrDefault(v2, new HashSet<Integer>());
            set2.add(v1);
            map.put(v2, set2);
        }

        int n = adjacentPairs.length+1;
        int[] res = new int[n];
        Set<Integer> set = map.keySet();
        for(int key : set) {
            Set<Integer> desSet = map.get(key);
            if(desSet.size() == 1) {
                res[0] = key;

                for(int des : desSet) {
                    Set<Integer> next = map.get(des);
                    next.remove(key);
                }
                break;
            }
        }

        for(int i = 1; i < n; i ++) {
            Set<Integer> desSet = map.get(res[i-1]);
            for(int cur : desSet) {
                res[i] = cur;

                Set<Integer> next = map.get(cur);
                for(int nextDes : next) {
                    Set<Integer> nextSet = map.get(nextDes);
                    nextSet.remove(cur);
                    break;
                }
                break;
            }
        }
        return res;
    }

    static class TestCase {
        public static int[] ANS = {1,2,3,4};
        public static int[][] ADJACENPAIRS = {{2, 1}, {3, 4}, {3, 2}};

        public static int[] ANS1 = {-2,4,1,-3};
        public static int[][] ADJACENPAIRS1 = {{4, -2}, {1, 4}, {-3, 1}};

        public static int[] ANS2 = {4, -2};
        public static int[][] ADJACENPAIRS2 = {{4, -2}};
    }
}
