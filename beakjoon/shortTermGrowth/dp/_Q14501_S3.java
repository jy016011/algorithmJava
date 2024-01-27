package beakjoon.shortTermGrowth.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q14501_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            T[i] = Integer.parseInt(stringTokenizer.nextToken());
            P[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        if (T[1] + 1 <= N + 1) {
            dp[1] = P[1];
        }

        for (int i = 2; i <= N; i++) {
            if (i + T[i] > N + 1) {
                continue;
            }
            dp[i] = P[i];
            for (int j = 1; j < i; j++) {
                if (j + T[j] > i) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + P[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int value : dp) {
            max = Math.max(max, value);
        }
        System.out.println(max);
    }
}
