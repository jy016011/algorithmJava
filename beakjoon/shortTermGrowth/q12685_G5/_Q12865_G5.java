package beakjoon.shortTermGrowth.q12685_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q12865_G5 {
    private static int N, K;
    private static int result = Integer.MIN_VALUE;
    private static int[] weights, values;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        weights = new int[N + 1];
        values = new int[N + 1];
        K = Integer.parseInt(stringTokenizer.nextToken()); // max weight
        dp = new int[K + 1][N + 1]; // index is available weight
        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            weights[i] = Integer.parseInt(stringTokenizer.nextToken());
            values[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                if (weights[i] > k) {
                    dp[k][i] = dp[k][i - 1];
                    continue;
                }
                dp[k][i] = Math.max(dp[k - weights[i]][i - 1] + values[i], dp[k][i - 1]);
            }
        }
        System.out.println(dp[K][N]);
    }
}
