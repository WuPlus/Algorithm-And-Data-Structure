/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wu
 */
public class LetterCombinationOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList();
        int length = digits.length();
        if (length == 0) {
            return result;
        }
        result.add("");
        for (int i = 0; i < length; i++) {
            char c = digits.charAt(i);
            int size = result.size();
            while (size != 0) {
                String prefix = result.poll();
                switch (c) {
                    case '2':
                        for (char cc = 'a'; cc <= 'c'; cc++) {
                            result.add(prefix + cc);
                        }
                        break;
                    case '3':
                        for (char cc = 'd'; cc <= 'f'; cc++) {
                            result.add(prefix + cc);
                        }
                        break;
                    case '4':
                        for (char cc = 'g'; cc <= 'i'; cc++) {
                            result.add(prefix + cc);
                        }
                        break;
                    case '5':
                        for (char cc = 'j'; cc <= 'l'; cc++) {
                            result.add(prefix + cc);
                        }
                        break;
                    case '6':
                        for (char cc = 'm'; cc <= 'o'; cc++) {
                            result.add(prefix + cc);
                        }
                        break;
                    case '7':
                        for (char cc = 'p'; cc <= 's'; cc++) {
                            result.add(prefix + cc);
                        }
                        break;
                    case '8':
                        for (char cc = 't'; cc <= 'v'; cc++) {
                            result.add(prefix + cc);
                        }
                        break;
                    case '9':
                        for (char cc = 'w'; cc <= 'z'; cc++) {
                            result.add(prefix + cc);
                        }
                        break;
                    default:
                        break;
                }
                size--;
            }
        }
        return result;
    }
}
