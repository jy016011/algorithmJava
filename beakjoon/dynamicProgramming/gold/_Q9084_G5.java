package beakjoon.dynamicProgramming.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q9084_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] coins = new int[N];
            int[] dp = new int[10_001];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int i = 0; i < N; i++) {
                int coin = Integer.parseInt(stringTokenizer.nextToken());
                coins[i] = coin;
            }

            int M = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= M; j++) {
                    int beforeAmount = j - coins[i];
                    if (beforeAmount > 0) {
                        dp[j] += dp[beforeAmount];
                    } else if (beforeAmount == 0) {
                        dp[j]++;
                    }
                }
            }
            stringBuilder.append(dp[M]).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }
}
