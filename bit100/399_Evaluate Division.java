// Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

// Example:
// Given a / b = 2.0, b / c = 3.0. 
// queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
// return [6.0, 0.5, -1.0, 1.0, -1.0 ].

// The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

// According to the example above:

// equations = [ ["a", "b"], ["b", "c"] ],
// values = [2.0, 3.0],
// queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
// The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.


class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<GraphNode>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!map.containsKey(equation[0])) {
                map.put(equation[0], new ArrayList<>());
            }
            map.get(equation[0]).add(new GraphNode(equation[1], values[i]));
            if (!map.containsKey(equation[1])) {
                map.put(equation[1], new ArrayList<>());
            }
            map.get(equation[1]).add(new GraphNode(equation[0], 1 / values[i]));
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            res[i] = find(map, query[0], query[1], 1.0, new HashSet<>());           //new hashset every query
        }
        return res;
    }
    
    public double find(Map<String, List<GraphNode>> map, String start, String end, double value, Set<String> set) {
        if (set.contains(start) || !map.containsKey(start)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return value;
        }
        set.add(start);
        for (GraphNode node : map.get(start)) {
            double sub = find(map, node.den, end, node.val * value, set);
            if (sub != -1.0) {
                return sub;
            }
        }
        set.remove(start);
        return -1.0;
    }
    
    class GraphNode {
        String den;
        double val;
        public GraphNode(String den, double val) {
            this.den = den;
            this.val = val;
        }
    }
}