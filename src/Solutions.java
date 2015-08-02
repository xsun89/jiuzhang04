import java.util.ArrayList;

/**
 * Created by xsun on 15-07-31.
 */
public class Solutions {
    public int longestCommSubsequence(String A, String B) {
        int n = A.length();
        int m = B.length();
        int f[][] = new int[n+2][m+2];
        for(int i=0; i<n; i++){
            for(int j=0; j<m;j++){
                f[i+1][j+1] = Math.max(f[i][j+1], f[i+1][j]);
                if(A.charAt(i) == B.charAt(j)){
                    f[i+1][j+1] = f[i][j] +1;
                }
            }
        }
        return f[n][m];
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle){
        if(triangle == null || triangle.size() == 0){
            return 0;
        }

        int n = triangle.size();
        int[][] sum = new int[n][n];
        for(int i = 0; i<n; i++){
            sum[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                sum[i][j] = Math.min(sum[i+1][j], sum[i+1][j+1]) + triangle.get(i).get(j);
            }
        }

        return sum[0][0];
    }

    public int minPathSum(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];

        sum[0][0] = grid[0][0];
        for(int i=0; i<n;i++){
            sum[0][i] = sum[0][i-1]+grid[0][i];
        }

        for (int i = 0; i <m ; i++) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
            }
        }

        return sum[m-1][n-1];
    }

    public int climbStairs(int n) {
        if(n <= 1){
            return n;
        }

        int[] sum = new int[n+1];
        sum[0] = 1;
        sum[1] = 1;
        for(int i=2; i<=n;i++){
            sum[i] = sum[i-1] + sum[i-2];
        }

        return sum[n];
    }

    public boolean canJump(int[] A){
        boolean[] can = new boolean[A.length];
        can[0] = true;

        for (int i = 0; i <A.length ; i++) {
            for (int j = 0; j < i ; j++) {
                if(can[j] && j+A[j]>=i){
                    can[i] = true;
                    break;
                }
            }
        }

        return can[A.length-1];
    }


}
