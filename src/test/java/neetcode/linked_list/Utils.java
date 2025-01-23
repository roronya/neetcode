package neetcode.linked_list;

import java.util.Objects;

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

    public static boolean deepEquals(final Node actual, final Node expected) {
        return Objects.equals(actual.toString(), expected.toString());
    }
}
