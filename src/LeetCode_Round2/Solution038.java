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
public class Solution038 {

    public String countAndSay(int n) {
        String current = "1";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (n > 1) {
            int len = current.length();
            int i = 1;
            count = 1;
            for (; i < len; i++) {
                if (current.charAt(i) == current.charAt(i - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(current.charAt(i - 1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(current.charAt(i - 1));
            current = sb.toString();
            sb = new StringBuilder();
            n--;
        }
        return current;
    }
}
