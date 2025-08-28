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
    public ListNode swapNodes(ListNode head, int k) {

        int n = length(head);
        ListNode temp1 = head;
        ListNode temp2 = head;

        // placing first pointer
        for(int i = 1; i < k; i++) {
            temp1 = temp1.next;
        }

        // placing second pointer
        for(int i = 1; i < n - k + 1; i++) {
            temp2 = temp2.next;
        }

        int value = temp1.val;
        temp1.val = temp2.val;
        temp2.val = value;

        return head;
    }

    private int length(ListNode head) {
        if(head == null) {
            return 0;
        }

        int cnt = 0;

        while(head != null) {
            head = head.next;
            cnt++;
        }

        return cnt;
    }
}