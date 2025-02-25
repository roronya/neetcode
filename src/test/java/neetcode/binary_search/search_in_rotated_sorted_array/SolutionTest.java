package neetcode.binary_search.search_in_rotated_sorted_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int[] nums = {3, 4, 5, 6, 1, 2};
        int target = 1;

        int actual = solution.search(nums, target);
        Assertions.assertEquals(4, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int[] nums = {3, 5, 6, 0, 1, 2};
        int target = 4;

        int actual = solution.search(nums, target);
        Assertions.assertEquals(-1, actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int actual = solution.search(nums, target);
        Assertions.assertEquals(4, actual);
    }

    @Test
    void example4() {
        Solution solution = new Solution();
        int[] nums = {5, 1, 3};
        int target = 5;

        int actual = solution.search(nums, target);
        Assertions.assertEquals(0, actual);
    }

    @Test
    void example5() {
        Solution solution = new Solution();
        int[] nums = {5, 1, 2, 3, 4};
        int target = 5;

        int actual = solution.search(nums, target);
        Assertions.assertEquals(0, actual);
    }

    @Test
    void example6() {
        Solution solution = new Solution();
        int[] nums = {5, 1, 2, 3, 4};
        int target = 1;

        int actual = solution.search(nums, target);
        Assertions.assertEquals(1, actual);
    }
}