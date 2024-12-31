package neetcode.stack.evaluate_reverse_polish_notation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        String[] tokens = {"1", "2", "+", "3", "*", "4", "-"};
        int actual = solution.evalRPN(tokens);
        assertEquals(5, actual);
    }

}