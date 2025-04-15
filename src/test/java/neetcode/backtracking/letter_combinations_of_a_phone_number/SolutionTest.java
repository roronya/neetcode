package neetcode.backtracking.letter_combinations_of_a_phone_number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    /**
     * Input: digits = "34"
     * <p>
     * Output: ["dg","dh","di","eg","eh","ei","fg","fh","fi"]
     */
    @Test
    void example1() {
        String digits = "34";
        Solution solution = new Solution();
        List<String> actual = solution.letterCombinations(digits);
        List<String> expected = List.of("dg", "dh", "di", "eg", "eh", "ei", "fg", "fh", "fi");
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    /**
     * Input: digits = ""
     * <p>
     * Output: []
     */
    @Test
    void example2() {
        String digits = "";
        Solution solution = new Solution();
        List<String> actual = solution.letterCombinations(digits);
        List<String> expected = List.of();
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

}