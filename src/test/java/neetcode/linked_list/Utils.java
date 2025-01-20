package neetcode.linked_list;

public class Utils {
    public static boolean deepEquals(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }
        return true;
    }
}
