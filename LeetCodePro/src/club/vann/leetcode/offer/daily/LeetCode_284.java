package club.vann.leetcode.offer.daily;

import java.util.Iterator;

/**
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-10-05  09:17:23
 */
public class LeetCode_284 {
    public static void main(String[] args) {
//        PeekingIterator peekingIterator = new PeekingIterator(TestCase.NUMS);
    }

    static class TestCase {
        public static int[] NUMS = {1,2,3};
    }

    static class IteratorArray {

    }
}

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> data;
    private Integer nextValue;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        data = iterator;
        nextValue = data.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ret = nextValue;
        nextValue = data.hasNext() ? data.next() : null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return nextValue != null;
    }
}


