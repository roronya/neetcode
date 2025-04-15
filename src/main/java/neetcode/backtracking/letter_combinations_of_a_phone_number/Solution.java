package neetcode.backtracking.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder comb = new StringBuilder();
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        return myLetterCombinations(digits);
    }

    public List<String> myLetterCombinations(String digits) {
        if (Objects.equals(digits, "")) return Collections.emptyList();
        backtrack(0, digits);
        return res;
    }

    private void backtrack(int i, String digits) {
        if (i == digits.length()) {
            res.add(comb.toString());
            return;
        }
        for (char letter : letters[digits.charAt(i) - '0'].toCharArray()) {
            comb.append(letter);
            backtrack(i + 1, digits);
            comb.deleteCharAt(i);
        }
    }

}

