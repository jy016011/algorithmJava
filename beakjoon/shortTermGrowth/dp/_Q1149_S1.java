package beakjoon.shortTermGrowth.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q1149_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] values = new int[N][3];
        int[][] dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 3; j++) {
                values[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        dp[0][0] = values[0][0];
        dp[0][1] = values[0][1];
        dp[0][2] = values[0][2];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + values[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + values[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + values[i][2];
        }
        System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
    }
}
