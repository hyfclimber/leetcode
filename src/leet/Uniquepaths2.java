package leet;

public class Uniquepaths2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != 1)
            	if (i > 0 && j > 0) {
            		dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            	} else if (j > 0) {
                    dp[i][j] = dp[i][j - 1];
            	} else if (i > 0) {
            		dp[i][j] = dp[i - 1][j];
            	}
            }
        }
        return dp[m - 1][n - 1];
    }
}
