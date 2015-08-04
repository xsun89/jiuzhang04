import java.util.ArrayList;

/**
 * Created by xsun on 15-07-31.
 */
public class Solutions {

    /** 价格表 */
    private final int[] PRICE_LIST_RAW = {
            1, 1,
            2, 5,
            3, 8,
            4, 9,
            5, 10,
            6, 17,
            7, 17,
            8, 20,
            9, 24,
            10, 30
    };
    private int[][] PRICE_LIST = new int[10][2];

    private void initPriceList() {
        for (int i = 0; i < PRICE_LIST.length; i++) {
            for (int j = 0; j < PRICE_LIST[i].length; j++) {
                PRICE_LIST[i][j] = PRICE_LIST_RAW[i * 2 + j];
            }
        }
    }
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
    /*
    我们将钢条左边切割下长度为 i 的一段，只对右边剩下的长度为 n-i 的一段继续进行切割（递归求解），
    对左边的一段不再进行切割。即问题分解的方式为：将长度为n 的钢条分解为左边开始一段，以及剩余部分继续分解的结果。
    这样，不做任何切割的方案就可以描述为：第一段的长度为n ，收益为 pn，剩余部分长度为0，对应的收益为r0=0。于是公式的简化版本：
    f(i) = max(p(i) + f(n-i)) (i=0, 1.....n)
     */
    public int getMax(int[] p, int n) {
        //System.out.println(n);
        if (n <= 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int tmp = getMax(p, n - i);
            System.out.println(i + "=" + tmp);
            max = Math.max(max, p[i - 1] + tmp);
        }

        return max;
    }

    public int getMax2(int[] p, int n){
        if(n<=0){
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++){
            max = Math.max(max, p[i-1] + getMax2(p, n-i));
        }

        return max;
    }
}
