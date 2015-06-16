/*
 * Reverse a singly linked list.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class ReverseList {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //iteratively

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = new ListNode(head.val);
        ListNode current = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            current = new ListNode(head.val);
            current.next = next;
            next = current;
            head = head.next;
        }
        return current;
    }

    //recursively
    public ListNode reverseListRecursive(ListNode head) {
        return reverseRecursive(head, null);
    }

    public ListNode reverseRecursive(ListNode head, ListNode next) {
        ListNode node;
        if (head == null) {
            return next;
        } else {
            node = new ListNode(head.val);
            node.next = next;
            return reverseRecursive(head.next, node);
        }
    }
}
