package neetcode.linked_list.linked_list_cycle_detection;

import neetcode.linked_list.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        var head = ListNode.of(1, 2, 3, 4);
        var tail = head;
        while (tail.next != null) tail = tail.next;
        tail.next = head.next;
        boolean actual = solution.hasCycle(head);
        Assertions.assertTrue(actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        var head = ListNode.of(1, 2);
        boolean actual = solution.hasCycle(head);
        Assertions.assertFalse(actual);

    }
}