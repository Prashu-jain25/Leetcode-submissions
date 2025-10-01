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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;
        ListNode firstHead = head;

        ListNode first = sortList(firstHead);
        ListNode second = sortList(secondHead);

        return merge(first, second);
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(first != null && second != null) {
            if(first.val <= second.val) {
                temp.next = first;
                first = first.next;
            }
            else{
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }

        if(first != null) {
            temp.next = first;
        }

        if(second != null) {
            temp.next = second;
        }

        return dummy.next;
    }
}