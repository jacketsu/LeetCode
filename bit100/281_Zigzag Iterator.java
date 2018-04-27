// Given two 1d vectors, implement an iterator to return their elements alternately.

// For example, given two 1d vectors:

// v1 = [1, 2]
// v2 = [3, 4, 5, 6]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

// Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

// Clarification for the follow up question - Update (2015-09-18):
// The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

// [1,2,3]
// [4,5,6,7]
// [8,9]
// It should return [1,4,8,2,5,9,3,6,7].


public class ZigzagIterator {
    List<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        if (!v1.isEmpty()) list.add(v1.iterator());     // collections.. collection.iterator()
        if (!v2.isEmpty()) list.add(v2.iterator());     //in case of empty lists
    }

    public int next() {
        Iterator poll = list.remove(0);
        int result = (Integer)poll.next();              //iterator must be Integer initialized
        if (poll.hasNext()) {
            list.add(poll);
        }
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */