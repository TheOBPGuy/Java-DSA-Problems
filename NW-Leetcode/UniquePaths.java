import java.util.*;

public class UniquePaths {

    /**
     * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
     *
     * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     *
     * The test cases are generated so that the answer will be less than or equal to 2 * 109.
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        // This problem will be solved using dynamic programming
        int[][] dp = new int[m][n];
        // Fill the first row and first column with 1 in the beginning
        for (int i = 0 ; i < dp.length; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[i][0] = 1;
        }

        // Use of Tabulization and Memoization
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

    }
}
