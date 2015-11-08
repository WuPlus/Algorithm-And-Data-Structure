/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Wu
 */
public class WordBreak2 {

    static List<String> wordBreak(String s, Set<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        List<String>[] solutions = new List[length + 1];
        dp[0] = true;
        solutions[0] = new LinkedList();
        solutions[0].add("");

        for (int i = 0; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp[j] && wordDict.contains(word)) {
                    if (!dp[i]) {
                        dp[i] = true;
                        solutions[i] = new LinkedList<String>();
                    }
                    for (String str : solutions[j]) {
                        solutions[i].add(str + " " + word);
                    }
                }
            }
        }

        return solutions[length];
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet();
        //["cat","cats","and","sand","dog"]
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");

        List<String> res = wordBreak("catsanddog", set);
        Iterator<String> i = res.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
