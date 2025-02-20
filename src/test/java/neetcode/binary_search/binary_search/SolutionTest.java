package neetcode.binary_search.binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 2, 4, 6, 8};
        int target = 4;
        int expected = 3;
        int actual = solution.search(nums, target);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 2, 4, 6, 8};
        int target = 3;
        int expected = -1;
        int actual = solution.search(nums, target);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        int[] nums = {2, 5};
        int target = 5;
        int expected = 1;
        int actual = solution.search(nums, target);
        Assertions.assertEquals(expected, actual);
    }
}