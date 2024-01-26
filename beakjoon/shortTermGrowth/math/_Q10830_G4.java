package beakjoon.shortTermGrowth.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q10830_G4 {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        long[][] matrix = new long[N][N];
        long B = Long.parseLong(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken()) % 1000;
            }
        }
        long[][] result = divideAndConquer(matrix, B);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stringBuilder.append(result[i][j]).append(" ");
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private static long[][] divideAndConquer(long[][] A, long B) {
        if (B == 1L) {
            return A;
        }
        long[][] temp = divideAndConquer(A, B / 2);

        if (B % 2L == 1) {
            return matrixMulti(matrixMulti(temp, temp), A);
        }

        return matrixMulti(temp, temp);
    }

    private static long[][] matrixMulti(long[][] a, long[][] b) {
        long[][] multiMatrix = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += a[i][k] * b[k][j];
                }
                multiMatrix[i][j] = sum % 1_000;
            }
        }
        return multiMatrix;
    }
}
