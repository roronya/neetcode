package neetcode.arrays_and_hashing.longest_consecutive_sequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void Example1() {
        int[] nums = {2, 20, 4, 10, 3, 4, 5};
        int actual = solution.longestConsecutive(nums);
        assertEquals(4, actual);
    }

    @Test
    void Example2() {
        int[] nums = {0, 3, 2, 5, 4, 6, 1, 1};
        int actual = solution.longestConsecutive(nums);
        assertEquals(7, actual);

    }

}