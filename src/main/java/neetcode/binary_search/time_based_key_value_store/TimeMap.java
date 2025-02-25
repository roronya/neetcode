package neetcode.binary_search.time_based_key_value_store;

import java.util.HashMap;
import java.util.Objects;

/**
 * 1 <= key.length, value.length <= 100
 * key and value only include lowercase English letters and digits.
 * 1 <= timestamp <= 1000
 */
class TimeMap {
    HashMap<String, String[]> map = new HashMap<>();

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        String[] values;
        if (map.containsKey(key)) {
            values = map.get(key);
        } else {
            values = new String[1001];
        }
        values[timestamp] = value;
        map.put(key, values);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return null;
        String[] values = map.get(key);
        return searchMax(values, timestamp);
    }

    /**
     * search max value from values until index
     *
     * @param values
     * @param index
     * @return
     */
    String searchMax(String[] values, int index) {
        // System.out.println(Arrays.toString(values));
        int l = 1;
        int r = 1000;
        int max = 0; // values[0] must be always null.
        while (l <= r) {
            System.out.println(l + ":" + r);
            int m = (l + r) / 2;
            if (Objects.isNull(values[m])) {
                r = m - 1;
            } else {
                max = Math.max(max, m);
                l = m + 1;
            }
        }
        return values[max];
    }
}

