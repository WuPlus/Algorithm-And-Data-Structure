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
public class Solution024 {

    public ListNode swapPairs(ListNode head) {
        ListNode myNode = new ListNode(1);
        myNode.next = head;
        ListNode current = myNode;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            current.next = second;
            first.next = second.next;
            second.next = first;
            current = current.next.next;
        }
        return myNode.next;
    }
}
