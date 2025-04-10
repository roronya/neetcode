package neetcode.backtracking.permutations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    /**
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    @Test
    void example1() {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.permute(nums);
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        );
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input: nums = [7]
     * Output: [[7]]
     */
    @Test
    void example2() {
        int[] nums = {7};
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.permute(nums);
        List<List<Integer>> expected = List.of(
                List.of(7)
        );
        Assertions.assertEquals(expected, actual);
    }

}