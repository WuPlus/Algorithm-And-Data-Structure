/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.*;

/**
 *
 * @author Wu
 */
public class WordLadder {

    static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> visit = new HashSet();
        LinkedList<String> queue = new LinkedList();
        visit.add(beginWord);
        queue.add(beginWord);
        queue.add(null);
        int level = 1;

        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str != null) {
                char[] chars = str.toCharArray();
                int length = chars.length;
                for (int i = 0; i < length; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        char temp = chars[i];
                        chars[i] = j;
                        String s = new String(chars);
                        if (s.equals(endWord)) {
                            return level + 1;
                        }
                        if (!visit.contains(s) && wordList.contains(s)) {
                            queue.add(s);
                            visit.add(s);
                        }
                        chars[i] = temp;
                    }
                }
            } else {
                level++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
            Iterator<String> i = queue.iterator();
            while (i.hasNext()) {
                System.out.print(i.next() + " ");
            }
            System.out.println("");
        }

        return 0;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet();
        set.add("hot");
        set.add("dog");
        set.add("dot");
        int r = ladderLength("hot", "dog", set);
        System.out.println(r);
    }
}
