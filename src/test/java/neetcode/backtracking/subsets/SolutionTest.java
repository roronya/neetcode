package neetcode.backtracking.subsets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.subsets(new int[]{1, 2, 3});
        // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        List<List<Integer>> expected = List.of(
                List.of(),
                List.of(1),
                List.of(2),
                List.of(1, 2),
                List.of(3),
                List.of(1, 3),
                List.of(2, 3),
                List.of(1, 2, 3)
        );
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void exmaple2() {
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.subsets(new int[]{7});
        List<List<Integer>> expected = List.of(List.of(), List.of(7));
        Assertions.assertEquals(expected, actual);
    }
}