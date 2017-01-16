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
        HashMap<RandomListNode, RandomListNode> map = new HashMap();
        if (head == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        map.put(null, null);
        RandomListNode cur = head;
        RandomListNode newCur = newHead;
        while(cur.next != null) {
            newCur.next = new RandomListNode(cur.next.label);
            newCur = newCur.next;
            cur = cur.next;
            map.put(cur,newCur);
        }
        cur = head;
        newCur = newHead;
        while(cur != null) {
            newCur.random = map.get(cur.random);
            newCur = newCur.next;
            cur = cur.next;
        }
        return newHead;
    }
}
