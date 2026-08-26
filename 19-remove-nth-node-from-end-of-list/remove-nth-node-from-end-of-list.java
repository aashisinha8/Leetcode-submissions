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
        if(head==null) return null;

        int k=0;
        ListNode curr=head;
        while(curr.next!=null){
            k++;
            curr=curr.next;
        }
        if(k-n+1==0) return head.next;
        ListNode temp=head;
        for(int i=0;i<k-n;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}