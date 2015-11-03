/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.PocketGems;

import Util.UndirectedGraphNode;
import java.util.*;

/**
 *
 * @author Wu
 */
public class GraphClone {
    Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        UndirectedGraphNode c_node = new UndirectedGraphNode(node.label);
        map.put(node,c_node);
        for(UndirectedGraphNode un : node.neighbors){
            if(map.containsKey(un)){
                c_node.neighbors.add(map.get(un));
            }else{
                c_node.neighbors.add(cloneGraph(un));
            }
        }
        return c_node;
    }
}
