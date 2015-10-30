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
public class PartitionList {
    static ListNode partition(ListNode head, int x) {
        ListNode list1head = new ListNode(0);
        ListNode list2head = new ListNode(0);
        ListNode curr1 = list1head;
        ListNode curr2 = list2head;
        while(head != null){
            if(head.val < x){
                curr1.next = head;
                curr1 = curr1.next;
            }else{
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = list2head.next;
        return list1head.next;
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        partition(n1,2);
    }
}
