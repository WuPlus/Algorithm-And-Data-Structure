/*
 * Find loops in linkedlist
 */
package Company.Amazon.OA2;

/**
 *
 * @author Wu
 */
public class FindLoopsInList {

    public class ListNode {

        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
    
    /**
     * check whether LinkedList has a loop without modifying List
     * @param head
     * @return 
     */
    public boolean detectLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Find the start pointer of the loop
     * @param head
     * @return 
     */
    public ListNode findLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow2 = head;
                while(slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
            }
        }
        return null;
    }
}
