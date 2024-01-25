package beakjoon.shortTermGrowth.q12685_G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q12685_G5_Improved {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];
        int K = Integer.parseInt(stringTokenizer.nextToken()); // max weight
        int[] dp = new int[K + 1];
        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            weights[i] = Integer.parseInt(stringTokenizer.nextToken());
            values[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int k = K; k >= weights[i]; k--) {
                dp[k] = Math.max(dp[k], dp[k - weights[i]] + values[i]);
            }
        }
        System.out.println(dp[K]);
    }
}
