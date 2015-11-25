/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

/**
 *
 * @author Wu
 */
public class MergeTwoSortedList {

    class ListNode {

        public int val;
        public ListNode next;

        ListNode(int i) {
            this.val = i;
        }
    }

    ListNode mergeTwoSoredList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        cur.next = (l1 != null) ? l1 : l2;
        return head.next;
    }
}
