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
    public ListNode mergeKLists(ListNode[] lists) {

    PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->  a.val-b.val);

    for(ListNode head:lists){
        if(head!=null){
        pq.add(head);
        }
    }
    ListNode head = new ListNode(-1);
    ListNode temp = head;

    while(!pq.isEmpty()){
        ListNode minNode = pq.poll();
         
         temp.next = minNode;
         temp = temp.next;

         if(minNode.next!=null){
            pq.add(minNode.next);
         }
    }
    return head.next;
  } 
    }