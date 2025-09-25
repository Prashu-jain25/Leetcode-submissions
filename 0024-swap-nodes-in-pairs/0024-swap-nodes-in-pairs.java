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
    public ListNode swapPairs(ListNode head) {
        // return swapData(head);
        return swapNodes(head);
    }

    private ListNode swapNodes(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
        }

        return dummy.next;
    }


    private ListNode swapData(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;

        while(curr != null && curr.next != null) {
            int temp = curr.val; // copy curr data in a variable
            curr.val = curr.next.val; // putting next's data in curr
            curr.next.val = temp; // putting temp into next node's data
            curr = curr.next.next;// moving curr twice
        }

        return head;
    }
}