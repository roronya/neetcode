package neetcode.stack.generate_parentheses;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void example1() {
        var actual = solution.generateParenthesis(1);
        List<String> expected = new ArrayList<>();
        expected.add("()");
        assertLinesMatch(expected, actual);
    }

    @Test
    void example2() {
        var actual = solution.generateParenthesis(3);
        List<String> expected = new ArrayList<>();
        expected.add("((()))");
        expected.add("(()())");
        expected.add("(())()");
        expected.add("()(())");
        expected.add("()()()");
        assertLinesMatch(expected, actual);
    }

    @Test
    void testIsValid() {
        assertTrue(solution.isValid("()()()"));
        assertFalse(solution.isValid("((()()"));
    }

}