public class RottenOranges {
    static class Pair{
      int r;
      int c;
      int t;

      Pair(int r, int c, int t){
        this.r  = r;
        this.c = c;
        this.t = t;
      }
    }

    public int orangeRotting(int[][] grid){
      Queue<Pair> q = new ArrayDeque<>();

      int fresh = 0, maxTime = 0;

      for(int i=0; i<grid.length; i++){
        for(int j=0; j<grid[0].length; j++){
          if (grid[i][j] == 2) {
            q.add(new Pair(i, j, 0));
          }else if (grid[i][j] ==1) {
            fresh++;
          }
        }
      }

      int dr[] = {-1, 1, 0, 0};
      int dc[] = {0, 0 , -1, 1};

      while (!q.isEmpty()) {
         Pair curr = q.remove();

         for(int d=0; d<dr.length; d++){
            int r = curr.r + dr[d];
            int c = curr.c + dc[d];

            if (r >=0 && r < grid.length && c>=0 && c < grid[0].length && grid[r][c] == 1) {
              q.add(new Pair(r, c, curr.t+1));
              grid[r][c] = 2;
              maxTime = curr.t + 1;
              fresh--;
            }
         }
      }

      if (fresh>0) {
        return -1;
      }

      return maxTime;
    }
}
