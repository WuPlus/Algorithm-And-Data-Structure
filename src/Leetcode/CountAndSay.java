/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class CountAndSay {

    Map<String, String> map = new HashMap<String, String>();

    public String countAndSay(int n) {
        String current = 1 + "";
        while (n > 1) {
            //check if current string exists in the map
            if (!map.containsKey(current)) {
                int length = current.length();
                System.out.println("->" + current);
                char digit = current.charAt(0);
                int count = 1;
                String newSequence = "";
                for (int i = 1; i < length; i++) {
                    if (current.charAt(i) == digit) {
                        count++;
                    } else {
                        newSequence = newSequence + "" + count + "" + digit;
                        digit = current.charAt(i);
                        count = 1;
                    }
                }
                newSequence = newSequence + "" + count + "" + digit;
                map.put(current, newSequence);
                current = newSequence;
            } else {
                current = map.get(current);
            }
            n--;
        }
        return current;
    }

    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();
        cas.countAndSay(2);
    }
}
