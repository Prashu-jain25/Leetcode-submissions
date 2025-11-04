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
        return twoPass(head, n);
        //return onePass(head, n);
    }

    private ListNode onePass(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if(fast == null) {
            return head.next;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    private ListNode twoPass(ListNode head, int n) {
        ListNode curr = head;
        int size = 0;

        while(curr != null) {
            size++;
            curr = curr.next;
        }

        if(n == size) {
            return head.next;
        }

        curr = head;

        int steps = size - n;

        for(int i = 1; i < steps ; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;

    }
}