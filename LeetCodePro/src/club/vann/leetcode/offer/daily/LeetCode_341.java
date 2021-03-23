package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：扁平化嵌套列表迭代器</p>
 * <p>描述：给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 * 通过次数18,358提交次数27,346
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-23:08:03:28
 */
public class LeetCode_341 {
    public static void main(String[] args) {

    }

    interface NestedInteger {
        /**
         *
         * @return true if this NestedInteger holds a single integer, rather than a nested list.
         */
        public boolean isInteger();

        /**
         *
         * @return the single integer that this NestedInteger holds, if it holds a single integer.
         * null if this NestedInteger holds a nested list.
         */
        public Integer getInteger();

        /**
         *
         * @return the nested list that this NestedInteger holds, if it holds a nested list.
         * null if this NestedInteger holds a single integer
         */
        public List<NestedInteger> getList();
    }

    class NestedIterator implements Iterator<Integer> {
        List<NestedInteger> nestedList;
        List<Integer> list;
        int index = -1;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
            this.list = helper(nestedList);
        }

        private List<Integer> helper(List<NestedInteger> nestedIntegerList) {
            List<Integer> data = new ArrayList<>();
            for(NestedInteger nestedInteger : nestedIntegerList) {
                if(nestedInteger.isInteger()) {
                    data.add(nestedInteger.getInteger());
                } else {
                    List<NestedInteger> child = nestedInteger.getList();
                    data.addAll(helper(child));
                }
            }
            return data;
        }

        @Override
        public Integer next() {
            if(this.list.size() > 0) {
                index ++;
                return this.list.get(index);
            }
            return -1;
        }

        @Override
        public boolean hasNext() {

            return this.index < this.list.size();
        }
    }
}
