package club.vann.leetcode.common;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/22
 * Time: 17:51
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
