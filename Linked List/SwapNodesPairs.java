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

    // Ye function given number of nodes (times) ko reverse karta hai
    // Important: ye function kuch return nahi karta
    // Kyunki hum assume kar rahe hain ki reversal ke baad
    // new head = originally right node hoga (jo bahar use ho raha hai)
    void reverse(ListNode head, int times){
        ListNode curr = head;   // current node jisko reverse karna hai
        ListNode prev = null;   // reversed list ka head

        for(int i = 0; i < times; i++){
            ListNode next = curr.next; // next node store karo (connection lose na ho)
            curr.next = prev;          // pointer reverse karo
            prev = curr;               // prev ko aage badhao
            curr = next;               // curr ko aage badhao
        }

        // Note:
        // reversal ke baad:
        // prev = new head of reversed part
        // curr = next part ka start
        return;
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;  // empty list case

        ListNode left = head;      // har pair ka starting node
        ListNode prevleft = null;  // previous pair ka last node (connection ke liye)
        ListNode right = null;     // pair ka second node
        ListNode res = null;       // final answer ka head
        int size = 2;              // pair size (2 nodes)

        // jab tak list me nodes bache hain
        while(left != null){

            right = left;

            // right ko left ke next node pe le jao (pair complete karne ke liye)
            for(int i = 0; i < size-1; i++){
                if(right == null){
                    break;
                }
                right = right.next;
            }

            // Agar pair complete hai (2 nodes exist karte hain)
            if(right != null){

                ListNode nextleft = right.next; // next pair ka starting node save karo

                reverse(left, size); // current pair reverse karo

                // Agar ye first pair nahi hai
                if(prevleft != null){
                    prevleft.next = right; // previous pair ko current reversed pair se jodo
                }

                // Update pointers for next iteration
                prevleft = left;     // ab left (jo reverse ke baad tail ban gaya) prev banega
                left = nextleft;     // next pair ke liye move karo

                // First pair ke case me result set karo
                if(res == null) res = right;  
            }

            // Agar last me single node bach gaya (odd length case)
            else{
                if(prevleft != null){
                    prevleft.next = left;  // last node ko directly attach karo (no reverse)
                }

                if(res == null){
                    res = left; // agar sirf ek hi node tha
                }

                left = null; // loop terminate karne ke liye
            }
        }

        return res; // final head return karo
    }
}
