package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * <p>难度：Medium</p>
 * <p>题目：账户合并</p>
 * <p>描述：给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 *  
 *
 * 提示：
 *
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 * 通过次数8,213提交次数21,410
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_721
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/18 8:34
 */
public class LeetCode_721 {
    public static void main(String[] args) {
        LeetCode_721 leetCode = new LeetCode_721();

        List<List<String>> result = null;
        result = leetCode.accountsMerge(TestCase.ACCOUNTS);
        result = leetCode.accountsMerge(TestCase.ACCOUNTS1);
        result = leetCode.accountsMerge(TestCase.ACCOUNTS2);
        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 保存Email与序号映射关系
        Map<String, Integer> mailIndexMap = new HashMap<>();
        // 保存Email与户名映射关系
        Map<String, String> mailNameMap = new HashMap<>();

        // 对每个唯一的eamil编号
        int counts = 0;
        for(List<String> account : accounts) {
            String name = account.get(0);
            for(int i = 1; i < account.size(); i ++) {
                if(!mailIndexMap.containsKey(account.get(i))) {
                    mailIndexMap.put(account.get(i), counts++);
                    mailNameMap.put(account.get(i), name);
                }
            }
        }

        // 先针对每个分组里的eamil信息合并
        UnionUtil unionUtil = new UnionUtil(counts);
        for(List<String> account : accounts) {
            String baseMail = account.get(1);
            int x = mailIndexMap.get(baseMail);
            for(int i = 2; i < account.size(); i ++) {
                String mail = account.get(i);
                int y = mailIndexMap.get(mail);
                unionUtil.union(x, y);
            }
        }

        Map<Integer, List<String>> map = new HashMap<>();
        // 遍历每个账户信息，挑选
        for(String mail : mailIndexMap.keySet()) {
            int index = mailIndexMap.get(mail);
            int rootIndex = unionUtil.find(index);
            List<String> list = map.getOrDefault(rootIndex, new ArrayList<String>());
            if(!list.contains(mail)) {
                list.add(mail);
                map.put(rootIndex, list);
            }
        }

        List<List<String>> rest = new ArrayList<>();
        for(int index : map.keySet()) {
            List<String> mails = map.get(index);
            Collections.sort(mails);
            // 户名
            String name = mailNameMap.get(mails.get(0));
            List<String> list = new ArrayList<>();
            list.add(name);
            list.addAll(mails);
            rest.add(list);
        }
        return rest;
    }

    class UnionUtil {
        private int[] parent;
        public UnionUtil(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i ++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    static class TestCase {
        public static List<List<String>> ACCOUNTS = fun("[[John, johnsmith@mail.com, john00@mail.com], [John, johnnybravo@mail.com], [John, johnsmith@mail.com, john_newyork@mail.com], [Mary, mary@mail.com]]");
        public static List<List<String>> ACCOUNTS1 = fun("[[Alex,Alex5@m.co,Alex4@m.co,Alex0@m.co],[Ethan,Ethan3@m.co,Ethan3@m.co,Ethan0@m.co],[Kevin,Kevin4@m.co,Kevin2@m.co,Kevin2@m.co],[Gabe,Gabe0@m.co,Gabe3@m.co,Gabe2@m.co],[Gabe,Gabe3@m.co,Gabe4@m.co,Gabe2@m.co]]");
        public static List<List<String>> ACCOUNTS2 = fun("[[David,David0@m.co,David1@m.co],[David,David3@m.co,David4@m.co],[David,David4@m.co,David5@m.co],[David,David2@m.co,David3@m.co],[David,David1@m.co,David2@m.co]]");

        private static List<List<String>> fun(String str) {
            List<List<String>> rest = new ArrayList<>();
            String TEMP = str.substring(1, str.length()-1);
            int left = 0, right = 0;
            while(left >= 0 && left <= right && right < TEMP.length()) {
                if(TEMP.charAt(left) == '[' && TEMP.charAt(right) == ']') {
                    List<String> list = new ArrayList<>();
                    String subStr = TEMP.substring(left+1, right);
                    String[] strs = subStr.split(",");
                    for(String tag : strs) {
                        list.add(tag.trim());
                    }
                    rest.add(list);
                    left = right + 1;
                    right = right + 1;
                } else if(TEMP.charAt(left) == '[') {
                    right ++;
                } else {
                    left ++;
                    right ++;
                }
            }
            return rest;
        }
    }
}
