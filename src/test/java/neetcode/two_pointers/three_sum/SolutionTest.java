package neetcode.two_pointers.three_sum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> actual = solution.threeSum(nums);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        );
        assertEquals(expected, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 1};
        List<List<Integer>> actual = solution.threeSum(nums);
        List<List<Integer>> expected = List.of();

        assertEquals(expected, actual);
    }
}