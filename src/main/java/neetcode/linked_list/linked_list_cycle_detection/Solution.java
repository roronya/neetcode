package neetcode.linked_list.linked_list_cycle_detection;

import neetcode.linked_list.ListNode;

import java.util.HashSet;

class Solution {
    public boolean hasCycle(ListNode head) {
        return set(head);
    }

    boolean set(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        var current = head;
        while (current != null) {
            if (set.contains(current)) return true;
            set.add(current);
            current = current.next;
        }
        return false;
    }
}
