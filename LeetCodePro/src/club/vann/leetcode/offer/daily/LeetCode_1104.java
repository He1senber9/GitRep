package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-07-29  08:53:53
 */
public class LeetCode_1104 {
    public static void main(String[] args) {
        LeetCode_1104 leetCode = new LeetCode_1104();

        List<Integer> result = null;
        result = leetCode.pathInZigZagTree(TestCase.LABEL);
        result = leetCode.pathInZigZagTree(TestCase.LABEL1);

        System.out.println("****");
    }

    public List<Integer> pathInZigZagTree(int label) {
        // 解法一：
        List<Integer> index2Val = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int n = 1;
        int min = (int) Math.pow(2, n-1);
        int max = (int) Math.pow(2, n) - 1;
        int flag = 1;
        int index = 0;
        while(min <= label) {
            int begin = (flag == 1) ? min : max;
            for(int i = min; i <= max; i ++) {
                index2Val.add(begin);
                map.put(begin, index++);
                begin = (flag == 1) ? ++begin : --begin;
            }
            flag = flag * -1;
            n ++;
            min = (int) Math.pow(2, n-1);
            max = (int) Math.pow(2, n) - 1;
        }

        List<Integer> result = new ArrayList<>();
        int point = map.get(label);
        while(point > 0) {
            int val = index2Val.get(point);
            result.add(val);

            point = (point-1)/2;
        }

        result.add(1);
        Collections.reverse(result);
        return result;
    }

    static class TestCase {
        public static int LABEL = 14;

        public static int LABEL1 = 26;
    }
}
