package beakjoon.dynamicProgramming.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q2293_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int[] coins = new int[n];
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                int beforeAmount = j - coins[i];
                if (beforeAmount > 0) {
                    dp[j] += dp[beforeAmount];
                } else if (beforeAmount == 0) {
                    dp[j]++;
                }
            }
        }
        System.out.println(dp[k]);
    }
}
