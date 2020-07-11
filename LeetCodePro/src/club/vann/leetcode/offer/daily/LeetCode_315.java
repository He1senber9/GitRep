package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Hard</p>
 * <p>题目：计算右侧小于当前元素的个数</p>
 * <p>描述：给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * 通过次数19,194提交次数49,992
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/11
 * Time: 8:34
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_315 {
    public static void main(String[] args) {
        LeetCode_315 leetCode = new LeetCode_315();

        System.out.println("Result["+Arrays.toString(TestCase.ANS)+"] : " + leetCode.countSmaller(TestCase.NUMS));
        System.out.println("Result["+Arrays.toString(TestCase.ANS1)+"] : " + leetCode.countSmaller(TestCase.NUMS1));
    }

    /**
     * 解法一：
     * 暴力破解
     * @param nums
     * @return
     */
    private List<Integer> countSmaller(int[] nums) {
        List<Integer> rest = new ArrayList<>();
        if(nums == null || nums.length < 2) {
            return rest;
        }
        int len = nums.length;
        int[] counts = new int[len];
        counts[len-1] = 0;
        for(int n = len-2; n >= 0; n --) {
            int tag = nums[n];
            int count = 0;
            for(int m = len-1; m > n; m --) {
                if(tag > nums[m]) {
                    count ++;
                }
            }
            counts[n] = count;
        }

        for(int n = 0; n < len; n ++) {
            rest.add(counts[n]);
        }

        return rest;
    }

    private int[] c;
    private int[] a;
    /**
     * 解法二：
     *
     * @param nums
     * @return
     */
    private List<Integer> countSmaller1(int[] nums) {
        List<Integer> resultList = new ArrayList<Integer>();
        discretization(nums);
        init(nums.length + 5);
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            resultList.add(query(id - 1));
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;
    }

    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }

        return ret;
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }

    private int[] temp;
    private int[] counter;
    private int[] indexes;

    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        temp = new int[len];
        counter = new int[len];
        indexes = new int[len];
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        mergeAndCountSmaller(nums, 0, len - 1);
        for (int i = 0; i < len; i++) {
            res.add(counter[i]);
        }
        return res;
    }

    /**
     * 针对数组 nums 指定的区间 [l, r] 进行归并排序，在排序的过程中完成统计任务
     *
     * @param nums
     * @param l
     * @param r
     */
    private void mergeAndCountSmaller(int[] nums, int l, int r) {
        if (l == r) {
            // 数组只有一个元素的时候，没有比较，不统计
            return;
        }
        int mid = l + (r - l) / 2;
        mergeAndCountSmaller(nums, l, mid);
        mergeAndCountSmaller(nums, mid + 1, r);
        // 归并排序的优化，同样适用于该问题
        // 如果索引数组有序，就没有必要再继续计算了
        if (nums[indexes[mid]] > nums[indexes[mid + 1]]) {
            mergeOfTwoSortedArrAndCountSmaller(nums, l, mid, r);
        }
    }

    /**
     * [l, mid] 是排好序的
     * [mid + 1, r] 是排好序的
     *
     * @param nums
     * @param l
     * @param mid
     * @param r
     */
    private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int l, int mid, int r) {
        // 3,4  1,2
        for (int i = l; i <= r; i++) {
            temp[i] = indexes[i];
        }
        int i = l;
        int j = mid + 1;
        // 左边出列的时候，计数
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                indexes[k] = temp[j];
                j++;
            } else if (j > r) {
                indexes[k] = temp[i];
                i++;
                // 此时 j 用完了，[7,8,9 | 1,2,3]
                // 之前的数就和后面的区间长度构成逆序
                counter[indexes[k]] += (r - mid);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                indexes[k] = temp[i];
                i++;
                // 此时 [4,5, 6   | 1,2,3 10 12 13]
                //           mid          j
                counter[indexes[k]] += (j - mid - 1);
            } else {
                // nums[indexes[i]] > nums[indexes[j]] 构成逆序
                indexes[k] = temp[j];
                j++;
            }
        }
    }

    /**
     * 线段树思想
     * @param nums
     * @return
     */
    public List<Integer> countSmaller3(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        if(len == 0) {
            return res;
        }
        //获取区间范围
        int start = nums[0], end = nums[0];
        for(int i = 0; i < len; i++){
            if(nums[i] < start){
                start = nums[i];
            }
            if(nums[i] > end){
                end = nums[i];
            }
        }
        //构建树
        SegmentTreeNode root = build(start, end);
        //从右向左，边插入边计数
        for(int i = len - 1; i >= 0; i--){
            //计数小于该元素的区间，所以要减一
            res.addFirst(count(root, start, nums[i] - 1));
            insert(root, nums[i], 1);
        }
        return res;
    }
    //线段树节点，包含左右最值和该区间叶子节点数，子区间不断递减
    private class SegmentTreeNode{
        int start, end, count;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.count = 0;
            left = null;
            right = null;
        }
    }
    //构建线段树，不断递减区间长度
    private SegmentTreeNode build(int start, int end){
        if(start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if(start != end){
            int mid = start + (end - start) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        }
        return root;
    }
    //插入并更新叶子节点
    private void insert(SegmentTreeNode root, int index, int val){

        if (root.start == index && root.end == index){
            root.count += val;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (index >= root.start && index <= mid) {
            insert(root.left, index, val);
        }

        if (index > mid && index <= root.end){
            insert(root.right, index, val);
        }
        //更新父节点的统计数，便于正好落在区间上的查找
        root.count = root.left.count + root.right.count;
    }
    //根据区间统计
    private int count(SegmentTreeNode root, int start, int end){
        //nums[i] - 1, 排除相等的情况
        if(start > end) {
            return 0;
        }
        //递归到叶子节点，获取计数值
        if (start == root.start && end == root.end){
            return root.count;
        }
        int mid = root.start + (root.end - root.start) / 2;
        int leftcount = 0, rightcount = 0;
        //统计左半区
        if (start <= mid){
            if (mid < end) {
                leftcount = count(root.left, start, mid);
            }
            else {
                leftcount = count(root.left, start, end);
            }
        }
        //统计右半区
        if (mid < end){
            if (start <= mid) {
                rightcount = count(root.right, mid + 1, end);
            } else {
                rightcount = count(root.right, start, end);
            }
        }
        return (leftcount + rightcount);
    }

    static class TestCase {
        public static final int[] ANS = {2,1,1,0};
        public static final int[] NUMS = {5,2,6,1};

        public static final int[] ANS1 = {10,9,7,6,4,4,4,3,2,1,0};
        public static final int[] NUMS1 = {10,9,8,7,5,6,8,4,3,2,1};
    }
}
