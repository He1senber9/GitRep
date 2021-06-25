package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>难度：Medium</p>
 * <p>题目：打开转盘锁</p>
 * <p>描述：你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 *
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 *
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 * 通过次数45,375提交次数90,796
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-25  07:48:44
 */
public class LeetCode_752 {
    public static void main(String[] args) {
        LeetCode_752 leetCode = new LeetCode_752();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.openLock(TestCase.DEADENDS, TestCase.TARGET));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.openLock(TestCase.DEADENDS1, TestCase.TARGET1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.openLock(TestCase.DEADENDS2, TestCase.TARGET2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.openLock(TestCase.DEADENDS3, TestCase.TARGET3));
    }

    /**
     * 解法一：
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        if("0000".equals(target)) {
            return 0;
        }

        Set<String> deadsSet = new HashSet<>();
        for(String deadend : deadends) {
            deadsSet.add(deadend);
        }
        if(deadsSet.contains("0000")) {
            return -1;
        }

        int step = 0;
        LinkedList<String> queue = new LinkedList<>();
        queue.add("0000");
        Set<String> vis = new HashSet<>();
        vis.add("0000");

        while(!queue.isEmpty()) {
            step ++;
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                String state = queue.poll();
                List<String> nextStatus = getNextStatus(state);
                for(String nextState : nextStatus) {
                    if(!deadsSet.contains(nextState) && !vis.contains(nextState)) {
                        if(nextState.equals(target)) {
                            return step;
                        }
                        queue.offer(nextState);
                        vis.add(nextState);
                    }
                }
            }
        }

        return -1;
    }

    private List<String> getNextStatus(String state) {
        List<String> list = new ArrayList<>();
        char[] ch = state.toCharArray();
        for(int i = 0; i < 4; i ++) {
            char c = ch[i];
            // 递减
            ch[i] = decre(c);
            list.add(new String(ch));
            ch[i] = incre(c);
            list.add(new String(ch));
            ch[i] = c;
        }
        return list;
    }

    private char decre(char cur) {
        return cur == '0' ? '9' : (char) (cur-1);
    }

    private char incre(char cur) {
        return cur == '9' ? '0' : (char) (cur+1);
    }

    static class TestCase {
        public static int ANS = 6;
        public static String[] DEADENDS = {"0201","0101","0102","1212","2002"};
        public static String TARGET = "0202";

        public static int ANS1 = 1;
        public static String[] DEADENDS1 = {"8888"};
        public static String TARGET1 = "0009";

        public static int ANS2 = -1;
        public static String[] DEADENDS2 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        public static String TARGET2 = "8888";

        public static int ANS3 = -1;
        public static String[] DEADENDS3 = {"0000"};
        public static String TARGET3 = "8888";
    }
}
