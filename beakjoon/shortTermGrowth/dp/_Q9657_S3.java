package beakjoon.shortTermGrowth.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q9657_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] dp = new int[N + 4];
        dp[1] = 1; // 1: SK, 2: CY
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 1;
        for (int i = 5; i <= N; i++) {
            if (dp[i - 1] == 2 || dp[i - 3] == 2 || dp[i - 4] == 2) {
                dp[i] = 1;
                continue;
            }
            dp[i] = 2;
        }
        if (dp[N] == 1) {
            System.out.println("SK");
            return;
        }
        System.out.println("CY");
    }
}
