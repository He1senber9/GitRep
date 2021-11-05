package club.vann.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出两个指定的有序数组nums1,nums2。
 * 找出这两个数组的中位数。
 * 
 * @author vann
 *
 */
public class LeetCode_4 {

	public static void main(String[] args) {
//		int[] nums1 = {1, 3};
//		int[] nums2 = {2};

//		int[] nums1 = {3};
//		int[] nums2 = {-2, -1};

//        int[] nums1 = {1,2,3};
//        int[] nums2 = {1,2,3,4};

//        int[] nums1 = {1,2};
//        int[] nums2 = {3,4};

        int[] nums1 = {};
        int[] nums2 = {2,3};
		
		LeetCode_4 leetCode = new LeetCode_4();
		double result = leetCode.findMedianSortedArrays4(nums1, nums2);
		System.out.println("The result : " + result);
	}
	
	// 时间复杂度 O(n)
    private double findMedianSortedArrays1(int[] nums1, int[] nums2) {
    	double result = 0.0;
        if(nums1 == null || nums2 == null) {
            if(nums1 == null) {
                int len = nums2.length;
                return (len%2==0) ? (double)(nums2[len/2-1] + nums2[len/2])/2 : (double)nums2[len/2];
            } else {
                int len = nums1.length;
                return (len%2==0) ? (double)(nums1[len/2-1] + nums1[len/2])/2 : (double)nums1[len/2];
            }
        }
        
        int len1 = nums1.length;
        int len2 = nums2.length;

        List<Integer> list = new ArrayList<Integer>();
        int len = (len1 >= len2) ? len1 : len2;
        for(int n = 0; n < len; ++n) {
            if(n < len1) {
               list.add(nums1[n]);
            }
            if(n < len2) {
                list.add(nums2[n]);
            }
        }

        Integer[] nums = list.toArray(new Integer[0]);
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int size = nums.length;
        result = (size%2==0) ? (double)(nums[size/2-1] + nums[size/2])/2 : (double)nums[size/2];
        return result;
    }
    
    /**
     * 时间复杂度 O(log(m+n))
     * 
     * 解题：
     * 
     * 	1.若要从一个有序数组中找到一个数，要求时间复杂度是 O(logn),则应该对应二分查找法。
     *  2.小技巧:求一个有序数组中位数，当数组长度为 n 时， 中位数为第 (n+1)/2  和 (n+2)/2 两个数的平均数。（针对 n 为偶数或者奇数都适用）。
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    private double findMedianSortedArrays2(int[] nums1, int[] nums2) {
    	int len1 = nums1.length;
    	int len2 = nums2.length;
    	
    	float result = findK(nums1, 0, nums2, 0, (len1+len2+1)/2) + findK(nums1, 0, nums2, 0, (len1+len2+2)/2);
    	return result/2.0;
    }
    
    /**
     * 从两个有序数组中找到第 k 个元素。
     * 
     * 1.使用两个变量 indexM, indexN来标记数组nums1,nums2的起始位置。
     * 2.当某一个数组的起始位置大于等于其数组长度时，说明其所有数组均已经被淘汰了。所以意味着直接从另一个数组中找中位数即可。
     * 3.当k==1时，那么我们只要比较nums1和nums2的起始位置indexM,indexN上的数字即可。
     * 
     * 难点：
     * 因为要从两个有序数组找到第k个位置，为了加快速度，使用二分法。即对k二分。
     * 
     * 意思是我们需要分别在nums1和nums2中找到第k/2个元素。注意，由于两个数组长度不一定，所以有可能某个数组没有第k/2个元素。
     * 我们需要检查下，如果有，就取出来，否则返回一个整形最大值。
     * 
     * 如果某个数组没有第k/2个元素，那么我们就淘汰另一个数组的前k/2个元素。
     * 
     * 比较两个数组第k/2的数字midVal1和midVal2的大小，如果midVal1小的话，那么说明我们要找的数字肯定不在nums1的前k/2个元素里。
     * 所以可以将这些元素淘汰。将nums1的起始位置后移k/2个位置，并且k也减去k/2。递归调用。
     * 
     * @param nums1
     * @param indexM
     * @param nums2
     * @param indexN
     * @param k
     * @return
     */
    private int findK(int[] nums1, int indexM, int[] nums2, int indexN, int k) {
    	if(indexM >= nums1.length) {
    		return nums2[indexN+k -1]; // nums1为空数组
    	}
    	if(indexN >= nums2.length) {
    		return nums1[indexM+k -1];
    	}
    	
    	if(k == 1) {
    		return Math.min(nums1[indexM], nums2[indexN]);
    	}
    	
    	int midVal1 = ((indexM + k/2 - 1) < nums1.length) ? nums1[indexM + k/2 - 1] : Integer.MAX_VALUE;
    	int midVal2 = ((indexN + k/2 - 1) < nums1.length) ? nums2[indexM + k/2 - 1] : Integer.MAX_VALUE;
    	
    	if(midVal1 < midVal2) {
    		return findK(nums1, indexM+k/2, nums2, indexN, k-k/2);
    	} else {
    		return findK(nums1, indexM, nums2, indexN+k/2, k-k/2);
    	}
    }

    /**
     * 解法四：
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] arr = new int[m+n];
        int index1 = 0, index2 = 0;
        int index = 0;

        while(index1 < m || index2 < n) {
            if(index1 < m && index2 < n) {
                if(nums1[index1] <= nums2[index2]) {
                    arr[index] = nums1[index1];
                    index ++;
                    index1 ++;
                } else {
                    arr[index] = nums2[index2];
                    index ++;
                    index2 ++;
                }
            } else if(index1 < m){
                arr[index] = nums1[index1];
                index ++;
                index1 ++;
            } else {
                arr[index] = nums2[index2];
                index ++;
                index2 ++;
            }
        }

        double ans = 0.0;
        if((m+n) % 2 == 0) {
            ans =  ((double) (arr[(m+n-1)/2] + arr[(m+n-1)/2+1]))/ 2;
        } else {
            ans = arr[(m+n-1)/2];
        }
        return ans;
    }

    /**
     * 解法五：
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int index1 = 0, index2 = 0;
        int index = -1;

        int mid1 = (m+n)%2==0 ? (m+n-1)/2 : (m+n-1)/2;
        int mid2 = (m+n)%2==0 ? (m+n-1)/2+1 : (m+n-1)/2;
        double sum = 0.0;
        while(index1 < m || index2 < n) {
            if(index1 < m && index2 < n) {
                if(nums1[index1] <= nums2[index2]) {
                    index ++;

                    if(index == mid1) {
                        sum += (double) nums1[index1];
                        mid1 = -1;
                    }

                    if(index == mid2) {
                        sum += (double) nums1[index1];
                        break;
                    }

                    index1 ++;
                } else {
                    index ++;

                    if(index == mid1) {
                        sum += (double) nums2[index2];
                        mid1 = -1;
                    }

                    if(index == mid2) {
                        sum += (double) nums2[index2];
                        break;
                    }

                    index2 ++;
                }
            } else if(index1 < m) {
                index ++;
                if(index == mid1) {
                    sum += (double) nums1[index1];
                    mid1 = -1;
                }

                if(index == mid2) {
                    sum += (double) nums1[index1];
                    break;
                }
                index1 ++;
            } else {
                index ++;
                if(index == mid1) {
                    sum += (double) nums2[index2];
                    mid1 = -1;
                }

                if(index == mid2) {
                    sum += (double) nums2[index2];
                    break;
                }
                index2 ++;
            }
        }

        return sum/2;
    }

}
