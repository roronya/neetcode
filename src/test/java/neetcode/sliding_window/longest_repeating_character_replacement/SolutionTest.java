package neetcode.sliding_window.longest_repeating_character_replacement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int actual = solution.characterReplacement("XYYX", 2);
        // "XYYX" => "X**X" => "XYY*" => 4
        assertEquals(4, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int actual = solution.characterReplacement("AAABABB", 1);
        // AAA*ABB => AAAB*BB
        assertEquals(5, actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        int actual = solution.characterReplacement("AABABBA", 1);
        // AA*ABBA => AAB*BBA" => AABA*BA => AABABB*
        assertEquals(4, actual);
    }

    @Test
    void example4() {
        Solution solution = new Solution();
        int actual = solution.characterReplacement("ABBB", 2);
        // AA*ABBA => AAB*BBA" => AABA*BA => AABABB*
        assertEquals(4, actual);
    }


}