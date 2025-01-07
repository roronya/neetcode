package neetcode.two_pointers.trapping_rain_water;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int[] height = new int[]{0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
        var actual = solution.trap(height);
        assertEquals(9, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int[] height = new int[]{1, 0, 1};
        var actual = solution.trap(height);
        assertEquals(1, actual);
    }


    @Test
    void example3() {
        Solution solution = new Solution();
        int[] height = new int[]{0};
        var actual = solution.trap(height);
        assertEquals(0, actual);
    }

    @Test
    void example4() {
        Solution solution = new Solution();
        int[] height = new int[]{1, 1, 1};
        var actual = solution.trap(height);
        assertEquals(0, actual);
    }

    @Test
    void example5() {
        Solution solution = new Solution();
        int[] height = new int[]{1, 0, 0, 0, 1};
        var actual = solution.trap(height);
        assertEquals(3, actual);
    }

}