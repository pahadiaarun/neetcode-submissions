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
    public ListNode mergeTwoSortedLL(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1, null);
        ListNode r = temp;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                r.next = l1;
                l1 = l1.next;
            } else {
                r.next = l2;
                l2 = l2.next;
            }
            r = r.next;
        }
        if (l1 != null) {
            r.next = l1;
        }
        if (l2 != null) {
            r.next = l2;
        }
        return temp.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        for (int i = 1; i < lists.length; i++) {
            ListNode head = lists[0];
            if (head != null && lists[i] != null) {
                head = mergeTwoSortedLL((lists[0].val <= lists[i].val) ? lists[0] : lists[i],
                    (lists[0].val > lists[i].val) ? lists[0] : lists[i]);
                lists[0] = head;
            } else if (lists[i] != null) {
                lists[0] = lists[i];
            }
        }
        return lists[0];
    }
}
