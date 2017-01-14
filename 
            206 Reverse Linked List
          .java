/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null) {
            slow.next = fast.next;
            fast.next = newHead.next;
            newHead.next = fast;
            fast = slow.next;
        }
        return newHead.next;
    }
}
