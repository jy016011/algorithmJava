package beakjoon.dynamicProgramming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2579_S3_TopDown {
    private static int[] dp, scores;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        scores = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(bufferedReader.readLine());
        }
        dp[0] = scores[0];
        System.out.println(recursive(N - 1));
    }

    private static int recursive(int N) {
        if (N < 0) {
            return 0;
        }
        if (dp[N] == 0) {
            dp[N] = Math.max(recursive(N - 2), recursive(N - 3) + scores[N - 1]) + scores[N];
        }

        return dp[N];
    }
}
