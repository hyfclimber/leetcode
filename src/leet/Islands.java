package leet;

public class Islands {

	
	static int ans = 0;
	static int tmp = 0;
    
    public static int maxAreaOfIsland(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    infect(grid, i, j, M, N);
                    ans = Math.max(tmp, ans);
                    tmp = 0;
                }
            }
        }
        return ans;
    }

    public static void infect(int[][] grid, int i, int j, int M, int N) {
        if (i < 0 || i >= M || j < 0 || j >= N || grid[i][j] != 1) return;
        grid[i][j] = 2;
        tmp++;
        if (i >= 2 && j >= 3) {
            System.out.println(i + " " + j + " tmp: " + tmp);
        }
        infect(grid, i - 1, j, M, N);
        infect(grid, i + 1, j, M, N);
        infect(grid, i, j - 1, M, N);
        infect(grid, i, j + 1, M, N);
    }
    
    public static void main(String[] args) {
    	int[][] test = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
    	int max = maxAreaOfIsland(test);
    	System.out.println(max);
	}

}


