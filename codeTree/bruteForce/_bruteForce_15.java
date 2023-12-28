package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _bruteForce_15 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 2; j++) {
                for (int k = i; k < N; k++) {
                    for (int l = 0; l < N - 2; l++) {
                        if (i == k) {
                            if (j <= l && l <= j + 2 || l <= j && j <= l + 2) {
                                continue;
                            }
                        }
                        max = Math.max(
                                max,
                                matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                                        matrix[k][l] + matrix[k][l + 1] + matrix[k][l + 2]);
                    }
                }
            }
        }
        System.out.println(max);
    }
}