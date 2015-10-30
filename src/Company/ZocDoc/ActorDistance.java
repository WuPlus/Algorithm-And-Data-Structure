/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.ZocDoc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Wu
 */
public class ActorDistance {

    /**
     * Compute the distance between two actors
     *
     * @param actorToMoive
     * @param movieToActor
     * @param name1
     * @param name2
     * @return distance
     */
    public static int computeDistance(HashMap<String, List<String>> actorToMoive,
            HashMap<String, List<String>> movieToActor, String name1, String name2) {
        HashSet<String> visited = new HashSet();
        int distance = 0;
        visited.add(name1);
        while (!visited.contains(name2)) {
            distance++;

            Iterator<String> i = visited.iterator();
            while (i.hasNext()) {
                List<String> movielist = actorToMoive.get(i.next());
                Iterator<String> i2 = movielist.iterator();
                while (i2.hasNext()) {
                    String movie = i2.next();
                    List<String> actorlist = movieToActor.get(movie);
                    visited.addAll(actorlist);
                }
                System.out.println("here");
                break;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> actorToMoive = new HashMap();
        HashMap<String, List<String>> movieToActor = new HashMap();
        actorToMoive.put("Tom", Arrays.asList("b"));
        actorToMoive.put("Jame", Arrays.asList("b", "c"));
        actorToMoive.put("Ane", Arrays.asList("c"));
        movieToActor.put("b", Arrays.asList("Tom", "Jame"));
        movieToActor.put("c", Arrays.asList("Jame", "Ane"));
        int result = ActorDistance.computeDistance(actorToMoive, movieToActor, "Tom", "Ane");
        System.out.println(result);
    }
}
