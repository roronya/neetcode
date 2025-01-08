package neetcode.sliding_window.best_time_to_buy_and_sell_stock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int[] prices = new int[]{10, 1, 5, 6, 7, 1};
        int actual = solution.maxProfit(prices);
        assertEquals(6, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int[] prices = new int[]{10, 8, 7, 5, 2};
        int actual = solution.maxProfit(prices);
        assertEquals(0, actual);
    }
}