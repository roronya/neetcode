package neetcode.linked_list;

import java.util.HashMap;
import java.util.List;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node of(List<Integer>... nodes) {
        if (nodes.length < 2) return new Node(nodes[0].getFirst());

        HashMap<Integer, Node> map = new HashMap<>(); // index:Node
        Node dummy = new Node(0);
        Node prev = dummy;
        int i = 0;
        for (List<Integer> node : nodes) {
            Node cur = new Node(node.getFirst());
            map.put(i, cur);
            prev.next = cur;
            prev = cur;
            i++;
        }
        i = 0;
        for (List<Integer> node : nodes) {
            Node src = map.get(i);
            Node dst = map.get(node.get(1));
            src.random = dst;
            i++;
        }
        System.out.println(map);
        return dummy.next;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Node.class) return false;
        return ((Node) obj).val == val;
    }

    @Override
    public String toString() {
        Node cur = this;
        StringBuilder builder = new StringBuilder();
        builder.append("[\n");
        while (cur != null) {
            builder.append("\t{val: ")
                    .append(cur.val)
                    .append(", next: ")
                    .append(cur.next == null ? "null" : String.valueOf(cur.next.val))
                    .append(", random: ")
                    .append(cur.random == null ? "null" : String.valueOf(cur.random.val))
                    .append("}\n");
            cur = cur.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
