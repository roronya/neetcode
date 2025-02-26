package neetcode.binary_search.time_based_key_value_store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1 <= key.length, value.length <= 100
 * key and value only include lowercase English letters and digits.
 * 1 <= timestamp <= 1000
 * You should aim for a solution with
 * O(1) time for set(),
 * O(logn) time for get(),
 * and O(m * n) space,
 * where n is the total number of values associated with a key,
 * and m is the total number of keys.
 */
class TimeMap {
    HashMap<String, List<Element>> map = new HashMap<>();

    class Element {
        String value;
        int timestamp;

        public Element(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        List<Element> elements;
        if (map.containsKey(key)) {
            elements = map.get(key);
        } else {
            elements = new ArrayList<>();
        }
        Element element = new Element(value, timestamp);
        elements.add(element);
        map.put(key, elements);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Element> elements = map.get(key);
        int l = 0, r = elements.size() - 1;
        Element latest = new Element("", -1);
        while (l <= r) {
            System.out.print(l + ":" + r);
            int m = (l + r) / 2;
            Element element = elements.get(m);
            if (element.timestamp <= timestamp) {
                latest = latest.timestamp < element.timestamp ? element : latest;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return latest.timestamp < 0 ? "" : latest.value;
    }
}

