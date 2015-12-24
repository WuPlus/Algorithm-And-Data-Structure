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
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null) {
            lenA++;
            p1 = p1.next;
        }

        while (p2 != null) {
            lenB++;
            p2 = p2.next;
        }

        int diff = Math.abs(lenA - lenB);
        if (lenA < lenB) {
            p1 = headB;
            p2 = headA;
        } else {
            p1 = headA;
            p2 = headB;
        }

        while (diff > 0) {
            p1 = p1.next;
            diff--;
        }

        while (p1 != null && p1.val != p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;

    }
}
