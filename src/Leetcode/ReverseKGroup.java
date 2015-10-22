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
public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        int range = k;
        ListNode newhead = head;
        while(range > 1){
            newhead = newhead.next;
            range--;
            if(newhead == null) return head;
        }
        ListNode nextK = newhead.next;
        reverseGroup(head,k).next = reverseKGroup(nextK,k);
        return newhead;
    }
    
    public static ListNode reverseGroup(ListNode head, int k) {
        if(k == 1) return head;
        ListNode node = reverseGroup(head.next,--k);
        node.next = head;
        return node.next;
    }
}
