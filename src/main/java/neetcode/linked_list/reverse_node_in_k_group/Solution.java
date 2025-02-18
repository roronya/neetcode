package neetcode.linked_list.reverse_node_in_k_group;

import neetcode.linked_list.ListNode;

import java.util.Objects;

class Solution {
    // in:  1→2→3→4→5→6 k=3
    // out: 3→2→1→6→5→4 or 4←5←6←1←2←3
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode current = head;
        while (Objects.nonNull(current)) {
            size++;
            current = current.next;
        }

        ListNode dummyHead = new ListNode(0);
        current = dummyHead;
        current.next = head;
        int rest = size;
        while (Objects.nonNull(current)) {
            if (rest < k) {
                break;
            }
            ListNode[] reversed = reverse(current, k); // [start, end]
            current.next = reversed[0];
            current = reversed[1];
            rest -= k;
        }
        return dummyHead.next;
    }

    /**
     * dh(head)->1->2->3->4->null
     * dh(head)->1 null<-1<-2<-3(prev) 4(current)->null
     * dh(head)->3(prev)->2->1->4(current)->null
     *
     * @param head dh,1,2,3,4,null
     * @param k    3
     * @return [
     */
    ListNode[] reverse(ListNode head, int k) {
        ListNode current = head.next;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        ListNode reversedTail = head.next;
        head.next.next = current;
        head.next = prev;
        return new ListNode[]{prev, reversedTail};
    }
}
