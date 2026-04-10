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
        // Edge case: if list is empty or has only one node, no rotation needed
        if(head == null) return null;

        // Step 1: Find length of linked list and last node
        int n = 1;      // initialize length as 1 (head already counted)
        ListNode last = head;  // start from head

        // Traverse till last node
        while(last.next != null){
            n++;
            last = last.next;  // move to next node
        }

        // Step 2: Handle cases where k > n
        k = k%n;   // effective rotations (avoid unnecessary full rotations)

        // If k becomes 0 → list remains same
        if(k == 0) return head;

        // Step 3: Find the breaking point (new tail)
        // New tail will be at position (n - k)
        int c = n-k;
        int count = 1;
        ListNode t = head;

        // Move t to (n-k)th node
        while(t != null){
            if(count == c) break;
            count++;
            t = t.next;
        }

        // Step 4: Perform rotation
        last.next = head;   // connect last node to head → makes it circular
        ListNode res = t.next;  // new head will be next of new tail
        t.next = null;  // break the list to remove circular link

        return res;
    }
}
