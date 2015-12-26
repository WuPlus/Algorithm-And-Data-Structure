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
public class Solution234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = p1.next;
        ListNode pre = p1;

        while (p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            pre = p1;
            p1 = p3;
            p3 = p3.next;
            p1.next = pre;
        }

        if (p2.next == null) {
            p1 = p1.next;
        }

        while (p3 != null) {
            if (p1.val != p3.val) {
                return false;
            }
            p1 = p1.next;
            p3 = p3.next;
        }
        return true;
    }
}
