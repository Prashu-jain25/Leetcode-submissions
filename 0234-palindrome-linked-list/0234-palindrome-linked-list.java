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
    public boolean isPalindrome(ListNode head) {
        // return bruteForce(head);
        return optimal(head);
    }

    private boolean optimal(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        // finding mid
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reversing secondHalf of LL
        ListNode secondHalf = reverse(slow);

        ListNode firstHalf = head;
        ListNode temp = secondHalf;

        // Check for palindrome
        while(secondHalf != null) {
            if(secondHalf.val != firstHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        reverse(temp); // restoring list in it's original form

        return true;

    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    } 

    private boolean bruteForce(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;

        while(temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while(temp != null) {
            if(st.pop() != temp.val) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }
}