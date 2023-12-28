package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _bruteForce_4 {

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
                max = Math.max(max, matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]);
            }
        }
        System.out.println(max);
    }
}
