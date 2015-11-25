/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.BloomBurg;

import java.util.Set;

/**
 *
 * @author Wu
 */
public class WordBreak {

    boolean wordBreak(String s, Set<String> dict) {
        if (dict.contains(s)) {
            return true;
        }
        int length = s.length();
        boolean[] status = new boolean[length + 1];
        status[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (status[j] && dict.contains(s.substring(j, i))) {
                    status[i] = true;
                    break;
                }
            }
        }
        return status[length];
    }
}
