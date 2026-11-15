
class Solution {
    public ListNode partition(ListNode head, int x) {

        // Dummy nodes for both partitions
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        // Traverse original linked list
        while (head != null) {

            if (head.val < x) {

                // Add node to less list
                less.next = head;
                less = less.next;

            } else {

                // Add node to greater or equal list
                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        // Terminate greater list
        greater.next = null;

        // Connect both partitions
        less.next = greaterDummy.next;

        return lessDummy.next;
    }
}
