package neetcode.linked_list.lru_cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LRUCacheTest {
    @Test
    void example() {
        DoubleyLinkedListLRUCache lRUCache = new DoubleyLinkedListLRUCache(2);
        lRUCache.put(1, 10);  // cache: {1=10}
        Assertions.assertEquals(10, lRUCache.get(1));
        lRUCache.put(2, 20);  // cache: {1=10, 2=20}
        lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
        Assertions.assertEquals(20, lRUCache.get(2));
        Assertions.assertEquals(-1, lRUCache.get(1));
    }

    @Test
    void example1() {
        DoubleyLinkedListLRUCache lRUCache = new DoubleyLinkedListLRUCache(2);
        lRUCache.put(1, 10);  // cache: {1=10}
        Assertions.assertEquals(10, lRUCache.get(1));
        lRUCache.put(1, 20);  // cache: {1=20}
        Assertions.assertEquals(20, lRUCache.get(1));
        lRUCache.put(1, 30);  // cache: {1=20}
        Assertions.assertEquals(30, lRUCache.get(1));
    }

    @Test
    void example2() {
        DoubleyLinkedListLRUCache lRUCache = new DoubleyLinkedListLRUCache(2);
        lRUCache.put(1, 1); // cache: {1=1}
        lRUCache.put(2, 2); // cache: {1=1, 2=2}
        Assertions.assertEquals(1, lRUCache.get(1)); // 1がgetされてるから
        lRUCache.put(3, 3); // このタイミングで捨てられるべきはkey=2
        Assertions.assertEquals(-1, lRUCache.get(2));
        lRUCache.put(4, 4);
        Assertions.assertEquals(-1, lRUCache.get(1));
        Assertions.assertEquals(3, lRUCache.get(3));
        Assertions.assertEquals(4, lRUCache.get(4));
    }
}