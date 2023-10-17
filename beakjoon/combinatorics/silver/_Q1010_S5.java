package beakjoon.combinatorics.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q1010_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        int[][] dpMem = new int[30][30];
        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(combination(M, N, dpMem)).append("\n");
        }
        System.out.println(stringBuilder);
    }
    public static int combination(int m, int n, int[][] dpMem){
        if (dpMem[m][n] > 0)
            return dpMem[m][n];

        if (n == 0 || m == n)
            return dpMem[m][n] = 1;

        return dpMem[m][n] = combination(m - 1, n - 1, dpMem) + combination(m - 1, n, dpMem);

    }
}
