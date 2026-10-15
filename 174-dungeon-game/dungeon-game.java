class Solution {
    Integer dp[][];
    private int solve(int i, int j, int arr[][]) {
        int m = arr.length;
        int n = arr[0].length;
        if(i >= m || j >= n) return (int)(-1e7);
        if(i == m-1 && j == n-1) return Math.min(0, arr[i][j]); //if positive hp then we dont need that
        
        if(dp[i][j] !=null) return dp[i][j];

        int right = solve(i,j+1, arr);
        int down = solve(i+1, j, arr);

        int better = Math.max(right, down); //less negative is better path
        return dp[i][j] = Math.min(better + arr[i][j], 0);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        dp = new Integer[m][n];
        int ans = solve(0,0, dungeon);
        return Math.abs(ans)+1;
    }

}