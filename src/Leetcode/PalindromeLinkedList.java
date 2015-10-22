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
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        int size = getSize(head);
        if(size == 1) return true;
        if(size == 2) return (head.val == head.next.val);
        Flag f = new Flag();
        isPalindromePerNode(head,f,0,size);
    }
    
    public int getSize(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    
    public boolean isPalindromePerNode(ListNode head, ListNode symmetric, int index, int size){
        System.out.println(index +"-"+size);
        if(index == size/2 && size%2 == 1){
            symmetric.val = head.next.val;
            symmetric.next = head.next.next;
            return true;
        }
        if(index == (size/2 - 1) && size%2 == 0){
            symmetric.val = head.next.next.val;
            symmetric.next = head.next.next.next;
            return (head.val == head.next.val);
        }
        ListNode newNode = new ListNode(0);
        boolean b = isPalindromePerNode(head.next,newNode,++index,size);
        symmetric.val = newNode.next.val;
        symmetric.next = newNode.next.next;
        return b&(head.val == symmetric.val);
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        PalindromeLinkedList p = new PalindromeLinkedList();
        System.out.println(p.isPalindrome(n1));
    }

    private class Flag {
        boolean flag;
    }
}
