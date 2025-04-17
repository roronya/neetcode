package neetcode.backtracking.n_queens;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    /**
     * Input: n = 4
     *
     * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     */
    @Test
    void example1() {
        int n = 4;
        Solution solution = new Solution();
        List<List<String>> actual = solution.solveNQueens(n);
        List<List<String>> expected = List.of(
                List.of(".Q..","...Q","Q...","..Q."),
                List.of("..Q.","Q...","...Q",".Q..")
        );
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input: n = 1
     *
     * Output: [["Q"]]
     */
    @Test
    void example2() {
        int n = 1;
        Solution solution = new Solution();
        List<List<String>> actual = solution.solveNQueens(n);
        List<List<String>> expected = List.of(
                List.of("Q")
        );
        Assertions.assertEquals(expected, actual);
    }
}