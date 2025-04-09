package neetcode.backtracking.combination_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    /**
     * Input:
     * nums = [2,5,6,9]
     * target = 9
     * <p>
     * Output: [[2,2,5],[9]]
     */
    @Test
    void example1() {
        int[] nums = {2, 5, 6, 9};
        int target = 9;

        Solution solution = new Solution();
        List<List<Integer>> actual = solution.combinationSum(nums, target);

        List<List<Integer>> expected = List.of(
                List.of(2, 2, 5),
                List.of(9)
        );

        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input:
     * nums = [3,4,5]
     * target = 16
     * <p>
     * Output: [[3,3,3,3,4],[3,3,5,5],[4,4,4,4],[3,4,4,5]]
     */
    @Test
    void example2() {
        int[] nums = {3, 4, 5};
        int target = 16;

        Solution solution = new Solution();
        List<List<Integer>> actual = solution.combinationSum(nums, target);

        List<List<Integer>> expected = List.of(
                List.of(3, 3, 3, 3, 4),
                List.of(3, 3, 5, 5),
                List.of(3, 4, 4, 5),
                List.of(4, 4, 4, 4)
        );

        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input:
     * nums = [3]
     * target = 5
     * <p>
     * Output: []
     */
    @Test
    void example3() {
        int[] nums = {3};
        int target = 5;

        Solution solution = new Solution();
        List<List<Integer>> actual = solution.combinationSum(nums, target);

        List<List<Integer>> expected = List.of();

        Assertions.assertEquals(expected, actual);
    }
}