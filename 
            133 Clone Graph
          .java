/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private HashMap<UndirectedGraphNode,UndirectedGraphNode> nodeMap = new HashMap(); 
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        List<UndirectedGraphNode> neighborList= node.neighbors;
        nodeMap.put(node, newNode);
        for (UndirectedGraphNode neighbor : neighborList) {
            if (nodeMap.containsKey(neighbor)) {
                newNode.neighbors.add(nodeMap.get(neighbor));
            }
            else {
                UndirectedGraphNode newNeighbor = cloneGraph(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return newNode;
    }
}
