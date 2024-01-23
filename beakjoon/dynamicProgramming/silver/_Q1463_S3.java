package beakjoon.dynamicProgramming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q1463_S3 {
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        countCalculate(N, 0);
        System.out.println(result);
    }

    private static void countCalculate(int N, int count) {
        if (N == 1) {
            result = Math.min(count, result);
            return;
        }
        if (count > result) {
            return;
        }
        if (N % 3 == 0) {
            countCalculate(N / 3, count + 1);
        }
        if (N % 2 == 0) {
            countCalculate(N / 2, count + 1);
        }
        countCalculate(N - 1, count + 1);
    }
}
