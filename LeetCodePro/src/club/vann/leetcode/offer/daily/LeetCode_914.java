package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Eays</p>
 * <p>题目：卡牌分组</p>
 * <p>描述：给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 *
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 *
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 *
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 提示：
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *  
 *
 * 通过次数12,095提交次数35,620
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/27
 * Time: 8:57
 * Description:
 */
public class LeetCode_914 {
    public static void main(String[] args) {
        int[] deck = null;
        boolean result = false;
        LeetCode_914 leetCode = new LeetCode_914();

        deck = new int[]{1,2,3,4,4,3,2,1};
        result = leetCode.hasGroupsSizeX(deck);
        System.out.println("Result[True] : " + result);

        deck = new int[]{1,1,1,2,2,2,3,3};
        result = leetCode.hasGroupsSizeX(deck);
        System.out.println("Result[False] : " + result);

        deck = new int[]{1};
        result = leetCode.hasGroupsSizeX(deck);
        System.out.println("Result[False] : " + result);

        deck = new int[]{1,1};
        result = leetCode.hasGroupsSizeX(deck);
        System.out.println("Result[True] : " + result);

        deck = new int[]{1,1,2,2,2,2};
        result = leetCode.hasGroupsSizeX(deck);
        System.out.println("Result[True] : " + result);

        deck = new int[]{4,4,4,8,8,8};
        result = leetCode.hasGroupsSizeX(deck);
        System.out.println("Result[True] : " + result);
    }

    /**
     * 解法一：
     *
     * @param deck
     * @return
     */
    private boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        if(len == 1) {
            return false;
        }

        // 计算每个元素对应的个数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n = 0; n < len; n ++) {
            map.put(deck[n], map.containsKey(deck[n]) ? map.get(deck[n]) + 1 : 1);
        }

        List<Integer> list = new ArrayList<Integer>();
        for(int n : map.keySet()) {
            list.add(map.get(n));
        }

        int code = ngcd(list, list.size()-1);
        return code >= 2;
    }

    /**
     * 求两个数的最大公约数
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x%y);
    }

    /**
     * 求N个数的最大公约数
     * @param list
     * @param n
     * @return
     */
    private int ngcd(List<Integer> list, int n) {
        if(n == 0) {
            return list.get(0);
        }

        return gcd(list.get(n), ngcd(list, n-1));
    }
}
