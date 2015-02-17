/*
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
package Leetcode;

/**
 * 
 * @author Wu
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        String result = "";
        int pointA = a.length() - 1;
        int pointB = b.length() - 1;
        if (pointA < pointB) {
            String temp = a;
            a = b;
            b = temp;
            int temp2 = pointA;
            pointA = pointB;
            pointB = temp2;
        }
        int sign = 0;
        int digitA, digitB, sum;
        while (pointA >= 0 && pointB >= 0) {
            digitA = Character.getNumericValue(a.charAt(pointA));
            digitB = Character.getNumericValue(b.charAt(pointB));
            sum = digitA + digitB + sign;
            if (sum == 3) {
                result = "1" + result;
                sign = 1;
            } else if (sum == 2) {
                result = "0" + result;
                sign = 1;
            } else if (sum == 1) {
                result = "1" + result;
                sign = 0;
            } else {
                result = "0" + result;
                sign = 0;
            }
            pointA--;
            pointB--;
        }
        while (pointA >= 0) {
            digitA = Character.getNumericValue(a.charAt(pointA));
            sum = digitA + sign;
            if (sum == 2) {
                result = "0" + result;
                sign = 1;
            } else if (sum == 1) {
                result = "1" + result;
                sign = 0;
            } else {
                result = "0" + result;
                sign = 0;
            }
            pointA--;
        }
        if (sign == 1) {
            result = "1" + result;
        }
        return result;
    }
}
