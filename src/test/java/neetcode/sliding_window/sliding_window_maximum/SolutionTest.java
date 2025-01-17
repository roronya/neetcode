package neetcode.sliding_window.sliding_window_maximum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int[] actual = solution.maxSlidingWindow(new int[]{1, 2, 1, 0, 4, 2, 6}, 3);
        Assertions.assertArrayEquals(new int[]{2, 2, 4, 4, 6}, actual);
    }

}