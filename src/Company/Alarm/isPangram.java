/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Alarm;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Wu
 */
public class isPangram {

    /**
     * You are given N strings, these strings consist of lower-case letters ('a' - 'z') and space
     * only. Your task is to find whether the string is pangram or not. If string is pangram print 1
     * otherwise print 0.
     *
     * @param input
     * @return
     */
    public int isPangram(String input) {
        int len = input.length();
        if (len < 26) {
            return 0;
        }
        Set<Character> alphabet = new HashSet();
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if(c != ' '){
                alphabet.add(c);
            }
        }
        return (alphabet.size() == 26)?1:0;
    }
}
