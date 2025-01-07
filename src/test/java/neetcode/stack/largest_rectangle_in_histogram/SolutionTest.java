package neetcode.stack.largest_rectangle_in_histogram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int[] heights = new int[]{7, 1, 7, 2, 2, 4};
        int actual = solution.largestRectangleArea(heights);
        assertEquals(8, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int[] heights = new int[]{1, 3, 7};
        int actual = solution.largestRectangleArea(heights);
        assertEquals(7, actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        int actual = solution.largestRectangleArea(heights);
        assertEquals(10, actual);
    }

}