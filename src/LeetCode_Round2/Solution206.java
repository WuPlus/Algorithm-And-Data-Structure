/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

/**
 *
 * @author Wu
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        ListNode next = head;
        ListNode newhead = null;
        ListNode current = head;

        while (next != null) {
            next = next.next;
            current.next = newhead;
            newhead = current;
            current = next;
        }

        return newhead;
    }
}
