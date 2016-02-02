/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.LiveRamp;

import java.util.*;

/**
 *
 * @author Wu
 */
public class FrogJump {

    /**
     * Solution for frog Jump
     *
     * @param A
     * @param X Distance
     * @param D The max step that frog can jump
     * @return
     */
    public static int solution(int[] A, int X, int D) {
        int totalTime = A.length;
        Set<Integer> route = new HashSet();
        for (int i = 1; i <= D; i++) {
            route.add(i);
        }
        for (int i = 0; i < totalTime; i++) {
            //color the route
            for (int j = 1; j <= D; j++) {
                int temp = A[i] + j;
                if (temp <= X) {
                    route.add(temp);
                }
            }
            //check if all route has been colored
            if (route.size() == X) {
                return i;
            }
        }
        return -1;
    }

    /**
     * For test
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] time = {4, 5, 2, 8, 3};
        System.out.println(solution(time, 7, 3));
    }

}
