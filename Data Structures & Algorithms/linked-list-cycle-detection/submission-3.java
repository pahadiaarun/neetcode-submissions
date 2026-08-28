/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast.next == null || slow.next == null || fast.next.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
            System.out.println(fast.val + " " + slow.val);
        } while (fast != slow);

        return true;
    }
}
