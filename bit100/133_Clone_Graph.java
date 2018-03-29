/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return clone(node, map);
    }
    
    public UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);
        for (UndirectedGraphNode nei : node.neighbors) {
            clone.neighbors.add(clone(nei, map));
        }
        return clone;
    }
}
