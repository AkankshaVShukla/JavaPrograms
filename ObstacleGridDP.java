public class ObstacleGridDP {
	public static void main(String args[]){
		int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(matrix));
	}
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m==0  || n ==0 ) return 0;
        int memo[][] = new int[m][n];
        if(obstacleGrid[0][0] ==1)return 0;
        memo[0][0] =1;
       return paths(m-1, n-1,memo, obstacleGrid);
    }
    
    private static int paths(int row, int col, int[][] memo, int[][] grid){
        if(row<0 || col<0)return 0;
        if(row == 0 && col ==0)return 1;
        if(grid[row][col] == 1) memo[row][col] =0;
        else 
        memo[row][col] = paths(row-1, col, memo, grid) + paths(row, col-1, memo, grid);

       return memo[row][col];
    }
}
