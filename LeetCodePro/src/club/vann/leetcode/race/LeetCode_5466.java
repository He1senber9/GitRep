package club.vann.leetcode.race;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/19
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5466 {
    public static void main(String[] args) {
        LeetCode_5466 leetCode = new LeetCode_5466();


    }

    private HashMap<Integer, Info> mem;
    private Integer[][] max;
    private String s;

    /**
     * 解法一：
     * @param s
     * @return
     */
    private List<String> maxNumOfSubstrings(String s) {
        mem = new HashMap<>();
        this.s = s;
        max = new Integer[26][2];
        for (int i = 0; i < s.length(); ++i) {
            if (max[s.charAt(i)  - 'a'][0] == null) {
                max[s.charAt(i)  - 'a'][0] = i;
            }
            max[s.charAt(i) - 'a'][1] = i;
        }
        return helper(0).list;
    }

    private void determine(int p) {
        if (p >= s.length()) {
            return;
        }
        int curMax = p, pos = p;
        while (pos <= curMax) {
            curMax = Math.max(max[s.charAt(pos) - 'a'][1], curMax);
            max[s.charAt(pos)][0] = p;
        }
        determine(pos);
    }

    private Info helper(int pos) {
        if (pos == s.length()) {
            return new Info(new ArrayList<>(), 0);
        } else if (!mem.containsKey(pos)) {
            int curMax = pos, curMin = pos, p = pos;
            while (p <= curMax) {
                if (curMin > max[s.charAt(p) - 'a'][0]) {
                    curMin = -1;
                    break;
                }
                curMax = Math.max(max[s.charAt(p++) - 'a'][1], curMax);
            }
            Info next = helper(pos + 1);

            if (curMin == -1) {
                mem.put(pos, next);
                return next;
            }

            Info jump = helper(curMax + 1);

            String cur = s.substring(pos, curMax + 1);
            List<String> tmp = new ArrayList<>();
            tmp.add(cur);
            for (String i : jump.list) {
                tmp.add(i);
            }

            Info cand = new Info(tmp, jump.count + cur.length());
            if (cand.list.size() != next.list.size()) {
                if (cand.list.size() > next.list.size()) {
                    mem.put(pos, cand);
                } else {
                    mem.put(pos, next);
                }
            } else if (cand.count >= next.count) {
                mem.put(pos, next);
            } else {
                mem.put(pos, cand);
            }
        }
        return mem.get(pos);
    }

    public List<String> maxNumOfSubstrings1(String s) {
        int charset = 'z' - 'a' + 1;
        int n = s.length();
        int[][] lr = new int[charset][2];
        for(int i = 0; i < charset; i++){
            for(int j = 0; j < 2; j++){
                lr[i][j] = -1;
            }
        }
        char[] chars = s.toCharArray();
        for(int i = 0; i < n; i++){
            chars[i] -= 'a';
        }
        for(int i = 0; i < n; i++){
            if(lr[chars[i]][0] == -1){
                lr[chars[i]][0] = i;
            }
            lr[chars[i]][1] = i;
        }
        // System.out.println(Arrays.deepToString(lr));
        Node1[] nodes = new Node1[charset];
        for(int i = 0; i < charset; i++){
            if(lr[i][0] == -1){
                continue;
            }
            nodes[i] = new Node1();
            nodes[i].l = lr[i][0];
            nodes[i].r = lr[i][1];
        }
        for(int i = 0; i < charset; i++){
            if(lr[i][0] == -1){
                continue;
            }
            Node1 node = nodes[i];
            int edge = 0;
            for(int j = lr[i][0]; j <= lr[i][1]; j++){
                int c = chars[j];
                edge |= 1 << c;
            }
            for(int j = 0; j < charset; j++){
                if(((edge >> j) & 1) == 1){
                    node.adj.add(nodes[j]);
                }
            }
        }

        for(Node1 node : nodes){
            if(node == null){
                continue;
            }
            tarjan(node);
        }

        List<String> ans = new ArrayList();
        for(Node1 node : nodes){
            if(node == null || node.set != node){
                continue;
            }
            boolean isLeaf = true;

            for(Node1 sub : node.inset){
                for(Node1 next : sub.adj){
                    if(next.set != sub.set){
                        isLeaf = false;
                    }
                }
            }

            if(isLeaf){
                ans.add(s.substring(node.l, node.r + 1));
            }
        }

        return ans;

    }

    int order = 0;
    Deque<Node1> dq = new ArrayDeque();
    public void tarjan(Node1 root){
        if(root.dfn > 0){
            return;
        }
        root.dfn = root.low = ++order;
        dq.addLast(root);
        root.instk = true;

        for(Node1 node : root.adj){
            tarjan(node);
            if(node.instk){
                root.low = Math.min(root.low, node.low);
            }
        }

        if(root.low == root.dfn){
            while(true){
                Node1 tail = dq.removeLast();
                tail.instk = false;
                tail.set = root;
                root.inset.add(tail);
                root.l = Math.min(root.l, tail.l);
                root.r = Math.max(root.r, tail.r);
                if(tail == root){
                    break;
                }
            }
        }
    }

    static class TestCase {
        public static String STR = "adefaddaccc";
    }
}

class Info {
    public List<String> list;
    public int count;

    Info(List<String> list, int count) {
        this.list = list;
        this.count = count;
    }
}

class Node1{
    int l;
    int r;
    Node1 set;
    int dfn;
    int low;
    boolean instk;
    List<Node1> inset = new ArrayList<>();
    List<Node1> adj = new ArrayList<>();
}
