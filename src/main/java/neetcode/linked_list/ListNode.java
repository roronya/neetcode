package neetcode.linked_list;

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
        if (array.length < 1) return new ListNode();
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
        return head;
    }

    public boolean deepEquals(ListNode b) {
        ListNode a = this;
        while (a != null && b != null) {
            if (a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }
        return true;
    }
}
