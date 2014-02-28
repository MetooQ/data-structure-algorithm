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
      if (node == null) {
        return null;
      } // end if
      
      Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
      Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
      UndirectedGraphNode root, temp, item;

      root = new UndirectedGraphNode(node.label);
      map.put(node.label, node);
      queue.add(node);
      
      while (!queue.isEmpty()) {
        node = queue.poll();
        
        temp = map.get(node.label);
        
        for (UndirectedGraphNode neib: node.neighbors) {
          item = map.get(neib.label);
          if (item == null) {
            item = new UndirectedGraphNode(neib.label);
            map.put(neib.label, item);
            queue.add(neib);
          }
          temp.neighbors.add(item);
        } // end for
        
        
      } // end while
      
      return root;
    } // end cloneGraph()
  } // end class Solution
}
