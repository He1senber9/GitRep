package club.vann.leetcode;

/**
 * <p>难度：Hard</p>
 * <p>题目：强密码校验器</p>
 * <p>描述：一个强密码应满足以下所有条件：
 *
 * 由至少6个，至多20个字符组成。
 * 至少包含一个小写字母，一个大写字母，和一个数字。
 * 同一字符不能连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 是可以的)。
 * 编写函数 strongPasswordChecker(s)，s 代表输入字符串，如果 s 已经符合强密码条件，则返回0；否则返回要将 s 修改为满足强密码条件的字符串所需要进行修改的最小步数。
 *
 * 插入、删除、替换任一字符都算作一次修改。
 *
 * 通过次数2,035提交次数10,580
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strong-password-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-12-25 20:41
 **/
public class LeetCode_420 {
    public static void main(String[] args) {
        LeetCode_420 leetCode = new LeetCode_420();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.strongPasswordChecker(TestCase.PASSWORD));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.strongPasswordChecker(TestCase.PASSWORD1));
    }

    /**
     * 解法一：
     *
     * @param password
     * @return
     */
    public int strongPasswordChecker(String password) {
        if(password == null) {
            return 0;
        }
        return 0;
    }

    static class TestCase {
        public static int ANS = 4;
        public static String PASSWORD = "aaaaaa"; // Abc1aa

        public static int ANS1 = 0;
        public static String PASSWORD1 = "Abc1aa";
    }
}
