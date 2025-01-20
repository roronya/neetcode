package neetcode.linked_list.linked_list_cycle_detection;

import neetcode.linked_list.ListNode;

import java.util.HashSet;

class Solution {
    public boolean hasCycle(ListNode head) {
        return fastAndSlowPointer(head);
    }

    /**
     * time complexity O(n)
     * space complexity O(n)
     * n is size of LinkedList
     */
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

    boolean fastAndSlowPointer(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow || fast.next == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
