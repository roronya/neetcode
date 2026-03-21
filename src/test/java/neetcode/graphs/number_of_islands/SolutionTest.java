package neetcode.graphs.number_of_islands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        char[][] grid = {
                {'0', '1', '1', '1', '0'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int actual = solution.numIslands(grid);
        Assertions.assertEquals(1, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        char[][] grid = {
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int actual = solution.numIslands(grid);
        Assertions.assertEquals(4, actual);
    }
}