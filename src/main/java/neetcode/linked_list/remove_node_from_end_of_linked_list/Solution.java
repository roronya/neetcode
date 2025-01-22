package neetcode.linked_list.remove_node_from_end_of_linked_list;

import neetcode.linked_list.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        for (int i = 0; i < n; i++) right = right.next;

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }
}

