package afterTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ParkingCar {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int[][] dp = new int[N + 1][2];
        dp[N][0] = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int speed = dp[i][1];
            int time = dp[i][0];
            for (int j = -K; j <= K; j++) {
                int nextSpeed = speed + j;
                if (i + nextSpeed > N || nextSpeed <= 0) {
                    continue;
                }
                if (i + nextSpeed == N) {
                    System.out.println(i);
                    System.out.println(nextSpeed);
                    System.out.println(time);
                    if (nextSpeed <= K) {
                        dp[i + nextSpeed][0] = Math.min(dp[i + nextSpeed][0], time + 1);
                    }
                    continue;
                }
                if (dp[i + nextSpeed][0] == 0 || dp[i + nextSpeed][0] > time + 1) {
                    dp[i + nextSpeed][0] = time + 1;
                    dp[i + nextSpeed][1] = nextSpeed;
                } else if (dp[i + nextSpeed][0] == time + 1) {
                    dp[i + nextSpeed][1] = Math.min(nextSpeed, dp[i + nextSpeed][1]);
                }
            }
        }
        for (int[] v :
                dp) {
            System.out.println(Arrays.toString(v));
        }
//        dp[N][0] = Integer.MAX_VALUE;
//        for (int i = N - 1; i >= N - K; i--) {
//            int beforeTime = dp[i][0];
//            int beforeSpeed = dp[i][1];
//
//            if (beforeSpeed - K <= K) {
//                dp[N][0] = Math.min(beforeTime + 1, dp[N][0]);
//            }
//        }
        System.out.println(dp[N][0]);
    }
}
