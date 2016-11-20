/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node,newNode);
        List<UndirectedGraphNode> arr = node.neighbors;
        for (UndirectedGraphNode neighbor : arr) {
            if (map.containsKey(neighbor)) {
                newNode.neighbors.add(map.get(neighbor));
            }
            else {
                UndirectedGraphNode newNeighbor = cloneGraph(neighbor);
                newNode.neighbors.add(newNeighbor);
                map.put(neighbor,newNeighbor);
            }
        }
        return newNode;
    }
}
