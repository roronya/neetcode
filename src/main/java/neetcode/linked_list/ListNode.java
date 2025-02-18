package neetcode.linked_list;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        ListNode current = this;
        while (current != null) {
            if (!builder.toString().equals("[")) builder.append(", ");
            builder.append(current.val);
            current = current.next;
        }
        builder.append("]");
        return builder.toString();
    }

    public static ListNode of(int... array) {
        if (array.length == 0) return null;

        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        for (int i = 0; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
        return dummyHead.next;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.toString(), obj.toString());
    }
}
