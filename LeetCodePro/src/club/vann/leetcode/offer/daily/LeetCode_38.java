package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-22  08:56:49
 */
public class LeetCode_38 {
    public static void main(String[] args) {
        LeetCode_38 leetCode = new LeetCode_38();

        System.out.println("Result"+ Arrays.toString(TestCase.ANS)+" : " + Arrays.toString(leetCode.permutation(TestCase.S)));
    }

    /**
     * 解法一：
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        int n = s.length();
        List<String> rec = new ArrayList<String>();
        boolean[] vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        dfs(rec, vis, arr, 0, n, perm);
        int size = rec.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i);
        }
        return recArr;
    }

    private void dfs(List<String> rec, boolean[] vis, char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            dfs(rec, vis, arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }

    static class TestCase {
        public static String[] ANS = {"abc","acb","bac","bca","cab","cba"};
        public static String S = "abc";
    }
}
