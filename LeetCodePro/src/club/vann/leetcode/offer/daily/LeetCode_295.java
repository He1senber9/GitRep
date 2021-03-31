package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>难度：Hard</p>
 * <p>题目：数据流的中位数</p>
 * <p>描述：中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 通过次数28,914提交次数57,522
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-03:12:28:47
 */
public class LeetCode_295 {
    public static void main(String[] args) {
        LeetCode_295 leetCode = new LeetCode_295();
        MedianFinder medianFinder = leetCode.new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    /**
     * 解法一实现：
     */
//    class MedianFinder {
//        List<Integer> list;
//
//        /** initialize your data structure here. */
//        public MedianFinder() {
//            list = new ArrayList<>();
//        }
//
//        public void addNum(int num) {
//            list.add(num);
//        }
//
//        public double findMedian() {
//            if(list.isEmpty()) {
//                return 0.0;
//            }
//
//            Collections.sort(list);
//            int size = list.size();
//
//            return (size%2==0) ? ((list.get(size/2-1)+list.get(size/2))*0.5) : list.get(size/2);
//        }
//    }

    /**
     * 解法二实现：
     */
    class MedianFinder {
        /**
         * 当前大顶堆和小顶堆的元素个数之和
         */
        private int count;
        private PriorityQueue<Integer> maxheap;
        private PriorityQueue<Integer> minheap;

        /** initialize your data structure here. */
        public MedianFinder() {
            count = 0;
            maxheap = new PriorityQueue<>((x, y) -> y - x);
            minheap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            count += 1;
            maxheap.offer(num);
            minheap.add(maxheap.poll());
            // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
            if ((count & 1) != 0) {
                maxheap.add(minheap.poll());
            }
        }

        public double findMedian() {
            if ((count & 1) == 0) {
                // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
                return (double) (maxheap.peek() + minheap.peek()) / 2;
            } else {
                // 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
                return (double) maxheap.peek();
            }
        }
    }
}
