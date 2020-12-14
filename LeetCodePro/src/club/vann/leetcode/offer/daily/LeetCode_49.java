package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Medium</p>
 * <p>题目：字母异位词分组</p>
 * <p>描述：给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 通过次数127,548提交次数198,338
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-12-14 09:09
 **/
public class LeetCode_49 {
    public static void main(String[] args) {
        LeetCode_49 leetCode = new LeetCode_49();

        List<List<String>> res = null;
        res = leetCode.groupAnagrams(TestCase.STRS);
        res = leetCode.groupAnagrams(TestCase.STRS1);
        System.out.println("Success");
    }

    /**
     * 解法一：
     * 暴力解法
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        int len = strs.length;
        for(int i = 0; i < len; i ++) {
            String str = strs[i];
            // 对str进行按照字母顺序调整
            String key = str2Key(str);
            if(map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        for(String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private String str2Key(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    static class TestCase {
        public static String[] STRS = {"eat", "tea", "tan", "ate", "nat", "bat"};
        public static String[] STRS1 = {"teai", "eat", "tea", "tan", "ate", "nat", "bat"};
    }
}
