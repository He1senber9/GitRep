package leetcode;

public class LeetCode_476 {

	public static void main(String[] args) {
		LeetCode_476 leetCode = new LeetCode_476();
		
		int m = leetCode.findComplement(Integer.MAX_VALUE-1);
		System.out.println(m);
	}
	
	public int findComplement(int num) {
        long x = 1;
        
        while(num >= x) {
            x = x << 1;
        }
        
        return (int) (num ^ (x-1));
        
    }

}
