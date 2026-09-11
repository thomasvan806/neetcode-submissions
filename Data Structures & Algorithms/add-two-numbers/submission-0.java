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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;
        boolean carry = false;
        int sum = l1.val + l2.val;
        ListNode result;
        if (sum >= 10) {
            carry = true;
            result = new ListNode(sum - 10);
        } else {
            result = new ListNode(sum);
        }

        ListNode curr = result;
        l1Curr = l1Curr.next;
        l2Curr = l2Curr.next;

        while ((l1Curr != null || l2Curr != null) || carry) {
            sum = 0;
            if (l1Curr != null) {
                sum += l1Curr.val;
                l1Curr = l1Curr.next;
            }
            if (l2Curr != null) {
                sum += l2Curr.val;
                l2Curr = l2Curr.next;
            }
            if (carry) sum ++;
            if (sum >= 10) {
                carry = true;
                curr.next = new ListNode(sum - 10);
            } else {
                carry = false;
                curr.next = new ListNode(sum);
            }
            curr = curr.next;
        }

        return result;
    }
}
