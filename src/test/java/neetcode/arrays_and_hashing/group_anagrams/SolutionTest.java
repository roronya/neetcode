package neetcode.arrays_and_hashing.group_anagrams;

import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    void main() {
        var solution = new Solution();
        String[] strs;
        List<List<String>> actual;
        // Example 1:
        strs = new String[]{"act", "pots", "tops", "cat", "stop", "hat"};
        actual = solution.groupAnagrams(strs);
        System.out.println(actual); // Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

        // Example 2:
        strs = new String[]{"x"};
        actual = solution.groupAnagrams(strs);
        System.out.println(actual); // Output: [["x"]]

        // Example 3:
        strs = new String[]{""};
        actual = solution.groupAnagrams(strs);
        System.out.println(actual); // Output: [[""]]
    }
}
