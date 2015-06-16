/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Wu
 */
public class HappyNumber {

    Set<Integer> set = new HashSet();

    public boolean isHappy(int n) {
        if (!set.add(n)) {
            return false;
        }
        int temp = n;
        int nn = 0;
        while (temp > 0) {
            nn += (temp % 10) * (temp % 10);
            temp = temp / 10;
        }
        if (nn == 1) {
            return true;
        } else {
            System.out.println(n);
            return isHappy(nn);
        }
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(3));
    }
}
