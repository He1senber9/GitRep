package club.vann.leetcode.offer.daily;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.*;

/**
 * <p>难度：Medium</p>
 * <p>题目：除法求值</p>
 * <p>描述：给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 *
 *  
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 示例 2：
 *
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 *
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 *  
 *
 * 提示：
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 * 通过次数15,256提交次数27,477
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_399
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/6 8:54
 */
public class LeetCode_399 {
    public static void main(String[] args) {
        LeetCode_399 leetCode = new LeetCode_399();

//        System.out.println("Result:"+Arrays.toString(TestCase.ANS)+" : " + Arrays.toString(leetCode.calcEquation(TestCase.EQUATIONS, TestCase.VALUES, TestCase.QUERIES)));
//        System.out.println("Result:"+Arrays.toString(TestCase.ANS1)+" : " + Arrays.toString(leetCode.calcEquation(TestCase.EQUATIONS1, TestCase.VALUES1, TestCase.QUERIES1)));
//        System.out.println("Result:"+Arrays.toString(TestCase.ANS2)+" : " + Arrays.toString(leetCode.calcEquation(TestCase.EQUATIONS2, TestCase.VALUES2, TestCase.QUERIES2)));
        System.out.println("Result:"+Arrays.toString(TestCase.ANS3)+" : " + Arrays.toString(leetCode.calcEquation(TestCase.EQUATIONS3, TestCase.VALUES3, TestCase.QUERIES3)));
    }

    /**
     * 解法一：
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equations_size = equations.size();
        int queries_size = queries.size();
        double[] resArray = new double[queries_size];

        // 找出所有点与其他点直接相连的关系，在找的同时给每个节点设置默认索引
        int point_count = 0;
        Map<String, Integer> pathMap = new HashMap<>();
        for(int i = 0; i < equations_size; i ++) {
            List<String> path = equations.get(i);
            String a = path.get(0);
            String b = path.get(1);

            if(!pathMap.containsKey(a)) {
                pathMap.put(a, point_count ++);
            }

            if(!pathMap.containsKey(b)) {
                pathMap.put(b, point_count ++);
            }
        }

        // 对于每个点，直接存储与其直接相连的点的关系。 deges的索引对应上面给每个节点分配的索引，Map中k是对应终点，v是他们之间的比值。
        Map<String, Double>[] pointMap = new Map[point_count];
        for(int i = 0; i < point_count; i ++) {
            pointMap[i] = new HashMap<String, Double>();
        }
        for(int i = 0; i < equations_size; i ++) {
            List<String> path = equations.get(i);
            String a = path.get(0);
            String b = path.get(1);

            int a_index = pathMap.get(a);
            int b_index = pathMap.get(b);

            pointMap[a_index].put(b, values[i]);
            pointMap[b_index].put(a, 1.0/values[i]);
        }

        for(int i = 0; i < queries_size; i ++) {
            List<String> path = queries.get(i);
            String a = path.get(0);
            String b = path.get(1);

            double res = -1.0;
            if(pathMap.containsKey(a) && pathMap.containsKey(b)) {
                // 如果两个字符相等
                if(a.equals(b)) {
                    res = 1.0;
                } else {
                    int a_index = pathMap.get(a);
                    int b_index = pathMap.get(b);

                    Queue<Integer> points = new LinkedList<Integer>();
                    points.offer(a_index);
                    double[] ratios = new double[point_count];
                    Arrays.fill(ratios, -1.0);
                    ratios[a_index] = 1.0;

                    while (!points.isEmpty() && ratios[b_index] < 0) {
                        int x = points.poll();
                        Map<String, Double> pair = pointMap[x];
                        for(String k : pair.keySet()) {
                            int y = pathMap.get(k);
                            double val = pair.get(k);

                            if(ratios[y] < 0) {
                                ratios[y] = ratios[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    res = ratios[b_index];
                }
            }
            resArray[i] = res;
        }

        return resArray;
    }

    /**
     * 解法二：
     * 并查集
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;

        return null;
    }

    private void join(int[] parent, int x, int y) {

    }

    private int find(int[] parent, int index) {
        return 0;
    }

    static class TestCase {
//        public static double[] ANS = {6.00000,0.50000,-1.00000,1.00000,-1.00000};
//        public static List<List<String>> EQUATIONS = asList("[[a,b],[b,c]]");
//        public static double[] VALUES = {2.0,3.0};
//        public static List<List<String>> QUERIES = asList("[[a,c],[b,a],[a,e],[a,a],[x,x]]");
//
//        public static double[] ANS1 = {3.75000,0.40000,5.00000,0.20000};
//        public static List<List<String>> EQUATIONS1 = asList("[[a,b],[b,c],[bc,cd]]");
//        public static double[] VALUES1 = {1.5,2.5,5.0};
//        public static List<List<String>> QUERIES1 = asList("[[a,c],[c,b],[bc,cd],[cd,bc]]");
//
//        public static double[] ANS2 = {0.50000,2.00000,-1.00000,-1.00000};
//        public static List<List<String>> EQUATIONS2 = asList("[[a,b]]");
//        public static double[] VALUES2 = {0.5};
//        public static List<List<String>> QUERIES2 = asList("[[a,b],[b,a],[a,c],[x,y]]");

        public static double[] ANS3 = {2.00000,3.00000,-1.00000,-1.00000,-1.00000,-1.00000};
        public static List<List<String>> EQUATIONS3 = asList("[[a,b],[c,d]]");
        public static double[] VALUES3 = {2.0,3.0};
        public static List<List<String>> QUERIES3 = asList("[[a,b],[c,d],[a,c],[a,d],[b,c],[b,d]]");
    }

    static List<List<String>> asList(String params) {
        List<List<String>> resList = new ArrayList<>();
        if(params == null || params.length() == 0) {
            return resList;
        }

        String tagStr = params.substring(1, params.length()-1);

        int left = 0, right = 0;
        while(left <= right && right < tagStr.length()) {
            if(tagStr.charAt(left) == '[' && tagStr.charAt(right) == ']') {
                List<String> list = new ArrayList<>();
                String temp = tagStr.substring(left+1, right);
                String[] pair = temp.split(",");
                list.add(pair[0].trim());
                list.add(pair[1].trim());
                resList.add(list);

                left = right + 1;
                right = right + 1;
            } else if(tagStr.charAt(left) == '[' && tagStr.charAt(right) != ']'){
                right ++;
            } else {
                left ++;
                right ++;
            }
        }

        return resList;
    }
}
