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
    public void reorderList(ListNode head) {
        int len = length(head);
        int toKeep = len - len / 2;
        ListNode reversed = null;
        ListNode curr = head;
        int i = 1;

        while (i < toKeep) {
            curr = curr.next;
            i ++;
        }

        reversed = curr.next;
        curr.next = null;

        curr = reversed;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        reversed = prev;

        curr = head;
        while (curr != null && reversed != null) {
            ListNode temp = curr.next;
            ListNode temp2 = reversed.next;
            curr.next = reversed;
            reversed.next = temp;
            curr = temp;
            reversed = temp2;
        }
    }

    private int length(ListNode curr) {
        if (curr == null)
            return 0;
        return 1 + length(curr.next);
    }
}
