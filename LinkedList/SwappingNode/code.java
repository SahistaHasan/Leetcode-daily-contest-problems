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
    public ListNode swapNodes(ListNode head, int k) {
         if (head == null) return head;

        ListNode p1 = null;
        for (int i = 1; i <= k - 1; i++) {
            if (i == 1) p1 = head;
            else p1 = p1.next;
        }

        ListNode len = head;
        int count = 0;
        while (len != null) {
            len = len.next;
            count++;
        }

        // invalid or same node case
        if (k > count || 2 * k - 1 == count) return head;

        ListNode p2 = null;
        for (int i = 1; i <= count - k; i++) {
            if (i == 1) p2 = head;
            else p2 = p2.next;
        }

        // handle cases when kth node is head or tail
        ListNode temp1 = (p1 == null) ? head : p1.next;
        ListNode temp2 = (p2 == null) ? head : p2.next;

        // swap links
        if (p1 != null) p1.next = temp2;
        else head = temp2;

        if (p2 != null) p2.next = temp1;
        else head = temp1;

        ListNode temp3 = temp1.next;
        temp1.next = temp2.next;
        temp2.next = temp3;

        return head;
    }
}
