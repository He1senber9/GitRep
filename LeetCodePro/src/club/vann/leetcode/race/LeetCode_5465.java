package club.vann.leetcode.race;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <p>难度：Meidum</p>
 * <p>题目：子树中标签相同的节点数</p>
 * <p>描述：给你一棵树（即，一个连通的无环无向图），这棵树由编号从 0  到 n - 1 的 n 个节点组成，且恰好有 n - 1 条 edges 。树的根节点为节点 0 ，树上的每一个节点都有一个标签，也就是字符串 labels 中的一个小写字符（编号为 i 的 节点的标签就是 labels[i] ）
 *
 * 边数组 edges 以 edges[i] = [ai, bi] 的形式给出，该格式表示节点 ai 和 bi 之间存在一条边。
 *
 * 返回一个大小为 n 的数组，其中 ans[i] 表示第 i 个节点的子树中与节点 i 标签相同的节点数。
 *
 * 树 T 中的子树是由 T 中的某个节点及其所有后代节点组成的树。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
 * 输出：[2,1,1,1,1,1,1]
 * 解释：节点 0 的标签为 'a' ，以 'a' 为根节点的子树中，节点 2 的标签也是 'a' ，因此答案为 2 。注意树中的每个节点都是这棵子树的一部分。
 * 节点 1 的标签为 'b' ，节点 1 的子树包含节点 1、4 和 5，但是节点 4、5 的标签与节点 1 不同，故而答案为 1（即，该节点本身）。
 * 示例 2：
 *
 *
 *
 * 输入：n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb"
 * 输出：[4,2,1,1]
 * 解释：节点 2 的子树中只有节点 2 ，所以答案为 1 。
 * 节点 3 的子树中只有节点 3 ，所以答案为 1 。
 * 节点 1 的子树中包含节点 1 和 2 ，标签都是 'b' ，因此答案为 2 。
 * 节点 0 的子树中包含节点 0、1、2 和 3，标签都是 'b'，因此答案为 4 。
 * 示例 3：
 *
 *
 *
 * 输入：n = 5, edges = [[0,1],[0,2],[1,3],[0,4]], labels = "aabab"
 * 输出：[3,2,1,1,1]
 * 示例 4：
 *
 * 输入：n = 6, edges = [[0,1],[0,2],[1,3],[3,4],[4,5]], labels = "cbabaa"
 * 输出：[1,2,1,1,2,1]
 * 示例 5：
 *
 * 输入：n = 7, edges = [[0,1],[1,2],[2,3],[3,4],[4,5],[5,6]], labels = "aaabaaa"
 * 输出：[6,5,4,1,3,2,1]
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * labels.length == n
 * labels 仅由小写英文字母组成</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/19
 * Time: 10:46
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5465 {
    public static void main(String[] args) {
        LeetCode_5465 leetCode = new LeetCode_5465();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.countSubTrees(TestCase.N, TestCase.EDGES, TestCase.STR)));
        System.out.println("Result["+Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.countSubTrees(TestCase.N1, TestCase.EDGES1, TestCase.STR1)));
        System.out.println("Result["+Arrays.toString(TestCase.ANS2)+"] : " + Arrays.toString(leetCode.countSubTrees(TestCase.N2, TestCase.EDGES2, TestCase.STR2)));
        System.out.println("Result["+Arrays.toString(TestCase.ANS3)+"] : " + Arrays.toString(leetCode.countSubTrees(TestCase.N3, TestCase.EDGES3, TestCase.STR3)));
        System.out.println("Result["+Arrays.toString(TestCase.ANS4)+"] : " + Arrays.toString(leetCode.countSubTrees(TestCase.N4, TestCase.EDGES4, TestCase.STR4)));
    }

    private String labels;
    private HashMap<Integer, List<Integer>> connect;
    private int[] res;
    /**
     *
     * 解法一：
     * dp[i][j] 为 i节点的子树中字母 j的个数
     * @param n
     * @param edges
     * @param labels
     * @return
     */
    private int[] countSubTrees(int n, int[][] edges, String labels) {
        this.connect = new HashMap<>();
        this.labels = labels;
        this.res = new int[n];

        for (int[] e : edges) {
            if (!connect.containsKey(e[0])) {
                connect.put(e[0], new ArrayList<>());
            }

            connect.get(e[0]).add(e[1]);

            if (!connect.containsKey(e[1])) {
                connect.put(e[1], new ArrayList<>());
            }

            connect.get(e[1]).add(e[0]);
        }

        DFS(0, -1);
        return res;
    }

    private int[] DFS(int cur, int last) {
        int[] mem = new int[26];
        mem[labels.charAt(cur) - 'a'] = 1;
        for (int i : connect.getOrDefault(cur, new ArrayList<>())) {
            if (i != last) {
                int p = 0;
                for (int j : DFS(i, cur)) {
                    mem[p++] += j;
                }
            }
        }
        res[cur] = mem[labels.charAt(cur) - 'a'];
        return mem;
    }

    public int[] countSubTrees1(int n, int[][] edges, String labels) {
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node();
            nodes[i].c = labels.charAt(i) - 'a';
        }
        for(int[] e : edges){
            Node a = nodes[e[0]];
            Node b = nodes[e[1]];
            a.adj.add(b);
            b.adj.add(a);
        }
        dfs(nodes[0], null);
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = nodes[i].dp[nodes[i].c];
        }
        return ans;
    }

    public void dfs(Node root, Node p){
        root.dp[root.c]++;
        for(Node node : root.adj){
            if(node == p){
                continue;
            }
            dfs(node, root);
            for(int i = 0; i <= 'z' - 'a'; i++){
                root.dp[i] += node.dp[i];
            }
        }
    }



    static class TestCase {
        public static int[] ANS = {2,1,1,1,1,1,1};
        public static int N = 7;
        public static int[][] EDGES = {{0, 1},{0, 2},{1, 4},{1, 5},{2, 3},{2, 6}};
        public static String STR = "abaedcd";

        public static int[] ANS1 = {4,2,1,1};
        public static int N1 = 4;
        public static int[][] EDGES1 = {{0, 1}, {1, 2}, {0, 3}};
        public static String STR1 = "bbbb";

        public static int[] ANS2 = {3,2,1,1,1};
        public static int N2 = 5;
        public static int[][] EDGES2 = {{0, 1}, {0, 2}, {1, 3}, {0, 4}};
        public static String STR2 = "aabab";

        public static int[] ANS3 = {1,2,1,1,2,1};
        public static int N3 = 6;
        public static int[][] EDGES3 = {{0, 1}, {0, 2}, {1, 3}, {3, 4}, {4, 5}};
        public static String STR3 = "cbabaa";

        public static int[] ANS4 = {6,5,4,1,3,2,1};
        public static int N4 = 7;
        public static int[][] EDGES4 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}};
        public static String STR4 = "aaabaaa";
    }
}

class Node{
    List<Node> adj = new ArrayList<>();
    int c;
    int[] dp = new int['z' - 'a' + 1];
}
