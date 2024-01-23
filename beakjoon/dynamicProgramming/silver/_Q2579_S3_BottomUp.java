package beakjoon.dynamicProgramming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2579_S3_BottomUp {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] scores = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(bufferedReader.readLine());
        }
        dp[0] = scores[0];
        if (N >= 2) {
            dp[1] = scores[0] + scores[1];
        }
        if (N >= 3) {
            dp[2] = Math.max(dp[0], scores[1]) + scores[2];
        }
        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + scores[i - 1]) + scores[i];
        }
        System.out.println(dp[N - 1]);
    }
}
