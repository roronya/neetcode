package neetcode.linked_list.reverse_linked_list;

import neetcode.linked_list.ListNode;
import neetcode.linked_list.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        ListNode head = ListNode.of(0, 1, 2, 3);
        ListNode actual = solution.reverseList(head);
        ListNode expected = ListNode.of(3, 2, 1, 0);
        Assertions.assertTrue(Utils.deepEquals(actual, expected));
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        ListNode head = ListNode.of();
        ListNode actual = solution.reverseList(head);
        ListNode expected = ListNode.of();
        Assertions.assertTrue(Utils.deepEquals(actual, expected));
    }
}