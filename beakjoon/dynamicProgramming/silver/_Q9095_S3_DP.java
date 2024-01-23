package beakjoon.dynamicProgramming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q9095_S3_DP {
    private static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            dp = new int[n + 4];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            dp[4] = 7;
            for (int i = 5; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            stringBuilder.append(dp[n]).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }
}
