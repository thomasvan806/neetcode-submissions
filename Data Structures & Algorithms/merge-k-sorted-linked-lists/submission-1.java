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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ListNode node : lists) {
            ListNode curr = node;
            while (curr != null) {
                pq.add(curr.val);
                curr = curr.next;
            }
        }

        ListNode result = null;
        ListNode currNode = result;
        while (!pq.isEmpty()) {
            int curr = pq.remove();
            if (result == null) {
                result = new ListNode(curr);
                currNode = result;
            } else {
                currNode.next = new ListNode(curr);
                currNode = currNode.next;
            }
        }
        
        return result;
    }
}
