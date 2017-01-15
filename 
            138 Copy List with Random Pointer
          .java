/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode point = head;
        RandomListNode newPoint = newHead;
        while (point != null) {
             if (point.next == null) {
                 newPoint.next = null;
                 map.put(null, null);
                 break;
             }
             newPoint.next = new RandomListNode(point.next.label);
             point = point.next;
             newPoint = newPoint.next;
             map.put(point, newPoint);
        }
        point = head;
        newPoint = newHead;
        while(point != null) {
            newPoint.random = map.get(point.random);
            point = point.next;
            newPoint = newPoint.next;
        }
        return newHead;
    }
}
