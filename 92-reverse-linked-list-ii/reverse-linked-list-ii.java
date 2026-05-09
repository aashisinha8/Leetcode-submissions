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
    public ListNode reverseBetween(ListNode head, int left, int right) {
       //edge case
       if (head == null || left == right) {
            return head;
        }
//consider dummy nodefor easypointing
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        ListNode prev=dummy;
        //move prev just before left
        for(int i=1;i<left;i++){
            prev=prev.next;

        }
        // reversal starts
        ListNode curr = prev.next;

        // reverse nodes
        for (int i = 0; i < right - left; i++) {
            ListNode temp=curr.next;
            curr.next=temp.next;
            temp.next=prev.next;
            prev.next=temp;
    }
    return dummy.next;
}
}
