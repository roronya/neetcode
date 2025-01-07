package neetcode.two_pointers.cotainer_with_most_water;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int[] height = new int[]{1, 7, 2, 5, 4, 7, 3, 6};
        int actual = solution.maxArea(height);
        assertEquals(36, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int[] height = new int[]{2, 2, 2};
        int actual = solution.maxArea(height);
        assertEquals(4, actual);
    }

}