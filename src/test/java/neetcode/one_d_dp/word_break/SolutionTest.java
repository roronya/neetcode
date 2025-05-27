package neetcode.one_d_dp.word_break;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    /**
     * Input: s = "neetcode", wordDict = ["neet","code"]
     * <p>
     * Output: true
     */
    @Test
    void example1() {
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");

        Solution solution = new Solution();
        boolean actual = solution.wordBreak(s, wordDict);
        Assertions.assertTrue(actual);
    }

    /**
     * Input: s = "applepenapple", wordDict = ["apple","pen","ape"]
     * <p>
     * Output: true
     */
    @Test
    void example2() {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple", "pen", "ape");

        Solution solution = new Solution();
        boolean actual = solution.wordBreak(s, wordDict);
        Assertions.assertTrue(actual);
    }

    /**
     * Input: s = "catsincars", wordDict = ["cats","cat","sin","in","car"]
     * <p>
     * Output: false
     */
    @Test
    void example3() {
        String s = "catsincars";
        List<String> wordDict = List.of("cats", "cat", "sin", "in", "car");

        Solution solution = new Solution();
        boolean actual = solution.wordBreak(s, wordDict);
        Assertions.assertFalse(actual);
    }

    /**
     * s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
     * wordDict=["aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"]
     */
}