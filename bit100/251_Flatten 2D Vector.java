// Implement an iterator to flatten a 2d vector.

// For example,
// Given 2d vector =

// [
//   [1,2],
//   [3],
//   [4,5,6]
// ]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

// Follow up:
// As an added challenge, try to code it using only iterators in C++ or iterators in Java.
// 
// 
// 

public class Vector2D implements Iterator<Integer> {
    private int rowIndex;
    private int elementIndex;
    private List<List<Integer>> list;
    public Vector2D(List<List<Integer>> vec2d) {
        this.list = vec2d;
        rowIndex = 0;
        elementIndex = 0;
    }

    @Override
    public Integer next() {
        return this.list.get(rowIndex).get(elementIndex++);                 //elementIndex++
    }

    @Override
    public boolean hasNext() {
        while (rowIndex < this.list.size()) {
            if (elementIndex < this.list.get(rowIndex).size()) {
                return true;
            } else {
                rowIndex++;
                elementIndex = 0;
            }
        }
        
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */