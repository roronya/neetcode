package neetcode.linked_list;

public class Utils {
    public static boolean deepEquals(ListNode actual, ListNode expected) {
        if (actual == null) {
            return expected == null;
        }
        while (actual != null && expected != null) {
            if (actual.val != expected.val) return false;
            actual = actual.next;
            expected = expected.next;
        }
        return true;
    }

    public static boolean deepEquals(Node actual, Node expected) {
        if (actual == null) {
            return expected == null;
        }
        while (actual != null && expected != null) {
            if (actual.val != expected.val) return false;
            if (actual.random != expected.random) return false;
            actual = actual.next;
            expected = expected.next;
        }
        return true;
    }
}
