package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Hard</p>
 * <p>题目：滑动窗口的中位数</p>
 * <p>描述：中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 *
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 *  
 *
 * 示例：
 *
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 *
 *  
 *
 * 提示：
 *
 * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 * 通过次数10,123提交次数24,948
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-03:10:52:36
 */
public class LeetCode_480 {
    public static void main(String[] args) {
        LeetCode_480 leetCode = new LeetCode_480();

//        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.medianSlidingWindow(TestCase.NUMS, TestCase.K)));
//        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.medianSlidingWindow(TestCase.NUMS1, TestCase.K1)));
//        System.out.println("Result["+ Arrays.toString(TestCase.ANS2)+"] : " + Arrays.toString(leetCode.medianSlidingWindow(TestCase.NUMS2, TestCase.K2)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS3)+"] : " + Arrays.toString(leetCode.medianSlidingWindow(TestCase.NUMS3, TestCase.K3)));
    }

    /**
     * 解法一：
     *  暴力破解。
     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
//        int len = nums.length;
//        double[] ans = new double[len-k+1];
//
//        // 定义优先队列
//        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((x,y) ->{
//            return y-x;
//        });
//        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int i = 0; i < k; i ++) {
//            maxQueue.offer(nums[i]);
//        }
//
//        for(int i = 0; i < k/2; i ++) {
//            minQueue.offer(maxQueue.poll());
//        }
//
//        ans[0] = getMid(k, maxQueue, minQueue);
//        int index = 1;
//        for(int i = k; i < len; i ++) {
//            // 平衡标志
//            int bal = 0;
//            int left = nums[i-k];
//            map.put(left, map.getOrDefault(left, 0) + 1);
//
//            // 要删除的元素在大根堆中
//            if(!maxQueue.isEmpty() && left <= maxQueue.peek()) {
//                bal --;
//            } else {
//                bal ++;
//            }
//
//            // 新增的元素在大根堆中
//            if(!maxQueue.isEmpty() && nums[i] <= maxQueue.peek()) {
//                maxQueue.offer(nums[i]);
//                bal ++;
//            } else {
//                minQueue.offer(nums[i]);
//                bal --;
//            }
//
//            // 调整平衡
//            if(bal > 0) {
//                minQueue.offer(maxQueue.poll());
//            }
//            if(bal < 0) {
//                maxQueue.offer(minQueue.poll());
//            }
//
//            // 判断堆顶元素是否是需要删除的
//            while(!maxQueue.isEmpty() && map.containsKey(maxQueue.peek()) && map.get(maxQueue.peek()) > 0) {
//                map.put(maxQueue.peek(), map.get(maxQueue.peek())-1);
//                maxQueue.poll();
//            }
//
//            // 判断堆顶元素是否是需要删除的
//            while(!minQueue.isEmpty() && map.containsKey(minQueue.peek()) && map.get(minQueue.peek()) > 0) {
//                map.put(minQueue.peek(), map.get(minQueue.peek())-1);
//                minQueue.poll();
//            }
//
//            ans[index++] = getMid(k, maxQueue, minQueue);
//        }
//        return ans;

        int len = nums.length;
        double[] ans = new double[len-k+1];

        // 大根堆，小根堆
//        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            public int compare(Integer num1, Integer num2) {
//                return num2.compareTo(num1);
//            }
//        });
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((x,y) -> {
            return y.compareTo(x);
        });
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        // 先计算前 k 个元素
        for(int i = 0; i < k; i ++) {
            maxQueue.offer(nums[i]);
        }

        for(int i = 0; i < k/2; i ++) {
            minQueue.offer(maxQueue.poll());
        }

        int index = 0;
        ans[index++] = getMid(k, maxQueue, minQueue);

        // 标记要删除的元素
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = k; i < len; i ++) {
            int bal = 0;
            // 要删除的元素
            int remove = nums[i-k];
            map.put(remove, map.getOrDefault(remove, 0) + 1);

            // 要删除的元素在大根堆中
            if(!maxQueue.isEmpty() && remove <= maxQueue.peek()) {
                bal --;
            } else {
                bal ++;
            }

            // 新增的元素
            int newNum = nums[i];
            if(!maxQueue.isEmpty() && newNum <= maxQueue.peek()) {
                maxQueue.offer(newNum);
                bal ++;
            } else {
                minQueue.offer(newNum);
                bal --;
            }

            // 调整平衡
            if(bal > 0) {
                minQueue.offer(maxQueue.poll());
            }
            if(bal < 0) {
                maxQueue.offer(minQueue.poll());
            }

            // 在计算结果前先判断当前堆顶的元素是否是要删除的元素
            while(!maxQueue.isEmpty() && map.containsKey(maxQueue.peek()) && map.get(maxQueue.peek()) > 0) {
                int tag = maxQueue.poll();
                map.put(tag, map.get(tag) - 1);
            }

            while(!minQueue.isEmpty() && map.containsKey(minQueue.peek()) && map.get(minQueue.peek()) > 0) {
                int tag = minQueue.poll();
                map.put(tag, map.get(tag) - 1);
            }

            // 计算结果
            ans[index++] = getMid(k, maxQueue, minQueue);
        }

        return ans;
    }

    private double getMid(int k, PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        if(k % 2 == 0) {
            return max.peek()*0.5 + min.peek()*0.5;
        } else {
            return max.peek();
        }
    }

    static class TestCase {
        public static double[] ANS = {1,-1,-1,3,5,6};
        public static int[] NUMS = {1,3,-1,-3,5,3,6,7};
        public static int K = 3;

        public static double[] ANS1 = {2147483647.0};
        public static int[] NUMS1 = {2147483647,2147483647};
        public static int K1 = 2;

        public static double[] ANS2 = {2.0, 3.0, 3,0, 3.0, 2.0, 3.0, 2.0};
        public static int[] NUMS2 = {1,2,3,4,2,3,1,4,2};
        public static int K2 = 3;

        public static double[] ANS3 = {-2147483648.0, -2147483648.0, -2147483648.0, -2147483648.0, -2147483648.0, 2147483647.0, 2147483647.0, 2147483647.0, 2147483647.0, 2147483647.0, -2147483648.0};
        public static int[] NUMS3 = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        public static int K3 = 3;
    }

}
