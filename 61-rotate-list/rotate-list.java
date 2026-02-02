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
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        //1.find the length of list
        int count = 1;
        ListNode curr = head;

        while (curr.next != null) {
            
            curr = curr.next;
            count++;
        }
 
        
        k=k%count;
        // 2. Make it circular
        curr.next = head;
         curr = head;
        int steps = count - k;
        while (steps-- > 1) {
            curr = curr.next;
        }

        //  Break circle
        ListNode newHead = curr.next;
        curr.next = null;

        return newHead;
    }
}