package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Medium</p>
 * <p>题目：前K个高频单词</p>
 * <p>描述：给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *  
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *  
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *  
 *
 * 扩展练习：
 *
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 * 通过次数31,263提交次数59,011
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 *
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-05-20  07:57:25
 */
public class LeetCode_692 {
    public static void main(String[] args) {
        LeetCode_692 leetCode = new LeetCode_692();

        List<String> res = null;

        res = leetCode.topKFrequent(TestCase.WORDS, TestCase.K);
        res = leetCode.topKFrequent(TestCase.WORDS1, TestCase.K1);

        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Pairs> queue = new PriorityQueue<>(new Comparator<Pairs>(){
            @Override
            public int compare(Pairs p1, Pairs p2) {
                if(p1.count == p2.count) {
                    return p1.word.compareTo(p2.word);
                } else {
                    return p2.count - p1.count;
                }
            }
        });

        for(String word : map.keySet()) {
            queue.add(new Pairs(map.get(word), word));
        }

        List<String> res = new ArrayList<>();
        while(!queue.isEmpty() && k > 0) {
            res.add(queue.poll().word);
            k --;
        }

        return res;
    }

    class Pairs {
        int count;
        String word;

        Pairs(int count, String word) {
            this.count = count;
            this.word = word;
        }
    }

    static class TestCase {
        public static String[] WORDS = {"i", "love", "leetcode", "i", "love", "coding"};
        public static int K = 2;

        public static String[] WORDS1 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        public static int K1 = 4;
    }
}
