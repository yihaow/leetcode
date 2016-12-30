/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    private HashMap<RandomListNode,RandomListNode> nodeMap = new HashMap();
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(head.label);
        nodeMap.put(head, newHead);
        RandomListNode current = head;
        RandomListNode currentNew = newHead;
        while (current.next != null) {
            currentNew.next = new RandomListNode(current.next.label);
            nodeMap.put(current.next, currentNew.next);
            current = current.next;
            currentNew = currentNew.next;
        }
        currentNew.next = null;
        nodeMap.put(null, null);
        current = head;
        currentNew = newHead;
        while (current != null) {
            currentNew.random = nodeMap.get(current.random);
            current = current.next;
            currentNew = currentNew.next;
        }
        return newHead;
    }
}
