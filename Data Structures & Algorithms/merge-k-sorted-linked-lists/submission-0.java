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
        Map<Integer, ListNode> indices = new HashMap<>();
        ListNode result = null;

        for (int i = 0; i < lists.length; i ++) {
            indices.put(i, lists[i]);
        }

        boolean allNull = false;
        ListNode curr = result;
        while (!allNull) {
            int smallest = Integer.MAX_VALUE;
            int smallestIndex = 0;
            allNull = true;
            for (int i = 0; i < lists.length; i ++) {
                if (lists[i] != null) {
                    allNull = false;
                    if (lists[i].val < smallest) {
                        smallest = lists[i].val;
                        smallestIndex = i;
                    }
                }
            }
            if (!allNull) {
                if (result == null) {
                    result = new ListNode(smallest);
                    curr = result;
                } else {
                    curr.next = new ListNode(smallest);
                    curr = curr.next;
                }
                lists[smallestIndex] = lists[smallestIndex].next;
            }
        }

        return result;
    }
}
