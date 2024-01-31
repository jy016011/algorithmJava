package beakjoon.dynamicProgramming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q11052_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1]; // dp[n]: max amount of purchasing n cards
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i = 1; i <= N; i++) { // the number of card in pack
            for (int j = i; j <= N; j++) { // the number of card to purchase
                dp[j] = Math.max(dp[j], dp[j - i] + P[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
