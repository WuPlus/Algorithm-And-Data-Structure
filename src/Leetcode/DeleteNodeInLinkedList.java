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
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        int nextvalue;
        if(node.next == null){
            return;
        }
        while(node.next.next != null){
            nextvalue = node.next.val;
            node.val = nextvalue;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
        return;
    }
}
