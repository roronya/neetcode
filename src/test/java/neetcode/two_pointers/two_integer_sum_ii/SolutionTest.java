package neetcode.two_pointers.two_integer_sum_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int[] numbers = new int[]{1, 2, 3, 4};
        int target = 3;
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(numbers, target));
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int[] numbers = new int[]{2, 3, 4};
        int target = 6;
        assertArrayEquals(new int[]{1, 3}, solution.twoSum(numbers, target));
    }

}