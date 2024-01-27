package beakjoon.shortTermGrowth.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q15486_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        int[] dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            T[i] = Integer.parseInt(stringTokenizer.nextToken());
            P[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N + 1; i++) {
            max = Math.max(max, dp[i]);
            int nextWortT = i + T[i];
            if (nextWortT > N + 1) {
                continue;
            }
            dp[nextWortT] = Math.max(dp[nextWortT], max + P[i]);
        }
        System.out.println(max);
    }
}
