package neetcode.tries.design_add_and_search_word_data_structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordDictionaryTest {
    @Test
    void example1() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("day");
        wordDictionary.addWord("bay");
        wordDictionary.addWord("may");
        Assertions.assertFalse(wordDictionary.search("say"));
        Assertions.assertTrue(wordDictionary.search("day"));
        Assertions.assertTrue(wordDictionary.search(".ay"));
        Assertions.assertTrue(wordDictionary.search("b.."));
    }
}