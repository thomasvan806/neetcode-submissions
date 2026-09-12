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
        if (head.next == null) return null;
        // edgecases: sz = 1,
        // possible edgecases
        // sz = 1, 2, 3
        // sz = 2k
        // sz = 2k + 1
        // 1, 2, 3, 4, n
        //       s     f
        // 4
        // 1, 2, 3, 4, 5, n
        //       s     f
        // 6
        // - 1
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            i++;
        }

        int length = i * 2;
        if (fast != null)
            length++;
        int maxIndex = length - 1;
        int removeAt = maxIndex - n;
        System.out.println(maxIndex);
        System.out.println(removeAt);
        System.out.println(i);

        if (removeAt == -1) return head.next;

        // len = 4
        // n = 2
        // target = previous that to be removed
        // maxIndex = len - 1 (3)
        // removeAt = maxIndex - n (1)
        if (i < removeAt) {
            while (i < removeAt) {
                slow = slow.next;
                i++;
            }

            slow.next = slow.next.next;
        } else if (i == removeAt) {
            slow.next = slow.next.next;
        } else {
            i = 0;
            slow = head;
            while (i < removeAt) {
                slow = slow.next;
                i++;
            }

            slow.next = slow.next.next;
        }

        return head;
    }
}
