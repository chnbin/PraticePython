import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
      int[] inDegree = new int[numCourses];
      Map<Integer, ArrayList<Integer>> g = new HashMap<Integer, ArrayList<Integer>>();
      
      for (int i = 0; i < numCourses; i++) {
          g.put(i, new ArrayList<Integer>());
      }
      
      for (int[] pre: prerequisites) {
          inDegree[pre[0]]++;
          g.get(pre[1]).add(pre[0]);
      }

      Queue<Integer> queue = new LinkedList<>();
      
      for (int i = 0; i < inDegree.length; i++) {
          if (inDegree[i] == 0) {
              queue.offer(i);
          }
      }
      
      List<Integer> set = new ArrayList<>();
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          
          for (int i = 0; i < size; i++) {
              int v = queue.poll();
              set.add(v);
              for (int w: g.get(v)) {
                  inDegree[w]--;
                  if (inDegree[w] == 0) {
                      queue.offer(w);
                  }
              }
          }
      }
      
      int[] res = new int[numCourses];
      if (set.size() == numCourses) {
          for (int i = 0; i < numCourses; i++) {
              res[i] = set.get(i);
          }
          return res;
      }
      return new int[0];
  }
}