package club.vann.leetcode;

public class LeetCode_762 {

	public static void main(String[] args) {
		int l = 990, r = 1048;
		
		LeetCode_762 leetCode = new LeetCode_762();
		int result = leetCode.countPrimeSetBits(l, r);
		System.out.println(result);
	}
	
	private int countPrimeSetBits(int L, int R) {
		if(R <= 2) {
			return 0;
		}
		
		int result = 0;
		for(int n = L; n <= R; n ++) {
			int count = Integer.bitCount(n);
			if(isPrime(count)) {
				result ++;
			}
		}
        return result;
    }
	
	private boolean isPrime(int num) {
		if(num == 2) {
			return true;
		}
		
		if(num == 1 || (num % 2) == 0) {
			return false;
		}
		
		for(int n = 3; n <= Math.sqrt(num); n+=2) {
			if(num % n == 0) {
				return false;
			}
		}
		
		return true;
	}

}
