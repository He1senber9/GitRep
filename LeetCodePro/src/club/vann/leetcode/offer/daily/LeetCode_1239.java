package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：串联字符串的最大长度</p>
 * <p>描述：给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 *
 * 请返回所有可行解 s 中最长长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 * 示例 2：
 *
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * 示例 3：
 *
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] 中只含有小写英文字母
 * 通过次数17,723提交次数41,615
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-19  09:06:24
 */
public class LeetCode_1239 {
    public static void main(String[] args) {
        LeetCode_1239 leetCode = new LeetCode_1239();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxLength(TestCase.ARR()));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxLength(TestCase.ARR1()));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxLength(TestCase.ARR2()));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.maxLength(TestCase.ARR3()));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.maxLength(TestCase.ARR4()));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.maxLength(TestCase.ARR5()));
    }

    /**
     * 解法一：
     * 回溯算法。
     * @param arr
     * @return
     */
    public int maxLength(List<String> arr) {
        int len = arr.size();
        Map<String, Integer> map = new HashMap<>();
        map.put("max", 0);
        int[] mask = new int[26];
        List<String> path = new ArrayList<>();
        helper(map, mask, path, arr, 0);
        return map.get("max");
    }

    private void helper(Map<String, Integer> map, int[] mask, List<String> path, List<String> arr, int index) {
        if(index == arr.size()) {
            return;
        }

        for(int i = index; i < arr.size(); i ++) {
            String str = arr.get(i);
            int point = -1;
            if(!isFormat(mask, str)) {
                if(!addMask(mask, str)) {
                    continue;
                }
                path.add(str);
                point = path.size()-1;

                calMax(map, path);
            } else {
                continue;
            }

            helper(map, mask, path, arr, i+1);

            path.remove(point);
            cleanMask(mask, str);
        }
    }

    private boolean isFormat(int[] mask, String str) {
        char[] ch = str.toCharArray();
        for(char c : ch) {
            int index = c - 'a';
            if(mask[index] != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean addMask(int[] mask, String str) {
        char[] ch = str.toCharArray();
        for(char c : ch) {
            int index = c - 'a';
            mask[index] ++;
            if(mask[index] > 1) {
                cleanMask(mask, str);
                return false;
            }
        }

        return true;
    }

    private void cleanMask(int[] mask, String str) {
        char[] ch = str.toCharArray();
        for(char c : ch) {
            int index = c - 'a';
            mask[index] = 0;
        }
    }

    private void calMax(Map<String, Integer> map, List<String> path) {
        int result = 0;
        for(String str : path) {
            result += str.length();
        }
        int max = map.get("max");
        max = Math.max(max, result);
        map.put("max", max);
    }

    static class TestCase {
        public static int ANS = 4;
        public static List<String> ARR() {
            List<String> list = new ArrayList<>();
            list.add("un");
            list.add("iq");
            list.add("ue");
            return list;
        }

        public static int ANS1 = 6;
        public static List<String> ARR1() {
            List<String> list = new ArrayList<>();
            list.add("cha");
            list.add("r");
            list.add("act");
            list.add("ers");
            return list;
        }

        public static int ANS2 = 26;
        public static List<String> ARR2() {
            List<String> list = new ArrayList<>();
            list.add("abcdefghijklmnopqrstuvwxyz");
            return list;
        }

        public static int ANS3 = 16;
        public static List<String> ARR3() {
            List<String> list = new ArrayList<>();
            list.add("a");
            list.add("b");
            list.add("c");
            list.add("d");
            list.add("e");
            list.add("f");
            list.add("g");
            list.add("h");
            list.add("i");
            list.add("j");
            list.add("k");
            list.add("l");
            list.add("m");
            list.add("n");
            list.add("o");
            list.add("p");
            return list;
        }

        public static int ANS4 = 16;
        public static List<String> ARR4() {
            List<String> list = new ArrayList<>();
            list.add("jnfbyktlrqumowxd");
            list.add("mvhgcpxnjzrdei");
            return list;
        }

        public static int ANS5 = 0;
        public static List<String> ARR5() {
            List<String> list = new ArrayList<>();
            list.add("yy");
            list.add("bkhwmpbiisbldzknpm");
            return list;
        }
    }
}
