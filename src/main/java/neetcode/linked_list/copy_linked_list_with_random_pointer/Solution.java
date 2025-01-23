package neetcode.linked_list.copy_linked_list_with_random_pointer;

import neetcode.linked_list.Node;

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        return mySolution(head);
    }

    /**
     * time complexity: O(n)
     * space complexity: O(n)
     */
    public Node mySolution(Node head) {
        HashMap<Node, Node> map = new HashMap<>(); // Node:i
        Node dummy = new Node(0);
        Node newPrev = dummy;
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newPrev.next = newNode;
            map.put(cur, newNode);
            cur = cur.next;
            newPrev = newNode;
        }
        cur = head;
        while (cur != null) {
            Node src = map.get(cur);
            Node dst = cur.random == null ? null : map.get(cur.random);
            src.random = dst;
            cur = cur.next;
        }
        // System.out.println(dummy);
        return dummy.next;
    }
}

