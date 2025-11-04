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
    public ListNode oddEvenList(ListNode head) {
        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        ListNode evenCurr = even;
        ListNode oddCurr = odd;

        ListNode temp = head;
        int cnt = 1;

        while(temp != null) {
            if(cnt % 2 != 0) {
                oddCurr.next = temp;
                oddCurr = oddCurr.next;
            }
            else{
                evenCurr.next = temp;
                evenCurr = evenCurr.next;
            }

            cnt++;
            temp = temp.next;
        }

        evenCurr.next = null;
        oddCurr.next = even.next;

        return odd.next;

    }
}