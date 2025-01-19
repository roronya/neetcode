package neetcode.linked_list.reverse_linked_list;

import neetcode.linked_list.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        ListNode head = ListNode.of(new int[]{0, 1, 2, 3});
        ListNode actual = solution.reverseList(head);
        ListNode expected = ListNode.of(new int[]{3, 2, 1, 0});
        Assertions.assertTrue(actual.deepEquals(expected));
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        ListNode head = ListNode.of(new int[]{});
        ListNode actual = solution.reverseList(head);
        ListNode expected = ListNode.of(new int[]{});
        Assertions.assertTrue(actual.deepEquals(expected));
    }
}