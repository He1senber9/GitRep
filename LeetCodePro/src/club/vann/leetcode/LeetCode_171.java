package club.vann.leetcode;

public class LeetCode_171 {

	public static void main(String[] args) {
		String str = "A";
		String str1 = "AA";
		
		LeetCode_171 leetCode = new LeetCode_171();
		int result = leetCode.titleToNumber(str1);
		System.out.println(result);
	}
	
	private int titleToNumber(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        int len = s.length();
        
        for(int n = 0; n < len; n ++) {
            char ch = s.charAt(n);
            int x = len- 1 - n;
            
            result = (int) (result + ((ch - 'A')+1) * Math.pow(26, x));
        }
        
        return result;
    }

}
