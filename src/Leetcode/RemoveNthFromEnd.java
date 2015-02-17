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
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode point1 = head;
        ListNode point2 = head;
        while (n > 0) {
            n--;
            point1 = point1.next;
            if (point1 == null) {
                return head.next;
            }
        }
        while (point1.next != null) {
            point1 = point1.next;
            point2 = point2.next;
        }
        point2.next = point2.next.next;
        return head;
    }

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
