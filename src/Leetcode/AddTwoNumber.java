/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

/**
 *
 * @author Wu
 */
public class AddTwoNumber {

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        int s = 0;
        first.val = (l1.val + l2.val) % 10;
        s = (l1.val + l2.val) / 10;
        ListNode current = first;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            ListNode next = new ListNode(0);
            next.val = (l1.val + l2.val + s) % 10;
            s = (l1.val + l2.val + s) / 10;
            current.next = next;
            current = next;
        }
        while (l1.next == null && l2.next != null) {
            l2 = l2.next;
            ListNode next = new ListNode(0);
            next.val = (l2.val + s) % 10;
            s = (l2.val + s) / 10;
            current.next = next;
            current = next;
        }
        while (l1.next != null && l2.next == null) {
            l1 = l1.next;
            ListNode next = new ListNode(0);
            next.val = (l1.val + s) % 10;
            s = (l1.val + s) / 10;
            current.next = next;
            current = next;
        }
        if (s != 0) {
            ListNode next = new ListNode(s);
            current.next = next;
        }
        return first;
    }
}
