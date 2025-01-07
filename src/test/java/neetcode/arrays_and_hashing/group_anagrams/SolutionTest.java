package neetcode.arrays_and_hashing.group_anagrams;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SolutionTest {

    @Test
    void example1() {
        var solution = new Solution();
        String[] strs = new String[]{"act", "pots", "tops", "cat", "stop", "hat"};
        List<List<String>> actual = solution.groupAnagrams(strs);
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("hat"),
                Arrays.asList("act", "cat"),
                Arrays.asList("stop", "pots", "tops")
        );

        // ソートして順不同で比較
        sortNestedLists(actual);
        sortNestedLists(expected);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void example2() {
        var solution = new Solution();
        String[] strs = new String[]{"x"};
        List<List<String>> actual = solution.groupAnagrams(strs);
        List<List<String>> expected = List.of(List.of("x"));

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void example3() {
        var solution = new Solution();
        String[] strs = new String[]{""};
        List<List<String>> actual = solution.groupAnagrams(strs);
        List<List<String>> expected = List.of(List.of(""));

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private void sortNestedLists(List<List<String>> lists) {
        // 内部リストをソート
        for (List<String> list : lists) {
            Collections.sort(list);
        }
        // 外部リストをソート
        lists.sort(Comparator.comparing(a -> String.join(",", a)));
    }
}
