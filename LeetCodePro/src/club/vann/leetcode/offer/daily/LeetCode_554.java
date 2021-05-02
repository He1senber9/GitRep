package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：砖墙</p>
 * <p>描述：你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
 *
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
 * 输出：2
 * 示例 2：
 *
 * 输入：wall = [[1],[1],[1]]
 * 输出：3
 *  
 * 提示：
 *
 * n == wall.length
 * 1 <= n <= 104
 * 1 <= wall[i].length <= 104
 * 1 <= sum(wall[i].length) <= 2 * 104
 * 对于每一行 i ，sum(wall[i]) 应当是相同的
 * 1 <= wall[i][j] <= 231 - 1
 * 通过次数21,243提交次数50,831
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_554
 * @Description TODO
 * @User fanyu
 * @Date 2021/5/2 9:47
 */
public class LeetCode_554 {
    public static void main(String[] args) {
        LeetCode_554 leetCode = new LeetCode_554();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.leastBricks(TestCase.WALL()));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.leastBricks(TestCase.WALL1()));
    }

    /**
     * 解法一：
     *
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0) {
            return 0;
        }

        int len = 0;
        List<Integer> list = wall.get(0);
        for(int i : list) {
            len += i;
        }

        //int[] tags = new int[size+1];
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> wal : wall) {
            int pre = 0;
            for(int j : wal) {
                int key = j + pre;
                map.put(key, map.getOrDefault(key, 0) + 1);

                pre = key;
            }
        }

        map.remove(len);

        int height = wall.size();
        int res = height;
        for(int key : map.keySet()) {
            res = Math.min(res, height - map.get(key));
        }
        return res;
    }

    static class TestCase {
        public static int ANS = 2;
        public static List<List<Integer>> WALL() {
            List<List<Integer>> wall = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(2);
            list.add(1);
            wall.add(list);

            List<Integer> list1 = new ArrayList<>();
            list1.add(3);
            list1.add(1);
            list1.add(2);
            wall.add(list1);


            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            list2.add(3);
            list2.add(2);
            wall.add(list2);


            List<Integer> list3 = new ArrayList<>();
            list3.add(2);
            list3.add(4);
            wall.add(list3);


            List<Integer> list4 = new ArrayList<>();
            list4.add(3);
            list4.add(1);
            list4.add(2);
            wall.add(list4);


            List<Integer> list5 = new ArrayList<>();
            list5.add(1);
            list5.add(3);
            list5.add(1);
            list5.add(1);
            wall.add(list5);

            return wall;
        }

        public static int ANS1 = 3;
        public static List<List<Integer>> WALL1() {
            List<List<Integer>> wall = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(1);
            wall.add(list);

            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            wall.add(list1);


            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            wall.add(list2);

            return wall;
        }

    }
}