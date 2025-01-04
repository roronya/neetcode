package neetcode.stack.daily_temparatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    void example1() {
        int[] temperatures = new int[]{30, 38, 30, 36, 35, 40, 28};
        int[] expected = new int[]{1, 4, 1, 2, 1, 0, 0};

        Solution solution = new Solution();
        int[] actual = solution.dailyTemperatures(temperatures);
        assertArrayEquals(expected, actual);
    }

    @Test
    void example2() {
        int[] temperatures = new int[]{22, 21, 20};
        int[] expected = new int[]{0, 0, 0};

        Solution solution = new Solution();
        int[] actual = solution.dailyTemperatures(temperatures);
        assertArrayEquals(expected, actual);
    }

}