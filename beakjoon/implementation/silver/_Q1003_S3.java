package beakjoon.implementation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q1003_S3 {
    static int[] dpFibo;
    static int[][] dpCnt ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        dpFibo = new int[41];
        dpFibo[0] = 0;
        dpFibo[1] = 1;
        dpCnt = new int[41][2];
        dpCnt[0][0] = 1;
        dpCnt[0][1] = 0;
        dpCnt[1][0] = 0;
        dpCnt[1][1] = 1;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            fibo(n);
            sb.append(dpCnt[n][0]).append(" ");
            sb.append(dpCnt[n][1]).append("\n");
        }
        System.out.println(sb);
    }
    public static int fibo(int n){
        if (dpFibo[n] > 0)
            return dpFibo[n];

        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        dpFibo[n] = fibo(n - 1) + fibo(n - 2);
        dpCnt[n][0] = dpCnt[n - 1][0] + dpCnt[n - 2][0];
        dpCnt[n][1] = dpCnt[n - 1][1] + dpCnt[n - 2][1];
        return dpFibo[n];
    }
}
