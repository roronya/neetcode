package neetcode.linked_list.add_two_numbers;

import neetcode.linked_list.ListNode;
import neetcode.linked_list.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        ListNode l1 = ListNode.of(1, 2, 3), l2 = ListNode.of(4, 5, 6);

        ListNode actual = solution.addTwoNumbers(l1, l2);

        ListNode expected = ListNode.of(5, 7, 9);
        Assertions.assertTrue(Utils.deepEquals(actual, expected));
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        ListNode l1 = ListNode.of(9), l2 = ListNode.of(9);

        ListNode actual = solution.addTwoNumbers(l1, l2);

        ListNode expected = ListNode.of(8, 1);
        Assertions.assertTrue(Utils.deepEquals(actual, expected));
    }


    @Test
    void example3() {
        Solution solution = new Solution();
        ListNode l1 = ListNode.of(9, 9, 1), l2 = ListNode.of(1);

        ListNode actual = solution.addTwoNumbers(l1, l2);

        ListNode expected = ListNode.of(0, 0, 2);
        //System.out.println(actual);
        //System.out.println(expected);
        Assertions.assertTrue(Utils.deepEquals(actual, expected));
    }

}