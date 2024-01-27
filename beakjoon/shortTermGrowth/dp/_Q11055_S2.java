package beakjoon.shortTermGrowth.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q11055_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N + 1];
        int[] dp = new int[N + 1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        dp[1] = numbers[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = numbers[i];
            for (int j = 1; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[j] + numbers[i], dp[i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int number : dp) {
            max = Math.max(max, number);
        }
        System.out.println(max);
    }
}
