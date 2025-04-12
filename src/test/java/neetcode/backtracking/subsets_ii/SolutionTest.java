package neetcode.backtracking.subsets_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    /**
     * Input: nums = [1,2,1]
     * <p>
     * Output: [[],[1],[1,2],[1,1],[1,2,1],[2]]
     */
    @Test
    void example1() {
        int[] nums = {1, 2, 1};
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.subsetsWithDup(nums);
        List<List<Integer>> expected = List.of(
                List.of(),
                List.of(1),
                List.of(1, 2),
                List.of(1, 1),
                List.of(1, 2, 1),
                List.of(2)
        );
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input: nums = [7,7]
     * <p>
     * Output: [[],[7], [7,7]]
     */
    @Test
    void example2() {
        int[] nums = {7, 7};
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.subsetsWithDup(nums);
        List<List<Integer>> expected = List.of(
                List.of(),
                List.of(7),
                List.of(7, 7)
        );
        Assertions.assertEquals(expected, actual);
    }
}