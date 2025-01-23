package neetcode.linked_list;

import java.util.Objects;

public class Utils {
    public static boolean deepEquals(ListNode actual, ListNode expected) {
        return Objects.equals(actual.toString(), expected.toString());
    }

    public static boolean deepEquals(final Node actual, final Node expected) {
        return Objects.equals(actual.toString(), expected.toString());
    }
}
