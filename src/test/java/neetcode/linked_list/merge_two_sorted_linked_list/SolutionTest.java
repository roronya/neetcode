package neetcode.linked_list.merge_two_sorted_linked_list;

import neetcode.linked_list.ListNode;
import neetcode.linked_list.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        ListNode list1 = ListNode.of(1, 2, 4);
        ListNode list2 = ListNode.of(1, 3, 5);
        ListNode actual = solution.mergeTwoLists(list1, list2);
        ListNode expected = ListNode.of(1, 1, 2, 3, 4, 5);
        Assertions.assertTrue(Utils.deepEquals(actual, expected));
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        ListNode list1 = ListNode.of();
        ListNode list2 = ListNode.of(1, 2);
        ListNode actual = solution.mergeTwoLists(list1, list2);
        ListNode expected = ListNode.of(1, 2);
        Assertions.assertTrue(Utils.deepEquals(actual, expected));
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        ListNode list1 = ListNode.of();
        ListNode list2 = ListNode.of();
        ListNode actual = solution.mergeTwoLists(list1, list2);
        ListNode expected = ListNode.of();
        Assertions.assertTrue(Utils.deepEquals(actual, expected));
    }

}