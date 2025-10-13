package MinMaxB;

public class WRowsCol {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int minRow = n;
        int minCol = m;
        int maxRow = -1;
        int maxCol = -1;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    if(i < minRow) minRow = i;
                    if(j< minCol)  minCol = j;
                    if(i > maxRow) maxRow = i;
                    if(j > maxCol) maxCol = j;
                }
            }
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}
