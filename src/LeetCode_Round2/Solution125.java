/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode_Round2;

/**
 *
 * @author Wu
 */
public class Solution125 {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < j && !(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))) {
                i++;
            }
            while (i < j && !(Character.isLetter(s.charAt(j)) || Character.isDigit(s.charAt(j)))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
