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
        // 0 > 1 > 2 > 3 4 > 5 > 6
        //               p   c
        //               t
        //           <   r
        // 1 > 2   3   4
        //             r
        //             p
        //
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

        // 0 > 1 > 2 > 3
        // c   t
        // 6 > 5 > 4
        // r   t

        // 0 > 6 > 1 > 2 > 3 > 5 > 4
        // c   r   t           t2
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
