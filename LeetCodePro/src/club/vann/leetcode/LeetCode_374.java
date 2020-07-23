package club.vann.leetcode;

/**
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-22 17:00
 **/
public class LeetCode_374 {
    public static void main(String[] args) {
        LeetCode_374 leetCode = new LeetCode_374();
        System.out.println(leetCode.guessNumber(10));
    }

    private int guessNumber(int n) {
        int left = 1, right = n;
        while(left <= right) {
            int mid = left + (right-left)/2;
            int v = guess(mid);
            if(v == 0) {
                return mid;
            } else if(v == -1) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    private static int guess(int n) {
        if(n == 6) {
            return 0;
        } else if(n > 6) {
            return 1;
        } else {
            return -1;
        }
    }
}
