package neetcode.linked_list.remove_node_from_end_of_linked_list;

import neetcode.linked_list.ListNode;
import neetcode.linked_list.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void exampmle1() {
        final Solution solution = new Solution();
        final ListNode head = ListNode.of(1, 2, 3, 4);
        final ListNode actual = solution.removeNthFromEnd(head, 2);
        final ListNode expected = ListNode.of(1, 2, 4);
        Assertions.assertTrue(Utils.deepEquals(actual, expected));
    }

    @Test
    void exampmle2() {
        final Solution solution = new Solution();
        final ListNode head = ListNode.of(5);
        final ListNode actual = solution.removeNthFromEnd(head, 1);
        final ListNode expected = ListNode.of();
        Assertions.assertTrue(Utils.deepEquals(actual, expected));
    }

    @Test
    void exampmle3() {
        final Solution solution = new Solution();
        final ListNode head = ListNode.of(1, 2);
        final ListNode actual = solution.removeNthFromEnd(head, 2);
        final ListNode expected = ListNode.of(2);
        Assertions.assertTrue(Utils.deepEquals(actual, expected));
    }
}