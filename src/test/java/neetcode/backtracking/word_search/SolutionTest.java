package neetcode.backtracking.word_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * Input:
     * board = [
     * ["A","B","C","D"],
     * ["S","A","A","T"],
     * ["A","C","A","E"]
     * ],
     * word = "CAT"
     * <p>
     * Output: true
     */
    @Test
    void example1() {
        char[][] board = {
                {'A', 'B', 'C', 'D' },
                {'S', 'A', 'A', 'T' },
                {'A', 'C', 'A', 'E' }
        };
        String word = "CAT";
        Solution solution = new Solution();
        boolean actual = solution.exist(board, word);
        Assertions.assertTrue(actual);
    }

    /**
     * Input:
     * board = [
     * ["A","B","C","D"],
     * ["S","A","A","T"],
     * ["A","C","A","E"]
     * ],
     * word = "BAT"
     * <p>
     * Output: false
     */
    @Test
    void example2() {
        char[][] board = {
                {'A', 'B', 'C', 'D' },
                {'S', 'A', 'A', 'T' },
                {'A', 'C', 'A', 'E' }
        };
        String word = "BAT";
        Solution solution = new Solution();
        boolean actual = solution.exist(board, word);
        Assertions.assertFalse(actual);
    }
}