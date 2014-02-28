package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

  static class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
      label = x;
      neighbors = new ArrayList<UndirectedGraphNode>();
    }
  };

  static class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
      Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
      if (node == null) {
        return null;
      }
      return clone(node, map);
    } // end cloneGraph()
    
    public UndirectedGraphNode clone(UndirectedGraphNode node, 
        Map<Integer, UndirectedGraphNode> map) {
      if (map.containsKey(node.label)) {
        return map.get(node.label);
      } // end if
      
      UndirectedGraphNode newNode = new UndirectedGraphNode(node.label), temp;
      map.put(node.label, newNode);
      
      for (UndirectedGraphNode neib: node.neighbors) {
        temp = clone(neib, map);
        newNode.neighbors.add(temp);
      } // end for
      
      
      
      return newNode;
      
    } // end clone()
  } // end class Solution
}
