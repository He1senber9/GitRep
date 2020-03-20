package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p>题目：最小的k个数</p>
 * <p>描述：输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * 通过次数20,978提交次数34,169</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/20
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_40 {
    public static void main(String[] args) {
        int[] arr = null;
        int k = 0;
        int[] result = null;
        LeetCode_40 leetCode = new LeetCode_40();

        arr = new int[]{3,2,1};
        k = 2;
        result = leetCode.getLeastNumbers(arr, k);
        System.out.println("Result[[1,2] 或者 [2,1]] : " + Arrays.toString(result));

        arr = new int[]{0,1,2,1};
        k = 1;
        result = leetCode.getLeastNumbers(arr, k);
        System.out.println("Result[0] : " + Arrays.toString(result));
    }

    /**
     * 解法一：采用冒泡算法对数组排序。
     * 每一轮可以挑出最小的元素到数组最后面。
     * @param arr
     * @param k
     * @return
     */
    private int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0) {
            return new int[]{};
        }

        int len = arr.length;
        int[] result = new int[k];

        for(int n = len-1; n >= 0; n --) {
            for(int m = len-1; m >= len-1-n+1; m --) {
                if(arr[m-1] > arr[m]) {
                    arr[m-1] = arr[m-1] ^ arr[m];
                    arr[m] = arr[m-1] ^ arr[m];
                    arr[m-1] = arr[m-1] ^ arr[m];
                }
            }

            if(n >= len-k) {
                result[len-1-n] = arr[len-1-n];
            } else {
                break;
            }
        }

        return result;
    }
}
