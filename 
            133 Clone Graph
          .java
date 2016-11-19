/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    private ArrayList<UndirectedGraphNode> arr = new ArrayList<UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        bfs(node);
        for (UndirectedGraphNode oldNode : arr) {
            List<UndirectedGraphNode> neighborList = oldNode.neighbors;
            for (UndirectedGraphNode neighbor : neighborList) {
                map.get(oldNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    private void bfs(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        arr.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            List<UndirectedGraphNode> nodes = head.neighbors;
            for (UndirectedGraphNode neighbor : nodes) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                    arr.add(neighbor);
                }
            }
        }
    }
    
}
