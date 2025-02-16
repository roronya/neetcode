package neetcode.linked_list.lru_cache;

import java.util.HashMap;
import java.util.Objects;

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleyLinkedListLRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    /**
     * headとtailはdummyHeadにしておく。
     * 0<=key=value<=1000のため-1をセットする。
     *
     * @param capacity
     */
    public DoubleyLinkedListLRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        Node prev = node.prev;
        Node next = node.next;
        if (Objects.nonNull(prev)) {
            prev.next = next;
        }
        if (Objects.nonNull(next)) {
            next.prev = prev;
        }
        Node tmp = tail;
        tail = node;
        tmp.next = node;
        tail.prev = tmp;
        return node.val;
    }

    /**
     * old → new の順で並ぶLinkedListを考える
     * capacityを超えているときheadを左へずらす
     * 新しいものは末尾に追加する。
     */
    public void put(int key, int value) {
        // keyがすでに含まれているとき
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            tmp.val = value;
            map.put(key, tmp);
            return;
        }

        // 空のとき
        if (head == null) {
            Node newNode = new Node(key, value);
            head = newNode;
            tail = newNode;
            map.put(key, newNode);
            return;
        }

        // capacityを満たしているとき
        if (map.size() == capacity) {
            Node tmp = head;
            head = head.next;
            head.prev = null;
            tmp.next = null;
            map.remove(tmp.key);
        }

        // capacityを超えておらず末尾に追加するだけのとき
        Node newNode = new Node(key, value);
        Node tmp = tail;
        tail = newNode;
        tmp.next = newNode;
        tail.prev = tmp;
        map.put(key, newNode);
    }
}
