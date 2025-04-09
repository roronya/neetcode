package neetcode.backtracking.combination_sum_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    /**
     * Input: candidates = [9,2,2,4,6,1,5], target = 8
     * <p>
     * Output: [
     * [1,2,5],
     * [2,2,4],
     * [2,6]
     * ]
     */
    @Test
    void example1() {
        int[] candidates = {9, 2, 2, 4, 6, 1, 5};
        int target = 8;

        Solution solution = new Solution();
        List<List<Integer>> actual = solution.combinationSum2(candidates, target);
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 5),
                List.of(2, 2, 4),
                List.of(2, 6)
        );
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input: candidates = [1,2,3,4,5], target = 7
     * <p>
     * Output: [
     * [1,2,4],
     * [2,5],
     * [3,4]
     * ]
     */
    @Test
    void example2() {
        int[] candidates = {1, 2, 3, 4, 5};
        int target = 7;

        Solution solution = new Solution();
        List<List<Integer>> actual = solution.combinationSum2(candidates, target);
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 4),
                List.of(2, 5),
                List.of(3, 4)
        );
        Assertions.assertEquals(expected, actual);
    }
}