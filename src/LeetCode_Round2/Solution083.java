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
public class Solution083 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode previous = head;
        ListNode node = head;
        while (node != null) {
            if (node.val == previous.val) {
                node = node.next;
            } else {
                previous.next = node;
                previous = node;
            }
        }
        previous.next = node;
        return head;
    }
}
