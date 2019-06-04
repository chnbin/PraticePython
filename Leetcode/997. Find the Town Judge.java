class Solution {
  public int findJudge(int N, int[][] trust) {
      int[] inDegree = new int[N + 1];
      int[] outDegree = new int[N + 1];
      
      for (int[] t: trust) {
          outDegree[t[0]]++;
          inDegree[t[1]]++;
      }
      
      for (int i = 1; i < N + 1; i++) {
          if (outDegree[i] == 0 && inDegree[i] == N - 1) {
              return i;
          }
      }
      
      return -1;
  }
}