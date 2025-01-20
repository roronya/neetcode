package neetcode.linked_list;

public class Utils {
    public static boolean deepEquals(ListNode actual, ListNode expected) {
        while (actual != null && expected != null) {
            if (actual.val != expected.val) return false;
            actual = actual.next;
            expected = expected.next;
        }
        return true;
    }
}
