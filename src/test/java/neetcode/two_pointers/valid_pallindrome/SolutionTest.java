package neetcode.two_pointers.valid_pallindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        boolean actual = solution.isPalindrome("Was it a car or a cat I saw?");
        assertTrue(actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        boolean actual = solution.isPalindrome("tab a cat");
        assertFalse(actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        boolean actual = solution.isPalindrome("0P");
        assertFalse(actual);
    }
}