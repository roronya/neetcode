package neetcode.arrays_and_hashing.top_k_frequents_elements;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void example1() {
        var solution = new Solution();
        int[] nums = new int[]{1, 2, 2, 3, 3, 3};
        int[] actual = solution.topKFrequent(nums, 2);
        int[] expected = new int[]{2, 3};
        Arrays.sort(actual);
        Arrays.sort(expected);
        assertArrayEquals(expected, actual);

    }

    @Test
    void example2() {
        var solution = new Solution();
        int[] nums = new int[]{7, 7};
        int[] actual = solution.topKFrequent(nums, 1);
        assertArrayEquals(new int[]{7}, actual);
    }
}
