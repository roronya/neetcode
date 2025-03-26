package neetcode.tries.implement_trie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrefixTreeTest {
    @Test
    void example1() {
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("dog");
        Assertions.assertTrue(prefixTree.search("dog"));
        Assertions.assertFalse(prefixTree.search("do"));
        Assertions.assertTrue(prefixTree.startsWith("do"));
        prefixTree.insert("do");
        Assertions.assertTrue(prefixTree.search("do"));
    }
}