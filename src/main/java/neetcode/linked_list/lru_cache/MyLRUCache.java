package neetcode.linked_list.lru_cache;

import neetcode.linked_list.ListNode;

import java.util.HashMap;

class MyLRUCache {
    private int capacity;
    private int size = 0;
    private ListNode head;
    private HashMap<Integer, ListNode> map = new HashMap<>();
    private HashMap<ListNode, Integer> reverseMap = new HashMap<>();

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * time complexity: O(1)
     * space complexity: O(n) + O(n) + O(n)
     *
     * @param key
     * @return
     */
    public int get(int key) {
        ListNode node = map.getOrDefault(key, null);
        return node == null ? -1 : node.val;
    }

    /**
     * 渡されたkeyでNodeを作る
     * 内部のLinkedListのheadにする
     * capacityよりLinkedListのsizeがデカくなったらtailを切り離す
     * また内部的にHashMapを持っておき、key:Nodeで保存しておく
     * 切り離されたときにkeyを消しておく
     * <p>
     * time complexity: O(n)
     * space complexity: O(n)
     *
     * @param key
     * @return
     */
    public void put(int key, int value) {
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            head = newNode;
            size++;
            map.put(key, newNode);
            reverseMap.put(newNode, key);
            return;
        }

        if (map.get(key) != null) {
            map.put(key, newNode);
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
        map.put(key, newNode);
        reverseMap.put(newNode, key);
        if (size > capacity) {
            ListNode current = head;
            for (int i = 0; i < capacity - 1; i++)
                current = current.next;
            int tailKey = reverseMap.get(current.next);
            reverseMap.remove(current.next);
            map.remove(tailKey);
            current.next = null;
            size--;
        }
    }
}
