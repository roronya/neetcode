package neetcode.linked_list.lru_cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LRUCacheTest {
    @Test
    void example() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 10);  // cache: {1=10}
        Assertions.assertEquals(10, lRUCache.get(1));
        lRUCache.put(2, 20);  // cache: {1=10, 2=20}
        lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
        Assertions.assertEquals(20, lRUCache.get(2));
        Assertions.assertEquals(-1, lRUCache.get(1));
    }

    @Test
    void example1() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 10);  // cache: {1=10}
        Assertions.assertEquals(10, lRUCache.get(1));
        lRUCache.put(1, 20);  // cache: {1=20}
        Assertions.assertEquals(20, lRUCache.get(1));
        lRUCache.put(1, 30);  // cache: {1=20}
        Assertions.assertEquals(30, lRUCache.get(1));
    }

}