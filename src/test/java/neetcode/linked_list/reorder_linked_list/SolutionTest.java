package neetcode.linked_list.reorder_linked_list;

import neetcode.linked_list.ListNode;
import neetcode.linked_list.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        ListNode head = ListNode.of(2, 4, 6, 8);
        solution.reorderList(head);
        ListNode expected = ListNode.of(2, 8, 4, 6);
        System.out.println(head);
        Assertions.assertTrue(Utils.deepEquals(head, expected));
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        ListNode head = ListNode.of(2, 4, 6, 8, 10);
        solution.reorderList(head);
        ListNode expected = ListNode.of(2, 10, 4, 8, 6);
        System.out.println(head);
        Assertions.assertTrue(Utils.deepEquals(head, expected));
    }
}