package neetcode.tries.word_seatch_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    @Test
    void example1() {
        var board = new char[][]{
                {'a', 'b', 'c', 'd'},
                {'s', 'a', 'a', 't'},
                {'a', 'c', 'k', 'e'},
                {'a', 'c', 'd', 'n'}
        };
        String[] words = {"bat", "cat", "back", "backend", "stack"};
        Solution solution = new Solution();
        List<String> actual = solution.findWords(board, words);
        List<String> expected = List.of("cat", "back", "backend");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example2() {
        var borad = new char[][]{
                {'x', 'o'},
                {'x', 'o'}
        };
        String[] words = {"xoxo"};
        Solution solution = new Solution();
        List<String> actual = solution.findWords(borad, words);
        List<String> expected = List.of();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example3() {
        var borad = new char[][]{
                {'o', 'a', 'b', 'n'},
                {'o', 't', 'a', 'e'},
                {'a', 'h', 'k', 'r'},
                {'a', 'f', 'l', 'v'}
        };
        String[] words = {"oa", "oaa"};
        Solution solution = new Solution();
        List<String> actual = solution.findWords(borad, words);
        List<String> expected = List.of("oa", "oaa");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example4() {
        var borad = new char[][]{
                {'a', 'b', 'c'},
                {'a', 'e', 'd'},
                {'a', 'f', 'g'}
        };
        String[] words = {"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};
        Solution solution = new Solution();
        List<String> actual = solution.findWords(borad, words);
        List<String> expected = List.of("abcdefg", "befa", "eaabcdgfa", "gfedcbaaa");
        Assertions.assertEquals(expected, actual);
    }
}