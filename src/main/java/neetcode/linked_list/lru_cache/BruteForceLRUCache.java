package neetcode.linked_list.lru_cache;

import java.util.ArrayList;

class BruteForceLRUCache {
    private int capacity;
    private ArrayList<int[]> cache;

    public BruteForceLRUCache(int capacity) {
        this.capacity = capacity;
        cache = new ArrayList<>();
    }

    public int get(int key) {
        for (int[] ints : cache) {
            if (ints[0] == key) return ints[1];
        }
        return -1;
    }

    /**
     * old → new の順のArrayListを作る。
     * capacityを超えているときremoveFirstする。
     * 新しいものは末尾に追加する。
     */
    public void put(int key, int value) {
        // keyがすでに含まれているとき
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i)[0] == key) {
                int[] tmp = cache.remove(i);
                tmp[1] = value;
                cache.add(tmp);
                return;
            }
        }

        // capacityを超えているとき
        if (cache.size() == capacity) {
            cache.removeFirst();
        }

        // 空のとき
        cache.add(new int[]{key, value});
    }
}
