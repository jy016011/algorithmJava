package beakjoon.shortTermGrowth.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q9461_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            long[] dp = new long[N + 1];
            dp[1] = 1;
            if (N > 1) {
                dp[2] = 1;
            }
            for (int i = 3; i < N + 1; i++) {
                dp[i] = dp[i - 2] + dp[i - 3];
            }
            stringBuilder.append(dp[N]).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }
}
