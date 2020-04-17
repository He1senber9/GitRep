package club.vann.leetcode.offer.daily;

import javax.lang.model.type.IntersectionType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>难度：Medium</p>
 * <p>题目：合并区间</p>
 * <p>描述：给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 通过次数73,582提交次数177,490
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-04-16 09:56
 **/
public class LeetCode_56 {
    public static void main(String[] args) {
        LeetCode_56 leetCode = new LeetCode_56();

        int[][] result = null;
//        TestCase.printArrays(leetCode.merge(TestCase.intervals));
//        TestCase.printArrays(leetCode.merge(TestCase.intervals1));
//        TestCase.printArrays(leetCode.merge(TestCase.intervals2));
//        TestCase.printArrays(leetCode.merge(TestCase.intervals3));
        TestCase.printArrays(leetCode.merge(TestCase.intervals4));

        System.out.println("Succ");
    }

    /**
     * 解法一：
     * 采用栈辅助判断
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return intervals;
        }

        int len = intervals.length;
        List<int[]> list = new ArrayList<int[]>();
        list.add(intervals[0]);

        A: for(int i = 1; i < len; i ++) {
            int[] tag = intervals[i];
            boolean flag = false;
            B: for(int n = list.size()-1; n >= 0; n --) {
                int[] arr = list.get(n);

                if(!isContains(arr, tag)) {
                    arr[0] = Math.min(arr[0], tag[0]);
                    arr[1] = Math.max(arr[1], tag[1]);
                    tag[0] = arr[0];
                    tag[1] = arr[1];
                    flag = true;
                }
            }

            if(!flag) {
                list.add(tag);
            }

        }

        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i ++) {

            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }

    /**
     * 判断是否完全隔离
     * @param a
     * @param b
     * @return
     */
    private boolean isContains(int[] a, int[] b) {
        int[] arr = new int[2];
        if((a[0] < b[0] && a[1] < b[0]) || (b[0] < a[0] && b[1] < a[0])) {
            return true;
        } else {
            return false;
        }
    }

    static class TestCase {
        public static int[][] ans = {{1,6},{8,10},{15,18}};
        public static int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        public static int[][] ans1 = {{1,5}};
        public static int[][] intervals1 = {{1,4},{4,5}};

        public static int[][] ans2 = {{1,10}};
        public static int[][] intervals2 = {{2,3},{4,5},{6,7},{8,9},{1,10}};

        public static int[][] ans3 = {{1,3}, {4,7}};
        public static int[][] intervals3 = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};

        public static int[][] ans4 = {{0,0},{1,5}};
        public static int[][] intervals4 = {{1,1},{2,2},{0,0},{2,3},{1,3},{3,5},{2,3},{3,5}};

        public static void printArrays(int[][] arrays) {
            System.out.print("[");
            for(int[] arr : arrays) {
                System.out.print(Arrays.toString(arr));
                System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
