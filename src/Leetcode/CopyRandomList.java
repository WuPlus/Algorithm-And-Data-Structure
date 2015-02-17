/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.HashMap;

/**
 *
 * @author Wu
 */
public class CopyRandomList {

    static HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur, newhead, newcur;
        cur = head;
        newhead = new RandomListNode(head.label);
        map.put(head.hashCode(), newhead);
        newcur = newhead;
        cur = cur.next;
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            newcur.next = newNode;
            map.put(cur.hashCode(), newNode);
            cur = cur.next;
            newcur = newcur.next;
        }

        cur = head.random;
        newcur = newhead;
        while (cur != null) {
            if (map.containsKey(cur.hashCode())) {
                newcur.random = map.get(cur.hashCode());
            } else {
                RandomListNode newNode = new RandomListNode(cur.label);
                newcur.random = newNode;
            }
            cur = cur.random;
            newcur = newcur.random;
        }
        return newhead;
    }

    static class RandomListNode {

        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    };
    
    public static void main(String[] args) {
        RandomListNode r = new RandomListNode(-1);
        RandomListNode r1 = new RandomListNode(-1);
        r.random = r1;
        RandomListNode newhead = copyRandomList(r);
        System.out.println(newhead.label);
    }
}
