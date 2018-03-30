class Solution {
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> s = new Stack<>();
        if (tokens == null || tokens.length == 0) return 0;
        for (String str : tokens) {
            if ("+".equals(str)) {
                s.push(s.pop() + s.pop());
            } else if ("-".equals(str)) {
                a = s.pop();
                b = s.pop();
                s.push(b - a);
            } else if ("*".equals(str)) {
                s.push(s.pop() * s.pop());
            } else if ("/".equals(str)) {
                a = s.pop();
                b = s.pop();
                s.push(b / a);
            } else {
                s.push(Integer.parseInt(str));
            }
        }
        
        return s.pop();
    }
}
