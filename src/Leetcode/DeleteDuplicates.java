/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode pointer;
        while (cur != null) {
            pointer = cur.next;
            while (pointer != null && pointer.val == cur.val) {
                pointer = pointer.next;
            }
            cur.next = pointer;
            cur = pointer;
        }
        return head;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
