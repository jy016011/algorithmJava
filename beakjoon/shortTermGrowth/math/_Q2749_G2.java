package beakjoon.shortTermGrowth.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2749_G2 {
    private static final long[][] A = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bufferedReader.readLine());
        System.out.println(divideAndConquer(N - 1)[0][0]);
    }

    private static long[][] divideAndConquer(long exp) {
        if (exp == 1 || exp == 0) {
            return A;
        }

        long[][] temp = divideAndConquer(exp / 2);

        temp = multiplyMatrix(temp, temp);
        if (exp % 2 == 1L) {
            temp = multiplyMatrix(temp, A);
        }

        return temp;
    }

    private static long[][] multiplyMatrix(long[][] a, long[][] b) {
        long[][] multi = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    multi[i][j] += a[i][k] * b[k][j];
                }
                multi[i][j] %= 1_000_000;
            }
        }
        return multi;
    }
}