package beakjoon.dynamicProgramming.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q2240_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        int W = Integer.parseInt(stringTokenizer.nextToken());
        int[][] dp = new int[W + 1][T + 1];
        for (int t = 1; t <= T; t++) {
            int tree = Integer.parseInt(bufferedReader.readLine());
            for (int w = 0; w <= W; w++) {
                // get plum
                if (w == 0 && tree == 1) {
                    dp[w][t] = dp[w][t - 1] + 1;
                    continue;
                }
                if (tree == 2 && w % 2 == 1) {
                    dp[w][t] = Math.max(dp[w - 1][t - 1], dp[w][t - 1]) + 1;
                    continue;
                }
                if (tree == 1 && w % 2 == 0) {
                    dp[w][t] = Math.max(dp[w - 1][t - 1], dp[w][t - 1]) + 1;
                    continue;
                }
                // or miss plum
                if (w > 0) {
                    dp[w][t] = Math.max(dp[w - 1][t - 1], dp[w][t - 1]);
                }
            }
        }
        int answer = 0;
        for (int[] row : dp) {
            for (int value : row) {
                answer = Math.max(answer, value);
            }
        }
        System.out.println(answer);
    }
}
