package neetcode.one_d_dp.coin_change;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * Input: coins = [1,5,10], amount = 12
     * <p>
     * Output: 3
     */
    @Test
    void example1() {
        int[] coins = {1, 5, 10};
        int amount = 12;
        Solution solution = new Solution();
        int actual = solution.coinChange(coins, amount);
        Assertions.assertEquals(3, actual);
    }

    /**
     * Input: coins = [2], amount = 3
     * <p>
     * Output: -1
     */
    @Test
    void example2() {
        int[] coins = {2};
        int amount = 3;
        Solution solution = new Solution();
        int actual = solution.coinChange(coins, amount);
        Assertions.assertEquals(-1, actual);
    }

    /**
     * Input: coins = [1], amount = 0
     * <p>
     * Output: 0
     */
    @Test
    void example3() {
        int[] coins = {1};
        int amount = 0;
        Solution solution = new Solution();
        int actual = solution.coinChange(coins, amount);
        Assertions.assertEquals(0, actual);
    }

    /**
     * coins=[1,2,5]
     * amount=100
     */
    @Test
    void example4() {
        int[] coins = {1, 2, 5};
        int amount = 100;
        Solution solution = new Solution();
        int actual = solution.coinChange(coins, amount);
        Assertions.assertEquals(20, actual);
    }
}