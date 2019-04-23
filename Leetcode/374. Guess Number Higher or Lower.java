class Solution {
  private int guess(int n) { return n; }
  public int guessNumber(int n) {
      int l = 1;
      int r = n;
      
      while (l <= r) {
          int m = l + (r - l) / 2;
          
          if (guess(m) == 0) { return m; }
          if (guess(m) == 1) {
              l = m + 1;
          } else {
              r = m - 1;
          }
      }
      
      return l;
  }
}