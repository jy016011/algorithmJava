package beakjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q1932_IntTriangle {
    static int n;
    static int[][] tri;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tri = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = tri[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    dp[i][j] = tri[i][j] + dp[i-1][j];
                else if(j == i)
                    dp[i][j] = tri[i][j] + dp[i-1][j-1];
                else {
                    dp[i][j] = Math.max(tri[i][j] + dp[i-1][j-1], tri[i][j] + dp[i-1][j]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[n-1][i], max);
            System.out.println(dp[n-1][i]);
        }
        System.out.println(max);
    }
}
