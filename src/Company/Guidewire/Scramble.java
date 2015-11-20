/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Guidewire;

/**
 *
 * @author Wu
 */
public class Scramble {

    public static void main(String[] args) {
        Scramble sc = new Scramble();
        //sc.scrambleCount(1000, 9999);
        sc.scrambleCount(100, 999);
    }

    public int scrambleCount(int a, int b) {
        if (a >= b) {
            return 0;
        }

        int count = 0;
        for (int i = a; i < b; i++) {
            for (int j = b; j > i; j--) {
                if (isScramble(Integer.toString(i), Integer.toString(j))) {
                    count++;
                }
            }
        }

        System.out.println(count);
        return count;
    }
    /*
     Second method: comes up with DP naturally
     f[n][i][j] means isScramble(s1[i: i+n], s2[j: j+n])
     f[n][i][j] = f[k][i][j] && f[n - k][i+k][j+k]
     || f[k][i][j+n-k] && f[n-k][i+k][j]
  
     */

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.length() == 0 || s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        boolean[][][] rst = new boolean[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rst[0][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = n - len; i >= 0; i--) {
                for (int j = n - len; j >= 0; j--) {
                    boolean r = false;
                    for (int k = 1; k < len && r == false; k++) {
                        r = (rst[k - 1][i][j] && rst[len - k - 1][i + k][j + k]) || (rst[k - 1][i][j + len - k] && rst[len - k - 1][i + k][j]);
                    }
                    rst[len - 1][i][j] = r;
                }
            }
        }

        return rst[n - 1][0][0];
    }
}
