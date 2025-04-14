package neetcode.backtracking.palindrome_partitioning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    /**
     * Input: s = "aab"
     * <p>
     * Output: [["a","a","b"],["aa","b"]]
     */
    @Test
    void example1() {
        String s = "aab";
        Solution solution = new Solution();
        List<List<String>> actual = solution.partition(s);
        List<List<String>> expected = List.of(
                List.of("a", "a", "b"),
                List.of("aa", "b")
        );
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input: s = "a"
     * <p>
     * Output: [["a"]]
     */
    @Test
    void example2() {
        String s = "a";
        Solution solution = new Solution();
        List<List<String>> actual = solution.partition(s);
        List<List<String>> expected = List.of(
                List.of("a")
        );
        Assertions.assertEquals(expected, actual);
    }
}