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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return splice(list1, list2);
    }

    private ListNode splice(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) return null;
        ListNode newNode;
        if (node1 == null) {
            newNode = new ListNode(node2.val);
            newNode.next = splice(node1, node2.next);
        } else if (node2 == null) {
            newNode = new ListNode(node1.val);
            newNode.next = splice(node1.next, node2);
        } else if (node1.val > node2.val) {
            newNode = new ListNode(node2.val);
            newNode.next = splice(node1, node2.next);
        } else {
            newNode = new ListNode(node1.val);
            newNode.next = splice(node1.next, node2);
        }
        return newNode;
    }
}