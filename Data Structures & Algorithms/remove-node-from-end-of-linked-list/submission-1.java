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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        do {
            if (fast.next == null) {
                len++;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
            len += 2;
        } while (fast != null);

        ListNode prev = null;
        slow = head;

        for (int i = 0; i < len - n; i++) {
            prev = slow;
            slow = slow.next;
        }

        if (slow.next == null) {
            prev.next = null;
        } else if (prev == null) {
            head = head.next;
        } else {
            prev.next = slow.next;
        }

        return head;
    }
}
