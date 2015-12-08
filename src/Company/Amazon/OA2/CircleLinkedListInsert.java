/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon.OA2;

/**
 *
 * @author Wu
 */
public class CircleLinkedListInsert {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Solution(ListNode head, int val) {
        if (head == null) {
            ListNode node = new ListNode(val);
            node.next = node;
            return node;
        }

        ListNode cur = head;

        do {
            if (val <= cur.next.val && val >= cur.val) {
                break;
            }
            if (cur.val > cur.next.val && (val < cur.next.val || val > cur.val)) {
                break;
            }
            cur = cur.next;
        } while (cur != head);

        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;
        return node;
    }
}
