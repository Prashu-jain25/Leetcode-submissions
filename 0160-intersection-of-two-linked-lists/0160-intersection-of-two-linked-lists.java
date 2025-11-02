/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //return brute(headA, headB);
        return better(headA, headB);
    }

    private ListNode better(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> mpp = new HashMap<>();

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        // putting all nodes of 1st LL in mpp
        while(temp1 != null) {
            mpp.put(temp1, 1);
            temp1 = temp1.next;
        }

        // checking is it already in mpp = Common node
        while(temp2 != null) {
            if(mpp.containsKey(temp2)) {
                return temp2;
            }

            temp2 = temp2.next;
        }

        return null;

    }

    private ListNode brute(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        // picking node from 1st LL 
        while(temp1 != null) {
            // checking in 2nd LL do we have any common node
            while(temp2 != null) {
                // if yes this is the resultant node
                if(temp1 == temp2) {
                    return temp1;
                }
                else{
                    // search in the entire 2nd LL
                    temp2 = temp2.next;
                }
            }
            // if not found
            temp2 = headB; // setting 2nd head to it's initial position
            temp1 = temp1.next; // looking for next node in 1st LL
        }

        return null; // no intersection point
    }
}