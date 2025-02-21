package neetcode.binary_search.koko_eating_bananas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int[] piles = {1, 4, 3, 2};
        int h = 9;
        int actual = solution.minEatingSpeed(piles, h);
        Assertions.assertEquals(2, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int[] piles = {25, 10, 23, 4};
        int h = 4;
        int actual = solution.minEatingSpeed(piles, h);
        Assertions.assertEquals(25, actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        int[] piles = {25, 10, 23, 4};
        int h = 5;
        int actual = solution.minEatingSpeed(piles, h);
        Assertions.assertEquals(23, actual);
        // 24もあるが、23がminimum
    }

    @Test
    void example4() {
        Solution solution = new Solution();
        int[] piles = {25, 10, 23, 4};
        int h = 6;
        int actual = solution.minEatingSpeed(piles, h);
        Assertions.assertEquals(13, actual);
        // 22~14もhを満たすが13がminimum
        // minimumを見つけたいのでk=hを満たしているとき基本的にはkを減らしていく
        // k=hを満たさなくなったときの前のkがans
    }
}