class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int len = heights.length;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {                //empty case
                stack.push(i);
            } else {
                int pop = stack.pop();
                maxArea = Math.max(maxArea, heights[pop] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;                            //logic!
            }
        }
        
        return maxArea;
    }
}
