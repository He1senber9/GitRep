package club.vann.leetcode.race;

import java.util.PriorityQueue;

/**
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-12-27 11:45
 **/
public class LeetCode_5638 {
    public static void main(String[] args) {
        LeetCode_5638 leetCode = new LeetCode_5638();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.eatenApples(TestCase.APPLES, TestCase.DAYS));
    }

    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;

        // 借助优先队列控制优先食用的苹果或者腐烂的苹果
        PriorityListNode listNode = new PriorityListNode();

        int sum = 0; // 总计食用的苹果
        int res = 0;

        int i = 1;
        while(i <= n || res > 0) {
            int newApples = apples[i-1];
            if(!listNode.isEmpty()) {
                PriorityListNode.Node node = listNode.peek();
                if(node.k == i) {
                    res -= node.v;
                    res = res >= node.v ? res - node.v : 0;
                    listNode.poll();
                }
            }

            res += newApples-1;
            if(res > 0) {
                sum += 1;
            }
            listNode.push(days[i-1], apples[i-1]);
            i ++;
        }

        return sum;
    }

    class PriorityListNode {
        Node head;
        Node tail;

        PriorityListNode() {
            head = new Node(0,0);
            tail = head.next;
        }

        void push(int k, int v) {
            Node node = new Node(k, v);
            if(tail == null) {
                head.next = node;
                tail = node;
            } else {
                Node temp = head.next;
                while(temp != null) {
                    if(temp.k < k) {
                        head.next = node;
                        node.next = temp;
                        break;
                    } else if(temp.k == k) {
                        temp.v += v;
                        break;
                    } else {
                        temp = temp.next;
                    }
                }
            }
        }

        boolean isEmpty() {
            return tail == null;
        }

        Node peek() {
            if(tail == null) {
                return null;
            }

            return head.next;
        }

        Node poll() {
            if(tail == null) {
                return null;
            }

            Node node = head.next;
            head.next = node.next;
            if(head.next == null) {
                tail = null;
            }
            return node;
        }

        class Node {
            int k;
            int v;
            Node next;
            Node(int k, int v) {
                this.k = k;
                this.v = v;
            }
        }

    }



    static class TestCase {
        public static int ANS = 7;
        public static int[] APPLES = {1,2,3,5,2};
        public static int[] DAYS = {3,2,1,4,2};
    }
}
