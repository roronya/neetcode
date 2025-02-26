package neetcode.binary_search.time_based_key_value_store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TimeMapTest {
    @Test
    void example1() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("alice", "happy", 1);  // store the key "alice" and value "happy" along with timestamp = 1.
        Assertions.assertEquals("happy", timeMap.get("alice", 1));           // return "happy"
        Assertions.assertEquals("happy", timeMap.get("alice", 2));           // return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
        timeMap.set("alice", "sad", 3);    // store the key "alice" and value "sad" along with timestamp = 3.
        Assertions.assertEquals("sad", timeMap.get("alice", 3));           // return "sad"
    }

    @Test
    void example2() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        String value = timeMap.get("foo", 1);
        Assertions.assertEquals("bar", value);
        timeMap.get("foo", 3);
        Assertions.assertEquals("bar", value);
        timeMap.set("foo", "bar2", 4);
        value = timeMap.get("foo", 4);
        Assertions.assertEquals("bar2", value);
        value = timeMap.get("foo", 5);
        Assertions.assertEquals("bar2", value);
    }

    @Test
    void example3() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("key1", "value1", 10);
        String value = timeMap.get("key1", 1);
        Assertions.assertEquals("", value);
        value = timeMap.get("key1", 10);
        Assertions.assertEquals("value1", value);
        value = timeMap.get("key1", 11);
        Assertions.assertEquals("value1", value);
    }

}