/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basic.HITS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Wu
 */
public class Hits {

    static void hits(int[][] matrix, Set<Integer> root, double alpha) {
        Set<Integer> base = expandRoot(matrix, root);
        int len = base.size();
        int matrix_len = matrix.length;

        double[] auth = new double[matrix_len];
        double[] hub = new double[matrix_len];
        Arrays.fill(auth, 1);
        Arrays.fill(hub, 1);

        while (true) {
            double[] tmpAuth = new double[matrix_len];
            double[] tmpHub = new double[matrix_len];
            double maxAuth = Integer.MIN_VALUE;
            double maxHub = Integer.MIN_VALUE;

            for (int i : base) {
                for (int j = 0; j < len; j++) {
                    if (matrix[i][j] == 1) {
                        tmpHub[i] += hub[j];
                    }
                    if (matrix[j][i] == 1) {
                        tmpAuth[i] += auth[j];
                    }
                }
                maxAuth = Math.max(maxAuth, tmpAuth[i]);
                maxHub = Math.max(maxHub, tmpHub[i]);
            }

            for (int i : base) {
                tmpAuth[i] = tmpAuth[i] / maxAuth;
                tmpHub[i] = tmpHub[i] / maxHub;
            }

            double tmp = 0;
            for (int i = 0; i < len; i++) {
                tmp += Math.abs(tmpAuth[i] - auth[i]);
                tmp += Math.abs(tmpHub[i] - hub[i]);
            }
            if (tmp < alpha) {
                System.out.println("Authority " + Arrays.toString(tmpAuth));
                System.out.println("Hub " + Arrays.toString(tmpHub));
                break;
            }
            auth = tmpAuth;
            hub = tmpHub;
        }
    }

    static Set<Integer> expandRoot(int[][] matrix, Set<Integer> root) {
        Set<Integer> base = new HashSet();
        for (int i : root) {
            if(i == 2)
                System.out.println("");
            base.add(i);
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1) {
                    base.add(j);
                }
            }

            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    base.add(j);
                }
            }
        }
        return base;
    }

    public static void main(String[] args) {
        problem1();
        //problem2();
    }

    static void problem1() {
        int[][] network1 = {
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}
        };
        Set<Integer> root = new HashSet();
        root.add(0);
        root.add(1);
        root.add(2);
        root.add(3);
        hits(network1, root, 1);
    }

    static void problem2() {
        int[][] network1 = {
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 0, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0}
        };
        int[][] network2 = {
            {0, 1, 1, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1},
            {0, 0, 1, 0},
        };
        Set<Integer> root = new HashSet();
        root.add(0);
        root.add(1);
        root.add(2);
        root.add(3);
        root.add(4);
        hits(network1, root, 0.1);
        
        Set<Integer> root2 = new HashSet();
        root2.add(0);
        root2.add(1);
        root2.add(2);
        root2.add(3);
        hits(network2, root2, 0.01);
    }
}
