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
public class ReverseLinkedList2 {
    static ListNode positionN = null;
    static ListNode positionNnext = null;
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current = head;
        if(m == 1) {
            reverseN(head,m,n).next = positionNnext;
            return positionN;
        }else{
            while(m > 2){
                current = current.next;
                m--;
            }
            ListNode pre = current;
            reverseN(pre.next,m,n).next = positionNnext;
            pre.next = positionN;
            return head;
        }
        
    }
    
    public static ListNode reverseN(ListNode head, int m, int n){
        if(n == m) {
            positionN = head;
            positionNnext = head.next;
            return head;
        }
        ListNode node = reverseN(head.next, m, --n);
        node.next = head;
        return node.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        reverseBetween(l1,3,3);
    }
}
