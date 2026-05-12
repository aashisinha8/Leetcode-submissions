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
       
        ListNode curr=head;
        int n=0;
        while(curr!=null){
            curr=curr.next;
            n++;
        }
        ListNode first=head;

        for(int i=1;i<k;i++){
            first=first.next;
        }
        
        ListNode second=head;
        for(int i=1;i<(n-k+1);i++){
            second=second.next;

        }
        //now we have to swap first value and second value
        int temp=first.val;
        first.val=second.val;
        second.val=temp;

        return head;

        
    }
}