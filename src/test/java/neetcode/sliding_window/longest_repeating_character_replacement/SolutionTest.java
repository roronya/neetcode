package neetcode.sliding_window.longest_repeating_character_replacement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int actual = solution.characterReplacement("XYYX", 2);
        assertEquals(4, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int actual = solution.characterReplacement("AAABABB", 1);
        assertEquals(5, actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        int actual = solution.characterReplacement("AABABBA", 1);
        assertEquals(4, actual);
    }

}