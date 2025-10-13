package FloodFill;

public class NumberOfClosedIslands {
    public void dfs(int grid[][], int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 0) {
            return;
        }

        grid[row][col] = 1;

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        //filling the edges of the grid to get the accurate closed islands
        for(int i=0; i<row; i++){
            dfs(grid, i, 0);    //left border
            dfs(grid, i, col-1);  //right border
        }

        for(int i=0; i<col; i++){
           dfs(grid, 0, i);      //top border
           dfs(grid, row-1, i);  //bottom border
        }

        int count = 0;
        for(int i=1; i<row-1; i++){
            for(int j=1; j<col-1; j++){
                if(grid[i][j] == 0){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}
