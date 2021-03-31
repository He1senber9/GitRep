package club.vann.leetcode.offer.daily;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>难度：Easy</p>
 * <p>题目：数据流中的第 K 大元素</p>
 * <p>描述：设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *  
 *
 * 提示：
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * 最多调用 add 方法 104 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 * 通过次数34,432提交次数73,658
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-11:09:32:01
 */
public class LeetCode_703 {
    public static void main(String[] args) {
        KthLargest demo = new KthLargest(3, new int[]{4, 5, 8, 2});

        System.out.println(demo.add(3));
        System.out.println(demo.add(5));
        System.out.println(demo.add(10));
        System.out.println(demo.add(9));
        System.out.println(demo.add(4));

        System.out.println("=====================");
        KthLargest demo1 = new KthLargest(1, new int[]{});

        System.out.println(demo1.add(-3));
        System.out.println(demo1.add(-2));
        System.out.println(demo1.add(-4));
        System.out.println(demo1.add(0));
        System.out.println(demo1.add(4));
    }
}

class KthLargest {

    int k;
    PriorityQueue<Integer> queue;
    public KthLargest(int k, int[] nums) {
        int len = nums.length;
        this.k = k;
        queue = new PriorityQueue<>();

        for(int x : nums) {
            queue.offer(x);
        }
    }

    public int add(int val) {
        queue.offer(val);
        while(queue.size() > k) {
            queue.poll();
        }

        return queue.peek();
    }
}
