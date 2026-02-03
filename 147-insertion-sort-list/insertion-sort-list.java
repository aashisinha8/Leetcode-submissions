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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy=new ListNode(0);
        ListNode A=head;
        while(A!=null){
            ListNode next=A.next;//save next
            ListNode prev=dummy;
            while (prev.next != null && prev.next.val < A.val) {
                prev = prev.next;
            }

            // insert curr between prev and prev.next
            A.next = prev.next;
            prev.next = A;

            A = next;
            }
        
        return dummy.next;
    }
}