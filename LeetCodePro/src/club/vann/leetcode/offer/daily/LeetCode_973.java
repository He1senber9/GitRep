package club.vann.leetcode.offer.daily;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：最接近原点的K个坐标</p>
 * <p>描述：我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *  
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 * 通过次数24,582提交次数41,004
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-09 19:48
 **/
public class LeetCode_973 {
    public static void main(String[] args) {
        LeetCode_973 leetCode = new LeetCode_973();

        int[][] result = null;
//        result  = leetCode.kClosest(TestCase.POINTS, TestCase.K);
        result  = leetCode.kClosest(TestCase.POINTS1, TestCase.K1);

        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;

        SortedLinkedList sortedLinkedList = new SortedLinkedList();
        for(int i = 0; i < len; i ++) {
            sortedLinkedList.put(points[i]);
        }

        int[][] result = new int[K][2];
        SortedLinkedList.Enty head = sortedLinkedList.head;
        SortedLinkedList.Enty curEnty = head.next;
        for(int i = 0; i < K; i ++) {
            result[i][0] = curEnty.array[0];
            result[i][1] = curEnty.array[1];
            curEnty = curEnty.next;
        }
        return result;
    }

    class SortedLinkedList {
        Enty head;
        Enty tail;

        SortedLinkedList() {
            head = new Enty(new int[]{});
            head.next = null;
        }

        void put(int[] array) {
            if(head.next == null) {
                putHead(array);
                return;
            }

            Enty<int[]> preEnty = head;
            Enty<int[]> curEnty = head.next;
            while(curEnty != null) {
                int[] arr = curEnty.array;
                if((arr[0]*arr[0] + arr[1]*arr[1]) < (array[0]*array[0] + array[1]*array[1])) {
                    preEnty = preEnty.next;
                    curEnty = curEnty.next;
                } else {
                    break;
                }
            }

            // 放入节点
            Enty<int[]> newEnty = new Enty<>(array);
            preEnty.next = newEnty;
            newEnty.next = curEnty;
        }

        private void putHead(int[] array) {
            Enty<int[]> enty = new Enty<>(array);
            head.next = enty;
        }

        class Enty<O> {
            int[] array;
            Enty next;
            Enty(int[] array) {
                this.array = array;
            }
        }
    }

    static class TestCase {
        public static int[][] POINTS = {{1, 3}, {-2, 2}};
        public static int K = 1;

        public static int[][] POINTS1 = {{3, 3}, {5, -1}, {-2, 4}};
        public static int K1 = 2;
    }
}
