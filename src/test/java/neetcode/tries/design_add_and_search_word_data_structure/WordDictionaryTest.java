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

    // ["WordDictionary","addWord","dog","search","do.."]
    @Test
    void example2() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("dog");
        Assertions.assertFalse(wordDictionary.search("do.."));
    }

    @Test
    void example3() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("complex");
        wordDictionary.addWord("complication");
        Assertions.assertTrue(wordDictionary.search("c.mpl.x"));
        Assertions.assertTrue(wordDictionary.search("complic.tion"));
        Assertions.assertFalse(wordDictionary.search("..........."));
        Assertions.assertFalse(wordDictionary.search("c....."));
    }
}