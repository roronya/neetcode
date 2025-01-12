package neetcode.sliding_window.longest_substring_without_repeating_characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int actual = solution.lengthOfLongestSubstring("zxyzxyz");
        assertEquals(3, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int actual = solution.lengthOfLongestSubstring("xxxx");
        assertEquals(1, actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        int actual = solution.lengthOfLongestSubstring("pwwkew");
        assertEquals(3, actual);
    }

    @Test
    void example4() {
        Solution solution = new Solution();
        int actual = solution.lengthOfLongestSubstring(" ");
        assertEquals(1, actual);
    }

    @Test
    void example5() {
        Solution solution = new Solution();
        int actual = solution.lengthOfLongestSubstring("dvdf");
        assertEquals(3, actual);
    }

    @Test
    void example6() {
        Solution solution = new Solution();
        int actual = solution.lengthOfLongestSubstring("cdd");
        assertEquals(2, actual);
    }
}