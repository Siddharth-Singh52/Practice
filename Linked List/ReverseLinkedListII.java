class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Base case: agar list empty hai ya reverse karne ki zarurat nahi
        if(head == null || left == right){
            return head;
        }

        ListNode t = head;        // pointer jo traverse karega list
        ListNode before = null;   // node just before 'left' position
        int pos = 1;              // current position (1-based index)

        // Traverse till we reach the 'left' position
        while(t != null){

            // Jab tak left position nahi aati, aage badhte raho
            if(pos < left){
                before = t;       // before ko update karte raho
                t = t.next;      // next node pe jao
                pos++;
                continue;
            }

            // Ab t point kar raha hai 'left' position pe

            ListNode prev = null;  // reversed part ka head
            ListNode curr = t;     // current node jo reverse ho raha hai

            // total nodes to reverse
            int times = right - left + 1;
            
            // Reverse the sublist from left to right
            for(int i = 0; i < times; i++){
                ListNode next = curr.next; // next node store karo
                curr.next = prev;          // link reverse karo
                prev = curr;               // prev ko aage badhao
                curr = next;               // curr ko aage badhao
            }

            // Ab:
            // prev = reversed sublist ka head
            // curr = right ke baad wala node

            t.next = curr; // original left node (t) ko baaki list se connect karo

            // Agar left == 1 nahi hai
            if(before != null){
                before.next = prev; // before node ko reversed head se connect karo
                return head;        // head same rahega
            }
            else{
                // Agar left == 1 hai, to naya head prev hoga
                return prev;
            }
        }

        return head; // safety return (normally yaha tak nahi aayega)
    }
}
