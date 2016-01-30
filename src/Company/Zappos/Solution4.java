/*
 *  Code by Jiadong Wu. No CopyRight.
 */
package Company.Zappos;

/**
 *
 * @author Wu
 */
public class Solution4 {

    static String isitpossible(int a, int b, int c, int d) {
        while (c > a || d > b) {
            if (c == d) {
                return "No";
            } else if (c > d) {
                c -= d;
            } else {
                d -= c;
            }
        }
        if (c == a && d == b) {
            return "Yes";
        }
        return "No";
    }
}
