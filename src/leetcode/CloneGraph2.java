package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph2 {

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
      if (node == null) {
        return null;
      } // end if

      Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
      Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
      UndirectedGraphNode temp, newNode, current;

      queue.add(node);
      map.put(node.label, new UndirectedGraphNode(node.label));

      while (!queue.isEmpty()) {
        current = queue.poll();
        newNode = map.get(current.label);
        
        for (UndirectedGraphNode neib : current.neighbors) {
          temp = map.get(neib.label);
          if (temp != null) {
            newNode.neighbors.add(temp);
            continue;
          } // end if
          
          temp = new UndirectedGraphNode(neib.label);
          newNode.neighbors.add(temp);
          queue.add(neib);
          map.put(neib.label, temp);
        } // end for
      } // end while

      return map.get(node.label);
    } // end cloneGraph()

  } // end class Solution
}
