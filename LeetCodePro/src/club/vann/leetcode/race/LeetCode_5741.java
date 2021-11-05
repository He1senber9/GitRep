package club.vann.leetcode.race;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>难度：Hard</p>
 * <p>题目：最高建筑高度</p>
 * <p>描述：在一座城市里，你需要建 n 栋新的建筑。这些新的建筑会从 1 到 n 编号排成一列。
 *
 * 这座城市对这些新建筑有一些规定：
 *
 * 每栋建筑的高度必须是一个非负整数。
 * 第一栋建筑的高度 必须 是 0 。
 * 任意两栋相邻建筑的高度差 不能超过  1 。
 * 除此以外，某些建筑还有额外的最高高度限制。这些限制会以二维整数数组 restrictions 的形式给出，其中 restrictions[i] = [idi, maxHeighti] ，表示建筑 idi 的高度 不能超过 maxHeighti 。
 *
 * 题目保证每栋建筑在 restrictions 中 至多出现一次 ，同时建筑 1 不会 出现在 restrictions 中。
 *
 * 请你返回 最高 建筑能达到的 最高高度 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 5, restrictions = [[2,1],[4,1]]
 * 输出：2
 * 解释：上图中的绿色区域为每栋建筑被允许的最高高度。
 * 我们可以使建筑高度分别为 [0,1,2,1,2] ，最高建筑的高度为 2 。
 * 示例 2：
 *
 *
 * 输入：n = 6, restrictions = []
 * 输出：5
 * 解释：上图中的绿色区域为每栋建筑被允许的最高高度。
 * 我们可以使建筑高度分别为 [0,1,2,3,4,5] ，最高建筑的高度为 5 。
 * 示例 3：
 *
 *
 * 输入：n = 10, restrictions = [[5,3],[2,5],[7,4],[10,3]]
 * 输出：5
 * 解释：上图中的绿色区域为每栋建筑被允许的最高高度。
 * 我们可以使建筑高度分别为 [0,1,2,3,3,4,4,5,4,3] ，最高建筑的高度为 5 。
 *
 *
 * 提示：
 *
 * 2 <= n <= 109
 * 0 <= restrictions.length <= min(n - 1, 105)
 * 2 <= idi <= n
 * idi 是 唯一的 。
 * 0 <= maxHeighti <= 109</p>
 * @ClassName LeetCode_5741
 * @Description TODO
 * @User fanyu
 * @Date 2021/4/25 11:45
 */
public class LeetCode_5741 {
    public static void main(String[] args) {
        LeetCode_5741 leetCode = new LeetCode_5741();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxBuilding(TestCase.N, TestCase.RESTRICTIONS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxBuilding(TestCase.N1, TestCase.RESTRICTIONS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxBuilding(TestCase.N2, TestCase.RESTRICTIONS2));
    }

    public int maxBuilding(int n, int[][] restrictions) {
        if(restrictions.length == 0) {
            return n-1;
        }

        int[] tags = new int[n];
        for(int i = 0; i < n; i ++) {
            tags[i] = i;
        }

        Arrays.sort(restrictions, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });

        for(int[] arr : restrictions) {
            int index = arr[0]-1;
            int height =  arr[1];
            if(tags[index] <= height) {
                continue;
            }

            tags[index] = height;

            // 左边调整
            for(int left = index-1; left >= 0; left --) {
                if(tags[left]-tags[left+1] > 1) {
                    tags[left] = tags[left+1]+1;
                } else {
                    break;
                }
            }

            // 右边调整
            for(int right = index+1; right < n; right ++) {
                if(tags[right]-tags[right-1] > 1) {
                    tags[right] = tags[right-1]+1;
                } else {
                    break;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i ++) {
            max = Math.max(max, tags[i]);
        }
        return max;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int N = 5;
        public static int[][] RESTRICTIONS = {{2, 1}, {4, 1}};

        public static int ANS1 = 5;
        public static int N1 = 6;
        public static int[][] RESTRICTIONS1 = {};

        public static int ANS2 = 5;
        public static int N2 = 10;
        public static int[][] RESTRICTIONS2 = {{5, 3}, {2, 5}, {7, 4}, {10, 3}};
    }
}
