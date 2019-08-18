import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int maxLevelSum(TreeNode root) {
      if (root == null) {
          return 0;
      }
      
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
      int res = 0;
      int maxValue = Integer.MIN_VALUE;
      int level = 1;
      while (!q.isEmpty()) {
          int size = q.size();
          int levelSum = 0;
          
          for (int i = 0; i < size; i++) {
              TreeNode node = q.poll();
              levelSum += node.val;
              if (node.left != null) { q.offer(node.left); }
              if (node.right != null) { q.offer(node.right); }
          }
          
          if (levelSum > maxValue) {
              maxValue = levelSum;
              res = level;
          }
          level++;
      }
      return res;
  }
}