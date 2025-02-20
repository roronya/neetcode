package neetcode.binary_search.search_a_2d_matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}};
        int target = 10;
        boolean actual = solution.searchMatrix(matrix, target);
        Assertions.assertTrue(actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}};
        int target = 15;
        boolean actual = solution.searchMatrix(matrix, target);
        Assertions.assertFalse(actual);
    }
}